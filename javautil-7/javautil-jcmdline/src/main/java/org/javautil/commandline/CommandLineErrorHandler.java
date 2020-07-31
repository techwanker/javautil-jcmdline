package org.javautil.commandline;

import jcmdline.CmdLineHandler;

public interface CommandLineErrorHandler {
	void setCmdLineHandler(CmdLineHandler cmdLineHandler);

	void handleException(String message);
}
