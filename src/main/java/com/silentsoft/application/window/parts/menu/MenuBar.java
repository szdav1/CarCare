package com.silentsoft.application.window.parts.menu;

import javax.swing.JMenuBar;

import com.silentsoft.application.window.parts.Container;

public final class MenuBar extends JMenuBar implements Container {
	public MenuBar() {
		new MenuBarBuilder(this)
			.addMenus("MenuBar.FileMenu", "MenuBar.VehiclesMenu", "MenuBar.SettingsMenu")
			.addMenuItems(0, "MenuBar.FileMenuExit");
	}

	@Override
	public void setup() {
	}
}
