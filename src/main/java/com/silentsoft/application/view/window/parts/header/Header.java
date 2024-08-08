package com.silentsoft.application.view.window.parts.header;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLayeredPane;

import com.silentsoft.application.view.window.parts.Container;

public final class Header extends JLayeredPane implements Container {
	public Header() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setup();
	}

	@Override
	public void setup() {
	}
}
