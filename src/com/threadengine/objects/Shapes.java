package com.threadengine.objects;

import java.awt.Rectangle;

public abstract class Shapes {

	protected int x;
	protected int y;
	protected int size;
	protected int speed;
	protected int xDir;
	protected int yDir;
	protected Rectangle rect;

	public Shapes(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public Shapes() {

	}

	public void moveX(int dir) {

	}

	public void moveY(int dir) {

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

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getxDir() {
		return xDir;
	}

	public void setxDir(int xDir) {
		this.xDir = xDir;
	}

	public int getyDir() {
		return yDir;
	}

	public void setyDir(int yDir) {
		this.yDir = yDir;
	}

	public Rectangle getRect() {

		return new Rectangle(this.getX(), this.getY(), this.getSize(), this.getSize());
	}
	
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
