package com.silentsoft.application.run;

import com.silentsoft.application.view.dialogs.ErrorDialog;

public final class AppInstance {
	public static final ErrorDialog errorDialog = new ErrorDialog();

	public static void startNewInstance(final String[] args) {
		new App(args);
	}
}
