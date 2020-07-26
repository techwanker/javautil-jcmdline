package com.pacificdataservices.diamond.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import org.javautil.dataset.ColumnMetadata;
import org.javautil.dataset.CrosstabColumns;
import org.javautil.dataset.DataType;
import org.javautil.dataset.Dataset;
import org.javautil.dataset.DatasetCrosstabber;
import org.javautil.dataset.DatasetMetadataImpl;
import org.javautil.dataset.ListOfMapsDataset;
import org.javautil.dataset.MatrixDataset;
import org.javautil.hibernate.HibernateMarshallerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pacificdataservices.diamond.models.NaOrg;
import com.pacificdataservices.diamond.models.OeCustMast;
import com.pacificdataservices.diamond.models.OeCustMfr;
import com.pacificdataservices.diamond.models.OeCustMfrId;

/**
 * If the customer has a whitelist the blacklist is ignored
 * 
 * @author jjs
 *
 */
public class CustomerItemManufacturerRules {
	private Logger logger = LoggerFactory.getLogger(getClass());

	Gson dillon;
	/* ItemCd, CustCd, MfrCd */
	private TreeMap<String, OeCustMfr> rules = new TreeMap<String, OeCustMfr>();

	private TreeMap<Integer, TreeMap> byItemNbr  = new TreeMap<>();


	/**
	 * @return the byItemNbr
	 */
	public TreeMap<Integer, TreeMap> getByItemNbr() {
		return byItemNbr;
	}

	public TreeMap<String, OeCustMfr> getRules() {
		return rules;
	}
	
	private TreeMap<String,List<OeCustMfr>> customerItemWhiteList = new TreeMap<String,List<OeCustMfr>>();

	private TreeSet<String> customerHasWhiteList = new TreeSet<String>();

	private TreeSet<String> customerHasBlackList = new TreeSet<String>();

	public CustomerItemManufacturerRules(Collection<OeCustMfr> rules) {
		if (rules == null) {
			throw new IllegalArgumentException("rules is null");
		}
		for (OeCustMfr rule : rules) {
			addRule(rule);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + "whitelist: \n");
		for (String cikey : customerHasWhiteList) {
			sb.append(cikey);
			sb.append("\n");
		}
		sb.append("blacklist: \n");
		for (String cikey : customerHasBlackList) {
			sb.append(cikey);
			sb.append("\n");
		}
		sb.append("rules: count " + rules.size() + "\n");
		for (Entry<String, OeCustMfr> e : rules.entrySet()) {
			sb.append(e.getKey());
			sb.append(" ");
			sb.append(ruleToString(e.getValue()));
			sb.append("\n");
		}
		return sb.toString();

	}

	public String asJson() {
		if (dillon == null) {  // Todo this is crazy expensive to instantiate
			dillon  = HibernateMarshallerFactory.getHibernateGsonWithProxyDateFormatter();
		}
		String retval  = dillon.toJson(byItemNbr);
		return retval;
	}

	/**
	 * {ItemCd:"AN960" 
	 *    
	 *     
	 * @param rule
	 */
	void addNestedTree(OeCustMfr rule) {
		TreeMap<Integer,TreeMap> byCustNbr = byItemNbr.get(rule.getId().getItemNbr());
		OeCustMast ocm = rule.getOeCustMast();
		//		NaOrg custOrg = ocm.getNaOrg();
		//		String custCd = custOrg.getOrgCd();
		//		String mfrCd  = rule.getNaOrgMfr().getOrgCd();
		//		String itemCd = rule.getIcItemMast().getItemCd();
		//		//logger.debug("looking at {} {} {}", itemCd,custCd,mfrCd);
		if (byCustNbr == null) {
			byCustNbr = new TreeMap<Integer,TreeMap>();
			byItemNbr.put(rule.getId().getItemNbr(),byCustNbr);
			//System.out.println("byItemNbr " + byItemNbr);
		}

		TreeMap<Integer,OeCustMfr> byMfrNbr = byCustNbr.get(rule.getId().getOrgNbrCust());
		if (byMfrNbr == null) {
			byMfrNbr = new TreeMap<Integer,OeCustMfr>();
			byCustNbr.put(rule.getId().getOrgNbrCust(),byMfrNbr);
		} 
		byMfrNbr.put(rule.getId().getOrgNbrMfr(),rule);
	}

	public void addRule(OeCustMfr rule) {
		if (rule == null) {
			throw new IllegalArgumentException("rule is null");
		}
		Integer customerNumber = rule.getId().getOrgNbrCust();
		Integer itemNumber = rule.getId().getItemNbr();
		Integer manufacturerNumber = rule.getId().getOrgNbrMfr();
		String cimkey = getCustomerItemManufacturerKey(customerNumber, itemNumber, manufacturerNumber);
		rules.put(cimkey, rule);
		String cikey = getCustomerItemKey(customerNumber, itemNumber);

		if ("I".equals(rule.getMfrRestrictId())) {
			customerHasWhiteList.add(cikey);
			List<OeCustMfr> whites = customerItemWhiteList.get(cikey);
			if (whites == null) {
				whites = new ArrayList<OeCustMfr>();
				customerItemWhiteList.put(cikey,whites);
			}
			whites.add(rule);
		
		} else if ("E".equals(rule.getMfrRestrictId())) {
			customerHasBlackList.add(cikey);
		} else {
			throw new IllegalArgumentException("Unknown restrictId " + rule);
		}
		addNestedTree(rule);
	}

	public String getCustomerItemKey(int customerNumber, int itemNumber) {
		String cikey = customerNumber + "-" + itemNumber;
		return cikey;
	}

	public String getCustomerItemManufacturerKey(int customerNumber, int itemNumber, int manufacturerNumber) {
		String cimkey = customerNumber + "-" + itemNumber + "-" + manufacturerNumber;
		return cimkey;
	}

	public String ruleToString(OeCustMfr ocm) {
		StringBuilder sb = new StringBuilder();
		if (ocm == null) {
			sb.append("null ocm");
		} else {
			OeCustMfrId id = ocm.getId();
			sb.append("cust: " + id.getOrgNbrCust());
			sb.append(" item: " + id.getItemNbr());
			sb.append(" mfr: " + id.getOrgNbrMfr());
			sb.append(" beg: " + ocm.getEffDtBeg());
			sb.append(" end: " + ocm.getEffDtEnd());
			sb.append(" type: " + ocm.getMfrRestrictId());
		}
		return sb.toString();
	}

	public boolean isApprovedMfr(int customerNumber, int itemNumber, Integer manufacturerNumber, Date demandDate) {
		Boolean retval = null;
		String custItemKey = getCustomerItemKey(customerNumber, itemNumber);
		//boolean hasWhiteList = customerHasWhiteList.contains(custItemKey);
		
		logger.debug("customer#: {} itemNumber {} mfr {}", customerNumber, itemNumber, manufacturerNumber);
		String custItemMfrKey = null;
		OeCustMfr ocm = null;
		if (customerHasWhiteList.contains(custItemKey) || customerHasBlackList.contains(custItemKey)) {
			custItemMfrKey = getCustomerItemManufacturerKey(customerNumber, itemNumber, manufacturerNumber);
			ocm = rules.get(custItemMfrKey);
		}
		logger.debug("testing customer: {} item# {} mfr {} demandDate {}",  customerNumber, itemNumber, manufacturerNumber, demandDate); 
		logger.debug("custItem: {} custItemMfr {} OeCustMfr: {}", custItemKey , custItemMfrKey, ruleToString(ocm));
		if (customerHasWhiteList.contains(custItemKey)) {
			if (ocm == null) {
				logger.debug("no include rule");
				retval = false;
			} else {
				if ("I".equals(ocm.getMfrRestrictId())) {
					logger.debug("is include");
					retval = true;
				}
				if (ocm.getEffDtBeg() != null) {
					if (demandDate.before(ocm.getEffDtBeg())) {
						logger.debug("demand date " + demandDate + 
								"before eff dt " + ocm.getEffDtBeg());
						retval = false;
					}
				}
				if (ocm.getEffDtEnd() != null) {
					if (demandDate.after(ocm.getEffDtEnd())) {
						logger.debug("demand date after eff dt");
						retval = false;
					}
				}
			} 
		} else {
			if (customerHasBlackList.contains(custItemKey)) {
				logger.debug("has blacklist ocm {}",ocm);
				if (ocm == null) {
					retval = true;
				} else  {
					if ("E".equals(ocm.getMfrRestrictId())) {
						retval = false;
					}
					if (ocm.getEffDtBeg() != null) {
						if (demandDate.before(ocm.getEffDtBeg())) {
							retval = true;
						}
					}
					if (ocm.getEffDtEnd() != null) {
						if (demandDate.after(ocm.getEffDtEnd())) {
							retval = true;
						}
					}
				}
			} else {
				retval = true;
			}

		}
		if (retval == null) {
			throw new IllegalStateException("Logic error ");
		}
		return retval;
	}

	public List<OeCustMfr> getForCustItem(int custNbr, int itemNbr) {
		ArrayList<OeCustMfr> retval =new ArrayList<OeCustMfr>();
		for (OeCustMfr rule : rules.values()) {
			if (rule.getOeCustMast().getOrgNbrCust() == custNbr &&
					rule.getId().getItemNbr() == itemNbr ) {
				retval.add(rule);
			}
		}
		return retval;
	}
	public TreeSet<String> getDistinctItemCd() {
		TreeSet<String> itemCds = new TreeSet<String>();
		for (OeCustMfr rule : rules.values()) {
			itemCds.add(	rule.getIcItemMast().getItemCd());
		}
		return itemCds;
	}

	public TreeSet<String> getDistinctCustCd() {
		TreeSet<String> custCds = new TreeSet<String>();
		for (OeCustMfr rule : rules.values()) {
			custCds.add(	rule.getOeCustMast().getNaOrg().getOrgCd());
		}
		return custCds;
	}
	public TreeSet<String> getDistinctMfrCd() {
		TreeSet<String> retval = new TreeSet<String>();
		for (OeCustMfr rule : rules.values()) {
			retval.add(rule.getNaOrgMfr().getOrgCd());
			//retval.add(	rule.getPoMfrMast().getNaOrg().getOrgCd());
		}
		return retval;
	}

	public ListOfMapsDataset getOeCustMfrDataset(String itemCd) {
		ArrayList<Map<String,Object>> rows = new ArrayList<>();
		logger.debug("getOeCustMfrDataset rule count {} itemCd {}",rules.size(),itemCd);
		// convert to list of maps
		for (OeCustMfr ocm : rules.values()) {
			//			IcItemMast iim = ocm.getIcItemMast();
			//			logger.debug("ocm icItemMast is {}", iim);
			String testItemCd = ocm.getIcItemMast().getItemCd();
			if (itemCd.equals(testItemCd)) {
				logger.debug("adding ocm: {}", ocm);
				Map<String,Object> map = new LinkedHashMap<String,Object>();
				map.put("itemCd",ocm.getIcItemMast().getItemCd());
				map.put("custCd",ocm.getOeCustMast().getNaOrg().getOrgCd());
				NaOrg orgMfr = ocm.getNaOrgMfr();
				map.put("mfrCd",orgMfr.getOrgCd());
				if ("I".equals(ocm.getMfrRestrictId())) {
					map.put("restrict","approved");
				} else {
					map.put("restrict","NO!");
				}

				rows.add(map);
			} else {
				logger.debug("rejecting ocm {} has itemCd {}", ocm, testItemCd);
			}
		}
		// metdata
		DatasetMetadataImpl dm = new DatasetMetadataImpl();
		dm.addColumn(new ColumnMetadata().withColumnName("itemCd").withDataType(DataType.STRING));
		dm.addColumn(new ColumnMetadata().withColumnName("custCd").withDataType(DataType.STRING));
		dm.addColumn(new ColumnMetadata().withColumnName("mfrCd").withDataType(DataType.STRING));
		dm.addColumn(new ColumnMetadata().withColumnName("restrict").withDataType(DataType.STRING));

		ListOfMapsDataset ds = new ListOfMapsDataset("ocm",dm,rows);
		return ds;
	}

	public List<MatrixDataset> getCrosstabs() { 
		ArrayList<MatrixDataset> retval = new ArrayList<>();
		for (String itemCd : getDistinctItemCd()) {
			retval.add(getCrosstabbed(itemCd));
		}
		return retval;
	}

	public MatrixDataset getCrosstabbed(String itemCd) {
		Dataset itemCdDs = getOeCustMfrDataset(itemCd);
		//
		DatasetCrosstabber ct = new DatasetCrosstabber();
		ct.setDataSet(itemCdDs);

		List<String> rowid = new ArrayList<String>();
		rowid.add("custCd");

		String columnId = "mfrCd";

		List<String> cellId = new ArrayList<String>();
		cellId.add("restrict");

		CrosstabColumns cc = new CrosstabColumns(rowid,columnId,cellId);
		ct.setCrosstabColumns(cc);
		MatrixDataset result = ct.getDataSet();
		result.setName(itemCd);
		return result;
	}

}
