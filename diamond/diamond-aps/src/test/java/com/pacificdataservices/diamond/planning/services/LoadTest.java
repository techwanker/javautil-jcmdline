package com.pacificdataservices.diamond.planning.services;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pacificdataservices.diamond.planning.data.PlanningData;
import com.pacificdataservices.diamond.planning.json.PlanningDataMarshallable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadTest {
	
	private static final File datafile = new File(SpringBootTests.planGroup10DataFile);

	@Autowired
	PlanningDataService pds;
	
	private static PlanningData pd;
	

	@Before
	public void before() throws IOException { 
		    PlanningDataMarshallable pdm = PlanningDataMarshallable.fromFile(datafile);
		    pd = pdm.toPlanningData();
	}
	
	
	@Test  
	// TODO this works but the hi lo key is used not the sequence generator 
	public void save() {
		    pds.save(pd);
	}

}
