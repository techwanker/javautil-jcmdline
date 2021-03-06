package org.javautil.workbook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.javautil.sql.BindType;
import org.javautil.sql.Binds;
import org.javautil.sql.DataSources;
import org.javautil.sql.SqlStatement;

public class WorkbookPublisher {

	private final WorkbookDefinition workbookDefinition;

	private final DataSources        dataSources;

	private final Set<String>        allBindNames;

	// private TreeMap<String, BindType> bindTypes;

	private final String             connectionName;

	public WorkbookPublisher(WorkbookDefinition workbookDefinition, DataSources dataSources, Binds binds,
	    String connectionName) throws UndefinedBindTypeException {
		this.workbookDefinition = workbookDefinition;
		this.dataSources = dataSources;
		this.connectionName = connectionName;
		allBindNames = getAllBindNames(workbookDefinition);
//		bindTypes = getBindTypes(workbookDefinition.getBinds());
//		ensureAllBindsTyped(allBindNames, bindTypes);
		ensureAllBindsDeclared(allBindNames, binds);
	}

	private TreeMap<String, BindType> getBindTypes(List<Bind> binds) {
		TreeMap<String, BindType> myBindTypes = new TreeMap<String, BindType>();
		for (Bind bind : binds) {
			BindType newType = BindType.valueOf(bind.getDataType());
			BindType former = myBindTypes.put(bind.getName(), newType);
			if (former != null) {
				throw new IllegalArgumentException(
				    "Bind '" + bind.getName() + " declared as " + former.toString() + " and " + newType.toString());
			}
		}
		return myBindTypes;
	}

	public static Set<String> getAllBindNames(WorkbookDefinition workbookDefinition) {
		Set<String> bindNames = new HashSet<String>();
		for (Worksheet sheet : workbookDefinition.getWorksheets().values()) {
			String sql = sheet.getSql();
			SqlStatement ss = new SqlStatement(sql);
			bindNames.addAll(ss.getColonBindNames());
		}
		return bindNames;
	}

	public static void ensureAllBindsTyped(Set<String> allBindNames, TreeMap<String, BindType> bindTypes)
	    throws UndefinedBindTypeException {
		for (String bindName : allBindNames) {
			if (bindTypes.get(bindName) == null) {
				throw new UndefinedBindTypeException(bindName);
			}
		}
	}

	public static void ensureAllBindsDeclared(Set<String> allBindNames, Binds binds) throws UndefinedBindTypeException {
		for (String bindName : allBindNames) {
			if (binds.get(bindName) == null) {
				throw new UndefinedBindTypeException(bindName);
			}
		}
	}

}
