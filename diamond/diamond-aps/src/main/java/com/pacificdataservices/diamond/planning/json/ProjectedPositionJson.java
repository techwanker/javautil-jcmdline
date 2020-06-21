package com.pacificdataservices.diamond.planning.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.javautil.core.misc.DoubleBuckets;
import org.javautil.core.misc.MultiKey;
import org.javautil.core.misc.MultiKeyHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pacificdataservices.diamond.buckets.SupplyBuckets;
import com.pacificdataservices.diamond.planning.supply.Supply;

public class ProjectedPositionJson {

	private List<String> identifiers  =  new ArrayList<String>();
	private List<String> itemCodes = new ArrayList<String>();
	private List<Double> values = new ArrayList<>();
	private transient Logger logger = LoggerFactory.getLogger(getClass());


	public ProjectedPositionJson(SupplyBuckets proj) {
		setIdentifiers(proj.getIdentifiers());
		for (Double d : proj.getDateMap().values() ) {
			values.add(d);
		}
	}

	public ProjectedPositionJson(MultiKey id, SupplyBuckets sb) {
		setIdentifiers(id);
		for (Double d : sb.getDateMap().values() ) {
			values.add(d);
		}
		Supply supply = (Supply) sb.getSupply();
		if (supply == null) {
			throw new IllegalStateException("supply is null");
		}
		itemCodes = supply.getItemCdList();
	}
	public ProjectedPositionJson(MultiKey id, DoubleBuckets db) {
		setIdentifiers(id);
		for (Double d : db.getDateMap().values() ) {
			values.add(d);
		}
//		Supply supply = (Supply)  db.getAttribute("supply");
//		if (supply == null) {
//			throw new IllegalStateException("supply not found in " + db.getAttributeNames());
//		}
		//itemCodes = supply.getItemCdList();
	}

	public static ArrayList<ProjectedPositionJson> 
	toProjectedPositionList(MultiKeyHashMap<SupplyBuckets> groupedBy) {
		ArrayList<ProjectedPositionJson> list = new ArrayList<ProjectedPositionJson>();
		for (Entry<MultiKey, SupplyBuckets> r : groupedBy.entrySet()) {
			list.add(new ProjectedPositionJson(r.getKey(), r.getValue()));
		}
		return list;
	}

	void setIdentifiers(ArrayList<Comparable> id) {
		for (Comparable kv : id) {
			if (kv instanceof String) {
				identifiers.add((String) kv);
			} else {
				MultiKey itemCodes = (MultiKey) kv;
				logger.info("about to unwind " + itemCodes);
				for (Comparable itemCd : itemCodes) {
					this.itemCodes.add((String) itemCd);
				}
				logger.info("itemCodes" + itemCodes);
			}
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectedPositionJson [identifiers=" + identifiers + ", itemCodes=" + itemCodes + ", values=" + values
				+ "]";
	}

}
