package com.threadengine.objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Bricks{
	
	private int x;
	private int y;
	private boolean visible = true;
	private Color color;
	
	


	public Bricks(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = getRandomColor();

	}


	public int getX() {
		return x;
	}


	public Color getColor() {
		return color;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
    public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, 50, 50);
	}
	
	public Color getRandomColor() {

		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);

		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

}
