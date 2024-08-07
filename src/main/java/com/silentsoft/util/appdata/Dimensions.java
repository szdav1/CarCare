package com.silentsoft.util.appdata;

import java.awt.Dimension;
import java.awt.Toolkit;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Dimensions {
	public static final Dimension SCREEN_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = SCREEN_DIMENSION.width;
	public static final int SCREEN_HEIGHT = SCREEN_DIMENSION.height;

	public static final int WINDOW_WIDTH = SCREEN_WIDTH*(int) (1400.0/SCREEN_WIDTH*100.0)/100;
	public static final int WINDOW_HEIGHT = SCREEN_WIDTH*(int) (500.0/SCREEN_HEIGHT*100.0)/100;
	public static final Dimension WINDOW_DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

	public static final int ERROR_DIALOG_WIDTH = WINDOW_WIDTH/3;
	public static final int ERROR_DIALOG_HEIGHT = WINDOW_HEIGHT/3;
	public static final Dimension ERROR_DIALOG_DIMENSION = new Dimension(ERROR_DIALOG_WIDTH, ERROR_DIALOG_HEIGHT);
}
