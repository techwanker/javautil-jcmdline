package com.pacificdataservices.diamond.apsweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.javautil.core.json.JsonSerializer;
import org.javautil.core.json.JsonSerializerGson;
import org.javautil.core.sql.Binds;
import org.javautil.core.sql.SqlStatement;
import org.javautil.util.NameValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IcItemStatController {


	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DataSource datasource;

	@RequestMapping("/icItemStat")
	public String  getIcItemStat(
			@RequestParam(value="itemNbr") String itemNbr) 
					throws SQLException, IOException {
		logger.info("invoked with itemNumber {}",itemNbr);
		Connection conn = datasource.getConnection();
		SqlStatement ss = new SqlStatement(conn, 
				"select * from ic_item_stat where item_nbr = :item_nbr");
		Binds binds = new Binds();
		binds.put("item_nbr", new Integer(itemNbr));
		NameValue nameValue = ss.getNameValue(binds,true);
		JsonSerializer serializer = new JsonSerializerGson();
		String json = serializer.toJsonPretty(nameValue);
		return json;
	}


}
