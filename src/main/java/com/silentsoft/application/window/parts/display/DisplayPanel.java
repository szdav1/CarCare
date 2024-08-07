package com.silentsoft.application.window.parts.display;

import java.awt.BorderLayout;

import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;

import com.silentsoft.application.window.parts.Container;
import com.silentsoft.util.appdata.Dimensions;

public final class DisplayPanel extends JSplitPane implements Container {
	private final ToolBar toolBar;
	private final JLayeredPane contentPanel;

	public DisplayPanel() {
		this.toolBar = new ToolBar();
		this.contentPanel = new JLayeredPane();
		this.contentPanel.setLayout(new BorderLayout());

		this.setup();
	}

	@Override
	public void setup() {
		this.setDividerLocation(Dimensions.DEFAULT_DIVIDER_LOCATION);
		this.setLeftComponent(this.toolBar);
		this.setRightComponent(this.contentPanel);
	}
}
