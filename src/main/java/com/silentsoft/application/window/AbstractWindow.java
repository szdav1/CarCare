package com.silentsoft.application.window;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.silentsoft.application.window.parts.Container;
import com.silentsoft.util.appdata.Dimensions;

public abstract class AbstractWindow extends JFrame implements Container {
	protected final JLayeredPane contentPane;

	protected AbstractWindow(final Image image, final String title) {
		this.contentPane = new JLayeredPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Dimensions.WINDOW_DIMENSION);
		this.setContentPane(this.contentPane);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setIconImage(image);
		this.setTitle(title);
	}
}
