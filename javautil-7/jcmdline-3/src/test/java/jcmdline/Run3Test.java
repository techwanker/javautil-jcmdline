

package jcmdline;

import org.junit.Ignore;
import org.junit.Test;

public class Run3Test {

	
	@Test
	public void  test() {
		String args[] = {"src/test/resources/empty.html"};
		Sample3.main(args);
	}
	
	@Ignore
	@Test
	public void  test2() {
		String args[] = {"src/test/resources/empty.html","src/test/resources/none.html"};
		Sample3.main(args);
	}
}
