package org.javautil.csv.jackson;

import java.util.ArrayList;
import java.util.List;

import org.javautil.dataset.ColumnMetadata;
import org.javautil.json.JsonSerializerJackson;

public class SqlCsvExporterJsonParser {

	private final SqlCsvExporterJson bean;

	public SqlCsvExporterJsonParser(String json) {
		JsonSerializerJackson dillon = new JsonSerializerJackson();
		bean = (SqlCsvExporterJson) dillon.toObjectFromJson(json, SqlCsvExporterJson.class);
	}

	public List<ColumnMetadata> getColumnMetadata() {
		ArrayList<ColumnMetadata> list = new ArrayList<>();
		for (ColumnMetum colser : bean.getColumnMeta()) {
			ColumnMetadata col = new ColumnMetadata();
			col.setColumnName(colser.getColumnName());
			col.setColumnDisplaySize(colser.getColumnDisplaySize());
			col.setColumnTypeName(colser.getColumnTypeName());
			col.setDataTypeName(colser.getDataType());
			// colser.getExternalFlag();
			col.setPrecision(colser.getPrecision());
			col.setScale(colser.getScale());
			list.add(col);
		}
		return list;

	}

}
