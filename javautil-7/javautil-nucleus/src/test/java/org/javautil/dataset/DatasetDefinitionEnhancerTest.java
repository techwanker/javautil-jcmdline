package org.javautil.dataset;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class DatasetDefinitionEnhancerTest {
	@Test
	public void test1() throws SQLException, PropertyVetoException, IOException {
		String infileName = "src/test/resources/LoadFile.yaml";
		File infile = new File(infileName);
		
		String outfile = "target/LoadFileEnhanced.yaml";
		assert(infile.exists());
		
		String dataSourceName="integration_postgres_sr";
		
		String[] args = {
				"--infile", infileName,
				"--outfile",outfile,
				"--datasource",dataSourceName,
				"--verbosity=3",
                "etl_file_id=1"
		};
		
		DatasetsDefinitionEnhancer.main(args);
		
		
	}

}