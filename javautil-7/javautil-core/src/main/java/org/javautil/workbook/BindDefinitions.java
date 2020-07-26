package org.javautil.workbook;

import java.util.LinkedHashMap;
import java.util.TreeSet;

import org.javautil.sql.SqlStatement;

public class BindDefinitions extends LinkedHashMap<String, BindDefinition> {



	private static final long serialVersionUID = 1L;

	public BindDefinitions() {

	}

	public BindDefinitions(BindDefinitions bindDefs) {
		this.putAll(bindDefs);
	}
	
	public BindDefinitions  (BindDefinitions bindDefs, LinkedHashMap<String,SqlStatement> stmts) { 
		putAll(bindDefs);

		for (SqlStatement stmt : stmts.values()) {
			TreeSet<String> bindNames = stmt.getColonBindNames();
			for (String bindName : bindNames) {
				if (get(bindName) == null) {
					BindDefinition bd = new BindDefinition(bindName);

					put(bindName,bd);
				}
			}
		}


	}
}