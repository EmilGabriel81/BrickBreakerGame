package com.threadengine.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.threadengine.ui.MainPanel;

public class GameEventListener extends KeyAdapter{
	
	private MainPanel panel;
	
	public GameEventListener(MainPanel panel) {
		this.panel = panel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		panel.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		panel.keyReleased(e);
	}
	
	
	

}
