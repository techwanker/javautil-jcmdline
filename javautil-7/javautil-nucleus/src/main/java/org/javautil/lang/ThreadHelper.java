package org.javautil.lang;



/**
 * todo review ClassHelper and StackHelper functionality
 * 
 * @author jjs
 * 
 */
public class ThreadHelper {

	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}

	public static String getCallerMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	/*
	 * The caller's classname stripped of the package
	 * 
	 * @return
	 */
	public static String getCallerSimpleClassName() {
		final StackTraceElement el = Thread.currentThread().getStackTrace()[2];
        return ClassHelper.getUnqualifiedClassName(el.getClassName());
	}

	public static String getCallerClassName() {
		final StackTraceElement el = Thread.currentThread().getStackTrace()[2];
        return el.getClassName();
	}

	public static String getCallerNoPackageClassName() {
		return Thread.currentThread().getStackTrace()[2].getClassName().replaceAll(".*\\.", "");
	}

	public static String getCallerNoPackageClassNameMethod() {
		final StackTraceElement el = Thread.currentThread().getStackTrace()[2];
		final String noPackageClassName = el.getClassName().replaceAll(".*\\.", "");
		final String methodName = el.getMethodName();
        return noPackageClassName + "." + methodName;

	}

	public static String getAsString(final StackTraceElement[] stackTrace) {
		final StringBuilder b = new StringBuilder();
		for (final StackTraceElement ste : stackTrace) {
			b.append(ste.toString());
			b.append("\n");
			
		}
		return b.toString();
	}

	public static String getStackTraceAsString() {
		final StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		final StackTraceElement[] callerStack = new StackTraceElement[stack.length - 1];
		System.arraycopy(stack, 1, callerStack, 0, callerStack.length);
		return getAsString(callerStack);
	}
}
