package org.javautil.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class CheckpointTest {

	@Test
	public void createTest() throws IOException {
		 String filepath = "target/testcp";
		 Checkpoint cp = new Checkpoint(filepath);
		 cp.create();
		 File file = new File(filepath);
		 assert(file.exists());
		 assert(cp.exists());
		 cp.delete();
		 assert(!file.exists());
		 
		 
	}
}
