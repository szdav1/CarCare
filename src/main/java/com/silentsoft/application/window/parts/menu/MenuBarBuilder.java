package com.silentsoft.application.window.parts.menu;

import java.util.Arrays;

import javax.swing.JMenu;

import com.silentsoft.util.config.Language;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class MenuBarBuilder {
	private final MenuBar menuBar;

	public MenuBarBuilder addMenus(final String... menuTextKeys) {
		for (String menuTitle : menuTextKeys) {
			JMenu menu = new JMenu(Language.get(menuTitle));
			menu.setMnemonic(menuTitle.charAt(0));
			this.menuBar.add(menu);
		}

		return this;
	}

	public MenuBarBuilder addMenuItems(int menuIndex, final String... menuItemTextKeys) {
		JMenu selectedMenu = this.menuBar.getMenu(menuIndex);

		for (String menuItemText : menuItemTextKeys) {
			selectedMenu.add(new MenuItem(menuIndex, Arrays.asList(menuItemTextKeys).indexOf(menuItemText), Language.get(menuItemText)));
		}

		return this;
	}
}
