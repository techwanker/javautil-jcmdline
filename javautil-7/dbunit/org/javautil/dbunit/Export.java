package org.javautil.dbunit;

public class Export {

	public void partial() {
		
        // database connection
        Class driverClass = Class.forName("org.hsqldb.jdbcDriver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:hsqldb:sample", "sa", "");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        // partial database export
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
        partialDataSet.addTable("BAR");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));

	}
	
	public void full() {
		IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));

        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
        String[] depTableNames = 
          TablesDependencyHelper.getAllDependentTables( connection, "X" );
        IDataSet depDataSet = connection.createDataSet( depTableNames );
        FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));
	}
	
    public static void main(String[] args) throws Exception {
      full();
        
    }
}