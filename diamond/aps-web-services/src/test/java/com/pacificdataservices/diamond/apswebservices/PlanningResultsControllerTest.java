package com.pacificdataservices.diamond.apswebservices;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlanningResultsControllerTest {

    @Autowired
	private PlanningResultsController prc;

    @Ignore
	@Test
	public void getPlanningResultsTest() throws IOException {
		String partCd = "AN960-10";
		if (prc == null) {
			throw new IllegalStateException("prc is null");
		}
		String pr = prc.getPlanningResults(partCd);
		assertNotNull(pr);
	}
}
