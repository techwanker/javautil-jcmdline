package org.javautil.jdbc.metadata;

import org.javautil.core.jdbc.metadata.DatabaseObjectType;

public interface DatabaseObject {

	public String getOwner();

	public String getName();

	public DatabaseObjectType getDatabaseObjectType();

	public DDL getDDL();

	public boolean isFullyQualified();

	public void setDDL(DDL ddl);

}
