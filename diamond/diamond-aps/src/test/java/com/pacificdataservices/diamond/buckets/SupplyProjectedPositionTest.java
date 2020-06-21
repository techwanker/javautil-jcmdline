package com.pacificdataservices.diamond.buckets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.javautil.core.misc.Buckets;
import org.javautil.core.misc.DoubleBuckets;
import org.javautil.core.misc.MultiKey;
import org.javautil.core.misc.MultiKeyHashMap;
import org.javautil.core.misc.MultiKeyHashMapOfLists;
import org.javautil.core.text.SimpleDateFormatFactory;
import org.javautil.util.DateGenerator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.planning.Allocation;
import com.pacificdataservices.diamond.planning.AllocationMode;
import com.pacificdataservices.diamond.planning.data.PlanDataFactory;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.services.SpringBootTests;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class SupplyProjectedPositionTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private PlanningData pd;
	private DateGenerator dateGenerator;
	private ProjectedPosition projPos;
	private Collection<Supply> supplies;
	private boolean debugging = logger.isDebugEnabled();
	private SimpleDateFormat sdf = SimpleDateFormatFactory.getYyyyDashMmDashDd();
	private ArrayList<String> formats = new ArrayList<String>();
	// TODO need to add in a multiple part number

	@Before
	public void before() throws IOException {
		formats = new ArrayList<String>();
		formats.add("%8s");
		formats.add("%8s");
		formats.add("%8s");
		formats.add("%20s");
		logger.debug("before");
		logger.debug("before pd was null");
		pd = PlanDataFactory.getPlanningDataPlanned(new File(SpringBootTests.planGroup10DataFile));
		assertNotNull(pd);
		dateGenerator = pd.getDateGenerator();
		supplies = pd.getSuppliesById().values();
		assertNotNull(supplies);
		logger.debug("before - supplies.size{}", supplies.size());
		projPos = new ProjectedPosition(supplies, dateGenerator);
		assertNotNull(projPos);
		logger.debug("supplyProjectedPostitionTest before complete");

	}


	@Test
	public void test1() throws IOException {
		//before(); // TODO this should not be necessary WTF
		logger.debug("================= test1 begins");
		assertNotNull(supplies);
		for (Supply supply : supplies) {
			Buckets<Double> supplyProjPos = (supply.getProjectedPositionBuckets());
			assertNotNull(supplyProjPos);
		}
		MultiKeyHashMap<SupplyBuckets> projectedPosition = projPos.getSupplyBucketsMap();
		assertEquals(22, supplies.size());
		// TODO one of these is supposed to have two part numbers
		// assertEquals(23,projPos.getSupplyBucketsMap().size());
		logger.debug("size of projectPosition {}", projectedPosition.size());
		logger.debug("================= test1 ends");
	}
	@Test
	public void test88827_01_alt() throws IOException {
		before();

		assertNotNull(pd);
		Supply supply = pd.getSuppliesById().get("88827-001-00361569");
		assertNotNull(supply);
		double grossAvail = supply.getGrossAvailQty().doubleValue();
		//double allocated = supply.getQtyAllocated(AllocationMode.FIRST_PASS);
		Date availDate = supply.getAvailDate();
		logger.debug("supply avail date {} grossAvail",availDate, grossAvail);

		Buckets<Double> buckets = supply.getProjectedPositionBuckets();
		logger.debug("buckets {}",buckets);

		Date firstUsedBucketDate = buckets.getFirstUsedDate();
		logger.debug("firstBucketDate {}", firstUsedBucketDate);
		assertTrue(!firstUsedBucketDate.after(availDate));

		Date nextBucketDate = buckets.getNextBucketStartDate(firstUsedBucketDate);
		logger.debug("nextBucketDate {}", nextBucketDate);
		assertTrue(nextBucketDate.after(availDate));


		Double firstUsedBucketQty = buckets.getBucketData(firstUsedBucketDate);
		logger.debug("firstUsedBucketQty {}",firstUsedBucketQty);
		// ensure first non null, non zero bucket on or after avail date
		Collection<Allocation> allocations = supply.getAllocationsForBucket(AllocationMode.FIRST_PASS,firstUsedBucketDate,nextBucketDate);
		logger.debug("bucket Allocations {}", allocations);

		double firstBucketAllocQty  = supply.getQtyAllocatedBucket(AllocationMode.FIRST_PASS,firstUsedBucketDate,nextBucketDate);
		logger.debug("firstBucketAllocQty {}", firstBucketAllocQty);

		double expectedPosition = grossAvail - firstBucketAllocQty;
		logger.debug("expectedPosition {} firstUsedBucketQty {}",expectedPosition, firstUsedBucketQty);

		assertEquals(expectedPosition,firstUsedBucketQty,.05);

		TreeMap<Date,Double> bucketedPosition = buckets.getDateMap();
		for (Date bucketDate : bucketedPosition.keySet()) {
			Date beforeDate = buckets.getNextBucketStartDate(bucketDate);
			logger.debug("bucketDate {} beforeDate {} availDate ", bucketDate, beforeDate, availDate);
			if (beforeDate == null) {
				break;
			}
			Double bucketPosition = bucketedPosition.get(bucketDate);
			if (!availDate.before(beforeDate)) {
				assertNull(bucketPosition);
			} else {
				double allBucketAllocQty  = supply.getQtyAllocatedBucket(AllocationMode.FIRST_PASS,firstUsedBucketDate,beforeDate);
				logger.debug("firstBucketAllocQty {}", allBucketAllocQty);

				double allExpectedPosition = grossAvail - allBucketAllocQty;
				logger.debug("bucketDate {}",bucketDate);
				logger.debug("allExpectedPosition {} bucketPosition {}",allExpectedPosition, bucketPosition);

				assertEquals(allExpectedPosition,bucketPosition,.05);
			}
		}

	}


	@Test
	public void testGroupByFacilityItem() throws IOException {
	//	before();
		logger.debug("testGroupByFacilityItem: >>>>>");
		logger.debug("before groupBy \n{}\n====", projPos.format(8));
		MultiKeyHashMapOfLists<SupplyBuckets> grouped = projPos.groupBy(0, 5);
		assertEquals(5, grouped.size());
		int i = 0;
		for (Entry<MultiKey, ArrayList<SupplyBuckets>> e : grouped.entrySet()) {
			assertEquals(2, e.getKey().size());
			logger.debug("grouped: group " + i + " key " + e.getKey().format());

			int j = 0;
			for (SupplyBuckets v : e.getValue()) {
				// logger.debug("grouped: " + e.getKey().format() + " list entry # " + j );
				TreeMap<Date, Double> dateMappedDouble = v.getDateMap();
				assertTrue(dateMappedDouble.size() > 0);
				// String message = String.format("%d[%d] key: %s map
				// %s",i,j,e.getKey().format(),dateMappedDouble.toString());
				String message = String.format("   %s", dateMappedDouble.toString());
				logger.debug(message);
				j++;
			}
			i++;
		}

		logger.debug("######\n#####\ngrouped By\n {}", grouped.format(formats,8));
		logger.debug("testGroupByFacilityItem: <<<<<");
	}


	@Test
	public void testSum() throws IOException {
	//	before();
		MultiKeyHashMapOfLists<SupplyBuckets> grouped = projPos.groupBy(0, 1, 2, 5);
		MultiKeyHashMap<DoubleBuckets> summed = projPos.sum(grouped);
		logger.debug("summed #################################");
		logger.debug("summed.format()\n{}", summed.format());
		logger.debug("summed #################################");
	}

}
