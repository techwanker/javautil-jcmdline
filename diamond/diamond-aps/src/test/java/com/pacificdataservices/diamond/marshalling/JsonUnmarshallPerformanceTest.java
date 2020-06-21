package com.pacificdataservices.diamond.marshalling;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.beanutils.BeanUtils;
import org.javautil.core.misc.Timer;
import org.javautil.hibernate.HibernateProxyTypeAdapter;
import org.javautil.lang.reflect.ReflectUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pacificdataservices.diamond.models.IcItemMast;

public class JsonUnmarshallPerformanceTest {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");  // TODO use core constant
	private Gson hibernateGson;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private final String jsonIn = 
			"{ \n" + 
					" \"icItemMast\": [\n" + 
					"    {\n" + 
					"      \"itemNbr\": 98565,\n" + 
					"      \"itemCd\": \"S-832-2ZI\",\n" + 
					"      \"itemDescr\": \"NUT **\",\n" + 
					"      \"stkUm\": \"EA\",\n" + 
					"      \"sellUm\": \"EA\",\n" + 
					"      \"stdCost\": 0.023091,\n" + 
					"      \"qtyPerBox\": 3000,\n" + 
					"      \"boxPerCtn\": 6,\n" + 
					"      \"replenQtyMin\": 6000,\n" + 
					"      \"icCategoryNbr\": 292,\n" + 
					"      \"nonStkFlg\": \"N\",\n" + 
					"      \"serNbrReqrFlg\": \"N\",\n" + 
					"      \"mfrSerNbrReqrFlg\": \"N\",\n" + 
					"      \"inspectReqrFlg\": \"N\",\n" + 
					"      \"mfrLotCtrlFlg\": \"N\",\n" + 
					"      \"kitFlg\": \"N\",\n" + 
					"      \"priceChgFlg\": \"Y\",\n" + 
					"      \"sellFlg\": \"Y\",\n" + 
					"      \"harmonizedCd\": \"7318160090\",\n" + 
					"      \"planBucketSz\": 2,\n" + 
					"      \"currCd\": \"CAD\",\n" + 
					"      \"reqrMfrFlg\": \"N\",\n" + 
					"      \"leadTmDy\": 120,\n" + 
					"      \"statId\": \"A\",\n" + 
					"      \"pickScanId\": \"L\",\n" + 
					"      \"introDt\": \"1995-12-31T00:00:00-05\",\n" + 
					"      \"splitAtBinFlg\": \"N\",\n" + 
					"      \"fifoDtId\": \"R\",\n" + 
					"      \"replenTypeId\": \"B\",\n" + 
					"      \"itemWght\": 0.0017\n" + 
					"    }\n" + 
					"  ]\n" + 
					"}\n" + 
					"";

	@Before
	public void before() {
		logger = LoggerFactory.getLogger(getClass());
		logger.info("logger is class "  + logger.getClass());
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		hibernateGson = getHibernateGson();
	}

	@Test 
	public void beanUtilsPerfTest() throws InstantiationException, IllegalAccessException {
		
		Timer fullTest = new Timer();
		Map<String, List<Map<String, Object>>> map = loadJson(jsonIn);
		logger.info("map is " + map);
		List<IcItemMast> itemMastList = 	getList(IcItemMast.class, map,"icItemMast",1);
		logger.info("second run of getList");
		getList(IcItemMast.class, map,"icItemMast",1);
		getList(IcItemMast.class, map,"icItemMast",10);
		assertEquals(1,itemMastList.size());
		getIcItemMastList(map,1);
		getIcItemMastList(map,10);
		
		getIcItemMastList(map,100);
		getIcItemMastList(map,10000);
		logger.info("fullTest millis: " + fullTest.getElapsedMillis());

	
	}

	public Map<String, List<Map<String, Object>>> loadJson(String jsonIn) {

		Timer gsonTimer = new Timer();
		final java.lang.reflect.Type typeOf = new TypeToken<Map<String, List<Map<String, Object>>>>() {
		}.getType();

		final Map<String, List<Map<String, Object>>> map = hibernateGson.fromJson(jsonIn, typeOf);
		logger.info("map.size(): " + map.size());
		logger.info("loadJson elapsed millis: " + gsonTimer.getElapsedMillis());

		return map;
	}



	public static Gson getHibernateGson() {
		Gson gsonNoChildren = new GsonBuilder()
				.addSerializationExclusionStrategy(new ExclusionStrategy() {
					@Override
					public boolean shouldSkipField(FieldAttributes f) {

						if (f.getAnnotation(OneToMany.class) != null) {
							return true;
						}
						if (f.getAnnotation(ManyToOne.class) != null) {
							return true;
						}
						return false;
					}

					@Override
					public boolean shouldSkipClass(Class<?> aClass) {
						return false;
					}
				}).setPrettyPrinting().
				setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").
				registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
		return gsonNoChildren;
	}

	public <T> List<T> getList(Class<T> clazz, Map<String,List<Map<String,Object>>> marshalled, String entityName, int recordCount ) throws InstantiationException, IllegalAccessException {
		Timer getListTimer = new Timer();
		List<Map<String,Object>> entityMaps = marshalled.get(entityName);

		List<T> entities;

		if (entityMaps == null) {
			logger.warn(clazz.getName() + " had null entity map");
			entities = new ArrayList<T>();
		} else {
			entities = new ArrayList<T>(entityMaps.size());
			T bean = clazz.newInstance();
			Set<String> dateFieldNames = ReflectUtils.getDateFieldNames(bean);
			for (Map<String, Object> properties : entityMaps) {
				Map<String, Object> bindProperties = convertStringsToDates(properties, dateFieldNames);
				try {
					for (int i = 1; i <= recordCount; i++) {
					Timer populateTimer = new Timer();
					BeanUtils.populate(bean, bindProperties);
					logger.info("BeanUtils.populate entity name: " + entityName + " micros: " + populateTimer.getElapsedMicros());
					}
				} catch (IllegalAccessException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
				entities.add(bean);
				bean = clazz.newInstance();
			}
		}
		logger.info("getList " + entityName + " recordCount " + recordCount + " micros " + getListTimer.getElapsedMicros());
		return entities;
	}

	public List<IcItemMast> getIcItemMastList(Map<String,List<Map<String,Object>>> marshalled, int recordCount)  {
		Timer getListTimer = new Timer();
		List<Map<String,Object>> entityMaps = marshalled.get("icItemMast");

		List<IcItemMast> entities;

		entities = new ArrayList<IcItemMast>(entityMaps.size());
		IcItemMast bean = new IcItemMast();
		Set<String> dateFieldNames = ReflectUtils.getDateFieldNames(bean);
		for  (int i = 1 ; i <= recordCount; i++) {
			for (Map<String, Object> properties : entityMaps) {
				Map<String, Object> bindProperties = convertStringsToDates(properties, dateFieldNames);
				populateIcItemMast(bean, bindProperties);
				entities.add(bean);
				bean = new IcItemMast();
			}
		}
		logger.info("getIcItemMastList " + recordCount + " micros: " + getListTimer.getElapsedMicros());
		logger.info("getIcItemMastList time per " + recordCount + " micros: " + getListTimer.getElapsedMicros() /
				recordCount);
		return entities;
	}

	public Map<String, Object> convertStringsToDates(Map<String, Object> inMap, Set<String> dateFieldNames) {
		LinkedHashMap<String, Object> outMap = new LinkedHashMap<String, Object>();
		for (String k : inMap.keySet()) {
			outMap.put(k, inMap.get(k));
			if (dateFieldNames.contains(k)) {
				String text = (String) inMap.get(k);
				if (text != null) {
					try {
						Date date = dateFormat.parse(text);
						outMap.put(k, date);
					} catch (ParseException e) {
						String message = "While parsing " + k + " with value " + text + e.getMessage();
						throw new IllegalArgumentException(message);
					}
				}
			}
		}
		return outMap;
	}

	public Integer toInteger(Object o) {
		Integer retval = null;
		if (o != null) {
			if (o instanceof Number) {
				Number num = (Number) o;
				retval = num.intValue();
			} else {
				throw new IllegalArgumentException("o must be Number is: " + o.getClass());
			}
		}
		return retval;
	}

	public BigDecimal toBigDecimal(Object o) {
		BigDecimal retval = null;
		if (o != null) {
			if (o instanceof Number) {
				Number num = (Number) o;
				retval = new BigDecimal(num.toString());
			} else {
				throw new IllegalArgumentException("o must be Number is: " + o.getClass());
			}
		}
		return retval;
	}

	public Short toShort(Object o) {
		Short retval = null;
		String stringNumber = null;
		if (o != null) {
			if (o instanceof Number) {
				Number num = (Number) o;
				//logger.info("Object type: " + o.getClass());
				try {
					stringNumber  = num.toString();
					retval = new BigDecimal(stringNumber).shortValue();
				} catch (NumberFormatException e) {  // to catch 2.0 for example
					logger.warn("Number format exception on " + stringNumber);
					BigDecimal bd = new BigDecimal(stringNumber);
					retval = bd.shortValue();  // TODO should check if there is a fractional part that is non zero
				}
			} else {
				throw new IllegalArgumentException("o must be Number is: " + o.getClass());
			}
		}
		return retval;
	}


	public void populateIcItemMast(IcItemMast im, Map<String,Object> map) {
		Timer t = new Timer();
		im.setItemNbr(toInteger(map.get("itemNbr")));
		im.setItemCd((String)map.get("itemCd"));
		im.setItemDescr((String)map.get("itemDescr"));
//		im.setStkUm((String)map.get("stkUm"));
//		im.setSellUm((String)map.get("sellUm"));
		im.setStdCost(toBigDecimal(map.get("stdCost")));
		im.setQtyPerBox(toInteger(map.get("qtyPerBox")));
		im.setBoxPerCtn(toInteger(map.get("boxPerCtn")));

		im.setReplenQtyMin(toInteger(map.get("replenQtyMin")));
		//setIcCategoryNbr(toInteger(map.get("icCategoryNbr")));
		im.setNonStkFlg((String)map.get("nonStkFlg"));
		im.setSerNbrReqrFlg((String)map.get("serNbrReqrFlg"));
		im.setMfrSerNbrReqrFlg((String)map.get("mfrSerNbrReqrFlg"));
		im.setInspectReqrFlg((String)map.get("inspectReqrFlg"));
		im.setMfrLotCtrlFlg((String)map.get("mfrLotCtrlFlg"));
		im.setKitFlg((String)map.get("kitFlg"));
		im.setPriceChgFlg((String)map.get("priceChgFlg"));
		im.setSellFlg((String)map.get("sellFlg"));
		im.setHarmonizedCd((String)map.get("harmonizedCd"));
		im.setPlanBucketSz(toShort(map.get("planBucketSz")));
		//im.setCurrCd((String)map.get("currCd"));
		im.setReqrMfrFlg((String)map.get("reqrMfrFlg"));
		im.setLeadTmDy(toInteger(map.get("leadTmDy")));
		im.setStatId((String)map.get("statId"));
		im.setPickScanId((String)map.get("pickScanId"));
		im.setIntroDt((Date)map.get("introDt"));
		im.setSplitAtBinFlg((String)map.get("splitAtBinFlg"));
		im.setFifoDtId((String)map.get("fifoDtId"));
		im.setReplenTypeId((String)map.get("replenTypeId"));
		im.setItemWght(toBigDecimal(map.get("itemWght")));
	//	logger.info("populateIcItemMast  micros: " + t.getElapsedMicros());

	}
}
