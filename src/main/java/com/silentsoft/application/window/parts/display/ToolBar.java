package com.silentsoft.application.window.parts.display;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.silentsoft.application.window.parts.Container;
import com.silentsoft.util.appdata.Dimensions;
import com.silentsoft.util.config.Language;

public final class ToolBar extends JToolBar implements Container {
	private final JButton managementButton;

	public ToolBar() {
		this.managementButton = new JButton(Language.get("ToolBar.Management"));
		this.managementButton.setPreferredSize(new Dimension(0, Dimensions.BUTTON_HEIGHT));

		this.setLayout(new BorderLayout());
		this.setFloatable(false);
		this.setup();
	}

	@Override
	public void setup() {
		this.add(this.managementButton, BorderLayout.NORTH);
	}
}
