package com.threadengine.objects;

import java.awt.Rectangle;

public class Ball extends Shapes {

	public Ball(int x, int y) {
		super(x, y);

		this.size = 20;

	}

	public Ball() {

	}

	public void moveX(int dir) {
		this.x += dir;
		// if(this.x >= 912 && dir != -1) dir *=- 1;
	}

	public void moveY(int dir) {
		// if(this.y <= 35 && dir != 1) dir *=- 1;
		
		this.y += dir;
	}
}
