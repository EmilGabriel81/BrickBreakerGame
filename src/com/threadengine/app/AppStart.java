package com.threadengine.app;

import javax.swing.SwingUtilities;

import com.threadengine.ui.MainFrame;

public class AppStart {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new MainFrame();
				
			}
		});

	}

}
