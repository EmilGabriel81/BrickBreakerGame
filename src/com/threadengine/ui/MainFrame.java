package com.threadengine.ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	

	
	public MainFrame() {
		
		initLayout();
	}

	private void initLayout() {
		setTitle("Game engine Thread based");
		add(new MainPanel());
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	
}
