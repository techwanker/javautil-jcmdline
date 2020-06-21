Item Statistics
===============

Overview
--------

During a team phone call on December 15 ABC code requirement was
identified.

This demonstrates computing a number of potentially useful statistics

Addition Statistics
-------------------

ABCSLSPCT 
^^^^^^^^^

ABCSLSPCT Shows percentile of of total items more granular than ABC

ABCQTEPCT
^^^^^^^^^

Shows percentile of of total items more granular than ABC for sales quote activity 

ABCSLSOPENPCT 
^^^^^^^^^^^^^
hows percentile for open orders, reflects new items not yet received

ABCSLSJIT
^^^^^^^^^

ABC Code for JIT ITEMS

JITFLAG
^^^^^^^

Shows that this is a JIT Item

KITFLAT
^^^^^^^

Shows that this is part of a kit

SLAFLAG
^^^^^^^

Part of an SLA agreement for at least one customer 

Approach
--------

-  Create a table to hold statistics
-  Create a script to populate statistics by item
-  Create a service to obtain the data model for the web pages
-  Modify the filter screen to allow query filters on the statistics
-  Modify the web pages to show the statistics information



Code
----

Create the table
^^^^^^^^^^^^^^^^

.. code:: sql

.. include:: ic_item_stat_postgres.sql

SQlrunner file
^^^^^^^^^^^^^^

This is a yaml file 
https://en.wikipedia.org/wiki/YAML

.. code:: sql

.. include:: ../ddl/ic_item_stat_upd.yaml


Create a service
^^^^^^^^^^^^^^^^

.. code:: 

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
	public String  planData(
			@RequestParam(value="itemNbr") String itemNbr) 
					throws SQLException, IOException {
		logger.info("invoked with itemNumber {}",itemNbr);
		Connection conn = datasource.getConnection();
		SqlStatement ss = new SqlStatement(conn, "select * from ic_item_stat where item_nbr = :item_nbr");
		Binds binds = new Binds();
		binds.put("item_nbr", itemNbr);
		NameValue nameValue = ss.getNameValue(binds,true);
		JsonSerializer serializer = new JsonSerializerGson();
		String json = serializer.toJsonPretty(nameValue);
		return json;
	}
}

Create a node service
^^^^^^^^^^^^^^^^^^^^^

.. code::

   import { HttpClient } from '@angular/common/http';
   import { Observable } from 'rxjs';
   ...
   getIcItemStat(): Observable<IcItemStat[]> {
        return this.http.get<IcItemStat[]>(HOST + '/api/v1/icitemstat/' + itemnbr);
    }

Modify web page template
------------------------
