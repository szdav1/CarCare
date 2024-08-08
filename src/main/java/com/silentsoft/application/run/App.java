package com.silentsoft.application.run;

import com.silentsoft.application.view.window.Window;
import com.silentsoft.util.appdata.AppData;
import com.silentsoft.util.appdata.Log;
import com.silentsoft.util.appdata.RuntimeOnlyLog;
import com.silentsoft.util.config.Configurator;

public final class App {
	App(final String[] args) {
		for (String arg : args) {
			if (arg.equalsIgnoreCase(AppData.AdminData.ADMIN_KEY))
				RuntimeOnlyLog.appendLog(Log.RUNNING_AS_ADMIN);
		}

		Configurator.configure();
		Window window = new Window(null, "CarCare");

		if (!RuntimeOnlyLog.contains(Log.CONFIGURATION_ERROR))
			window.setVisible(true);
		else
			System.exit(1);
	}
}
