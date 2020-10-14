package com.threadengine.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import org.w3c.dom.css.Rect;

import com.threadengine.constants.Constants;
import com.threadengine.listeners.GameEventListener;
import com.threadengine.objects.Ball;
import com.threadengine.objects.Bricks;
import com.threadengine.objects.Pad;
import com.threadengine.objects.Shapes;

public class MainPanel extends JPanel {

	private MainLoop loop;
	private Thread thread;
	private int boardWidth = 912;
	private int boardHeight = 762;
	private int relY = 100;
	private Shapes ball;
	private List<Shapes> balls;
	private List<Bricks> bricks;
	private int score = 0;
	private int bricksCount = 0;
	private Bricks brick;
	private int dirX = 1;
	private int dirY = -2;
	private Pad pad;
	private boolean gameOn;
	private String message;
	// private boolean gameOver;

//	private Ball ball;

	public MainPanel() {
		initLayout();
		initVar();
		initBricks();

		// initBalls();
		initThread();

	}

	private void initThread() {

		this.thread.start();
		// this.stop();
	}

	private void initVar() {

		this.ball = new Ball(450, 600);

		this.gameOn = true;
		// this.gameOver = false;
		this.pad = new Pad(400, 700);
		this.loop = new MainLoop(this);
		this.thread = new Thread(loop);
		this.balls = new ArrayList<Shapes>();
		this.bricks = new ArrayList<Bricks>();
		addKeyListener(new GameEventListener(this));

	}

	private void initLayout() {

		setPreferredSize(new Dimension(900, 750));
		setFocusable(true);

	}

	public void render() {
		if (gameOn) {
			update();
		}
		repaint();
	}

	private void initBricks() {

		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {

				this.brick = new Bricks(250 + 55 * i, 100 + 55 * j);
				bricks.add(brick);

			}
			
		}
		
	}

	private void update() {

		// this.relY += direction;
		moveBall();
		ballPadCollision();
		movePad();
		ballBricksCollision();

//		if(!gameOn) {
//			this.loop.stop();
//		}

		// if(this.relY >= boardHeight && direction != -1 || this.relY <= 35 &&
		// direction != 1 ) this.direction *= -1;
//		for(Shapes ball : this.balls) {
//			if(ball.getX() >= boarWidth && direction != -1 || ball.getY() <= 35 && direction != 1) direction *=- 1; 
//			//ball.moveX(direction);
//			//ball.moveY(direction);
//		}

		// if(this.relY <= 35 && direction != 2 ) this.direction = 2;

		// System.out.println("Updateing..");

	}

	private void ballBricksCollision() {

		Rectangle ballRectangle = ball.getRect();
		for (Bricks brk : bricks) {
			Rectangle bricksRectangle = brk.getRect();
			if (brk.isVisible()) {
				if (ballRectangle.intersects(bricksRectangle)) {
					this.dirY *= -1;
					 //this.dirX *= -1;
					brk.setVisible(false);
					score += 5;
					bricksCount += 1;
					if (bricksCount == bricks.size()) {
						gameOn = false;
						message = Constants.WIN;
					}
					// System.out.println("Collision Ball Vs Brick");
				}
			}
		}

	}

	private void ballPadCollision() {

		Rectangle ballRectangle = ball.getRect();
		Rectangle padRect = pad.getRect();
		if (ballRectangle.intersects(padRect)) {
			this.dirY *= -1;
			System.out.println("Collision");
		}
	}

	private void movePad() {
		pad.tick();
		// pad.setX(pad.getX()+pad.getSpeed());
		if (pad.getX() <= 0)
			pad.setX(0);
		if (pad.getX() >= Constants.BOARD_WIDTH - 100)
			pad.setX(Constants.BOARD_WIDTH - 100);

	}

	private void moveBall() {

		if (ball.getX() >= Constants.BOARD_WIDTH - 20 && dirX != -1 || ball.getX() <= 0 && dirX != 1)
			this.dirX *= -1;
		// if (shape.getY() >= boardHeight - 20) GameOn = false;
		// if (ball.getY() >= boardHeight - 20 && dirY != -1 || ball.getY() <= 20 &&
		// dirY != 1)
		if (ball.getY() <= 0 && dirY != 1) {
			this.dirY *= -1;
		}
		if (ball.getY() > Constants.BOARD_HEIGHT) {
			gameOn = false;
			this.message = Constants.GAME_OVER;
		}

		this.ball.moveX(dirX);
		this.ball.moveY(dirY);
		// shape is the ball
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);

		Color myColor = this.getRandomColor();
		// g.setColor(myColor);
		drawAll(g);
		drawGameOverStats(g);

	}

	private void drawGameOverStats(Graphics g) {
		if (!gameOn) {
			Font font = new Font("Helvetica", Font.BOLD, 50);
			FontMetrics fontMetrics = this.getFontMetrics(font);
			g.setFont(font);
			g.setColor(Color.GRAY);
			g.drawString(message, (Constants.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
					Constants.BOARD_HEIGHT / 2 - 50);
		}

	}

	public Color getRandomColor() {

		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);

		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

	private void drawAll(Graphics g) {

		// testOne(g);
		drawBall(g);
		drawPad(g);
		drawBricks(g);
		drawStats(g);

	}

	private void drawStats(Graphics g) {
		Font font = new Font("arial", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.GREEN);
		g.drawString("Score : " + score, 20, 20);

	}

	private void drawBricks(Graphics g) {

		for (Bricks br : this.bricks) {
//			g.setColor(Color.GREEN);
//			g.drawRect(br.getX(), br.getY(), 52, 52);
			if (br.isVisible()) {
				Color myColor = br.getColor();
				g.setColor(myColor);
				g.fillRect(br.getX(), br.getY(), 50, 50);
			}

		}
	}

	private void drawPad(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(pad.getX(), pad.getY(), 100, 20);

	}

	private void drawBall(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.ball.getX(), this.ball.getY(), ball.getSize(), ball.getSize());
	}

	private void testOne(Graphics g) {

		String Welcome = "Welcome";
		Font font = new Font("Helvetica", Font.BOLD, 50);
		g.setFont(font);

		g.setColor(Color.YELLOW);
		// g.drawString(Welcome, 350, relY);
		for (int i = 0; i < 10; i++) {
			g.fillOval(relY * i, i * 25, 20, 20);
		}
		g.fillOval(relY, 350, 20, 20);
		g.setColor(Color.RED);
		g.fillOval(350, relY, 20, 20);
		System.out.println("Repainting..");
	}

	private void stop() {
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.loop.stop();
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			pad.setSpeed(-3);
		}

		if (key == KeyEvent.VK_RIGHT) {
			pad.setSpeed(3);
		}
		
		if (key == KeyEvent.VK_SPACE) {
		
		}
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			pad.setSpeed(0);
		}

		if (key == KeyEvent.VK_RIGHT) {
			pad.setSpeed(0);
		}

	}
}
