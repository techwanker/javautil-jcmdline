package org.javautil.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class Checkpoint {
	
	private final File file;

	public Checkpoint(String filepath) {
		if (filepath == null) {
			throw new IllegalArgumentException("filepath is null");
		}
		this.file = new File(filepath);
	}
	
	public void create() throws IOException {
		FileOutputStream os  = new FileOutputStream(file);
		os.close();
	}
	
	public void delete() {
		file.delete();
	}
	
	public boolean exists() {
		return file.exists();
	}
	
	public String name() {
		return file.getPath();
	}

}
