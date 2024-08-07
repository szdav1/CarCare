package com.silentsoft.app.run;

import com.silentsoft.app.dialogs.ErrorDialog;

public final class AppInstance {
	public static final ErrorDialog errorDialog = new ErrorDialog();

	public static void start(final String[] args) {
		new App(args);
	}
}
