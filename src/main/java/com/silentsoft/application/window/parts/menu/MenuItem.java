package com.silentsoft.application.window.parts.menu;

import javax.swing.JMenuItem;

import lombok.Getter;

@Getter
public final class MenuItem extends JMenuItem {
	private final int menuIndex;
	private final int itemIndex;

	public MenuItem(int menuIndex, int itemIndex, String text) {
		this.menuIndex = menuIndex;
		this.itemIndex = itemIndex;

		this.setText(text);
	}
}
