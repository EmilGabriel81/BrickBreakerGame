package com.threadengine.objects;

import java.awt.Rectangle;

public class Pad {

	private int x;
	private int y;
	
	private int speed = 0;
	
	public Pad(int x, int y) {
	this.x = x;
	this.y = y;
	
	}
	
	public void tick() {
		x += speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}


	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, 100, 20);
	}
	
}
