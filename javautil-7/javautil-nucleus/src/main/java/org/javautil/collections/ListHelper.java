package org.javautil.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jjs@dbexperts.com
 * 
 */
public class ListHelper {

	public static int lastNonNullValueIndex(final List<Object> objects) {
		int i = -1;
		if (objects != null) {
			for (i = objects.size() - 1; i >= 0; i--) {
				if (objects.get(i) != null) {
					break;
				}
			}
		}
		return i;
	}

	public static ArrayList<Object> toList(final Object... o) {
		final ArrayList<Object> al = new ArrayList<Object>(o.length);
        al.addAll(Arrays.asList(o));
		return al;
	}

	public static ArrayList<String> toStringList(final String... o) {
		final ArrayList<String> al = new ArrayList<String>(o.length);
        al.addAll(Arrays.asList(o));
		return al;
	}
}
