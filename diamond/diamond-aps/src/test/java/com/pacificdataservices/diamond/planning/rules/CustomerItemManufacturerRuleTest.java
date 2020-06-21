package com.pacificdataservices.diamond.planning.rules;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.DataType;
import org.javautil.dataset.DatasetCrosstabber;
import org.javautil.dataset.DatasetIterator;
import org.javautil.dataset.DatasetMetadataImpl;
import org.javautil.dataset.ListOfMapsDataset;
import org.javautil.dataset.MatrixDataset;
import org.javautil.dataset.MutableDatasetMetadata;
import org.javautil.dataset.csv.DatasetCsvMarshaller;
import org.javautil.document.crosstab.CrosstabColumns;
import org.javautil.util.Day;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeCustMfrId;
import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;
import com.pacificdataservices.diamond.planning.services.SpringBootTests;
import com.pacificdataservices.diamond.rules.CustomerItemManufacturerRules;

public class CustomerItemManufacturerRuleTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	// TODO WTF when run as a maven install this runs even when @Test is commmented out
	// TODO but it works fine with in eclipse
	@Test
	public void test1() throws IOException {
		CustomerItemManufacturerRules rules = new CustomerItemManufacturerRules(getOeCustMfrList());
		logger.debug("{}",rules.toString());
		assertTrue(rules.isApprovedMfr(1, 10, 100, new Day(2018,5,6)));
		assertFalse(rules.isApprovedMfr(1, 10, 101, new Day(2018,5,6)));
		assertTrue(rules.isApprovedMfr(10, 11, 100, new Day(2018,5,6)));
	}
	
	CustomerItemManufacturerRules getRules() throws IOException {
		final String planDataFile = SpringBootTests.planGroup10DataFile;
		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(new File(planDataFile));
		CustomerItemManufacturerRules rules = pd.getCustomerItemManufacturerRules();
		for (OeCustMfr rule : rules.getRules().values()) {
			logger.debug("processing rule: {}", rule);
			assertNotNull(rule.getOeCustMast());
			assertNotNull(rule.getIcItemMast());
			assertNotNull(rule.getNaOrgMfr());
		}
		return rules;
	}
	
	List<OeCustMfr> getOeCustMfrList() {
		ArrayList<OeCustMfr> ocms = new ArrayList<OeCustMfr>();
	
		OeCustMfr obj;
		OeCustMfrId id;
		
		obj = new OeCustMfr();
		id = new OeCustMfrId();
		id.setItemNbr(10);
		id.setOrgNbrCust(1);
		id.setOrgNbrMfr(100);
		obj = new OeCustMfr();
		obj.setId(id);
		obj.setEffDtBeg(new Day(2018,4,1));
		obj.setEffDtEnd(new Day(2018,12,31));
		obj.setMfrRestrictId("I");
		ocms.add(obj);
		
		obj = new OeCustMfr();
		id = new OeCustMfrId();
		id.setItemNbr(1);
		id.setOrgNbrCust(10);
		id.setOrgNbrMfr(100);
		obj = new OeCustMfr();
		obj.setId(id);
		obj.setEffDtBeg(new Day(2018,4,1));
		obj.setEffDtEnd(new Day(2018,12,31));
		obj.setMfrRestrictId("I");
		ocms.add(obj);
		return ocms;
	}
	
	@Test
	public void testOeCustMfr() {

		final DatasetMetadataImpl meta = new DatasetMetadataImpl() {
			{
				addColumn(new ColumnMetadata().withColumnName("itemCd").withColumnIndex( 0).withDataType( DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("custCd").withColumnIndex( 1).withDataType( DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("mfrCd").withColumnIndex( 2).withDataType( DataType.STRING));
				addColumn(new ColumnMetadata().withColumnName("restrict").withColumnIndex(3).withDataType( DataType.STRING));
			}
		};

		// TODO replace with 
		final MatrixDataset ds = new MatrixDataset(meta) {
			{
			}
		};
		String dsString = DatasetCsvMarshaller.toString(ds);
		logger.debug("dsString:\n{}",dsString);
		//
		DatasetCrosstabber ct = new DatasetCrosstabber();
		ct.setDataSet(ds);

		List<String> rowid = new ArrayList<String>();
		rowid.add("custCd");

		String columnId = "mfrCd";

		List<String> cellId = new ArrayList<String>();
		cellId.add("restrict");

		CrosstabColumns cc = new CrosstabColumns(rowid,columnId,cellId);
		ct.setCrosstabColumns(cc);
		MatrixDataset result = ct.getDataSet();

		String resultString = DatasetCsvMarshaller.toString(result);
		logger.debug("resultString:\n{}",resultString);
		
		int rowCount = result.getRowCount();
		int colCount = result.getMetadata().getColumnCount();
		
		MutableDatasetMetadata md = result.getMetadata();
		for (ColumnMetadata cm : md.getColumnMetadata()) {
			logger.debug(cm.toStringBrief());
		}
	}
//
//	@Test
//	public void crosstabResultTest() throws IOException {
//		final String planDataFile = SpringBootTests.planGroup10DataFile;
//		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(new File(planDataFile));
//		CustomerItemManufacturerRules cims = pd.getCustomerItemManufacturerRules();
//		ListOfMapsDataset cimsds = cims.getOeCustMfrDataset("BACB30VT6K3");
//		String cimsdsString = DatasetCsvMarshaller.toString(cimsds);
//		logger.debug("cimsdsString:\n{}",cimsdsString);
//		
//		MatrixDataset ds = cims.getCrosstabbed("BACB30VT6K3");
//		String crosstabbed = DatasetCsvMarshaller.toString(ds);
//		logger.debug("crosstabbed:\n {}",crosstabbed);
//		int rowCount = ds.getRowCount();
//		int colCount = ds.getMetadata().getColumnCount();
//		assertEquals(3,rowCount);
//		assertEquals(12,colCount);
//		assertEquals("custCd",ds.getMetadata().getColumnMetaData(0).getColumnName());
//		assertEquals("06725",ds.getMetadata().getColumnMetaData(1).getColumnName());
//		MutableDatasetMetadata meta = ds.getMetadata();
//		
//	}
	@Test
	public void crosstabTest() throws IOException {
		final String planDataFile = SpringBootTests.planGroup10DataFile;
		PlanningData pd = PlanningDataMarshallable.planningDataFromFile(new File(planDataFile));
		CustomerItemManufacturerRules cims = pd.getCustomerItemManufacturerRules();
		logger.debug("crosstabTest cims:\n{}",cims.toString());
		ListOfMapsDataset cimsds = cims.getOeCustMfrDataset("BACB30VT6K3");
		logger.debug("Dataset cimds {}\n",cimsds);
		String cimsdsString = DatasetCsvMarshaller.toString(cimsds);
		logger.debug("cimsdsString:\n{}",cimsdsString);
		//
		
		MatrixDataset ds = cims.getCrosstabbed("BACB30VT6K3");
		String crosstabbed = DatasetCsvMarshaller.toString(ds);
		logger.debug("crosstabbed:\n {}",crosstabbed);
		int rowCount = ds.getRowCount();
		int colCount = ds.getMetadata().getColumnCount();
		assertEquals(3,rowCount);
		assertEquals(12,colCount);
		MutableDatasetMetadata meta = ds.getMetadata();
		assertEquals("custCd",ds.getMetadata().getColumnMetaData(0).getColumnName());
		assertEquals("06725",ds.getMetadata().getColumnMetaData(1).getColumnName());
		MutableDatasetMetadata crossMeta = ds.getMetadata();
		assertEquals(12,crossMeta.getColumnCount());
		
		assertEquals("custCd",ds.getMetadata().getColumnMetaData(0).getColumnName());
		assertEquals("06725",ds.getMetadata().getColumnMetaData(1).getColumnName());
		assertEquals(3,rowCount);
		assertEquals(12,colCount);
	    Collection<String> columnNames = ds.getColumnNames();
	    assertNotNull(columnNames);
		
		
		DatasetIterator di = ds.getDatasetIterator();
		di.next();
		List<Object> row = di.getRowAsList();
		assertEquals(12,row.size());
		assertEquals("135701",row.get(0));
		assertNull(row.get(11));
		
	}
}
