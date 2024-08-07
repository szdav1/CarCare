package com.silentsoft.application.window;

import java.awt.BorderLayout;
import java.awt.Image;

import com.silentsoft.application.window.parts.display.DisplayPanel;
import com.silentsoft.application.window.parts.menu.MenuBar;

public final class Window extends AbstractWindow {
	private final MenuBar menuBar;
	private final DisplayPanel displayPanel;

	public Window(final Image image, final String title) {
		super(image, title);

		this.menuBar = new MenuBar();
		this.displayPanel = new DisplayPanel();

		this.setup();
	}

	@Override
	public void setup() {
		this.setJMenuBar(this.menuBar);
		this.add(this.displayPanel, BorderLayout.CENTER);
	}
}
