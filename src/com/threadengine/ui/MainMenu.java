package com.threadengine.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import com.threadengine.constants.Constants;



public class MainMenu extends MouseAdapter{

	
	private MainPanel gamePanel;
	 private Font font;
	 private Font fontMenu;
	 private static final int BUTTON_WIDTH = 200;
	 private static final int BUTTON_HEIGHT = 60;
	 private static final String PLAY = "PLAY";
	    private static final String HELP = "HELP";
	    private static final String QUIT = "QUIT";
	    private static final String MENU = "MENU";
	    private static final String BACK = "BACK";
	    private int count;
	


	public MainMenu(MainPanel gamePanel) {
		this.gamePanel = gamePanel;
		initVar();
	}
	
	
	private void initVar() {
		this.font = new Font("Gotham", Font.BOLD, 30);
		this.fontMenu = new Font("Gotham", Font.BOLD, 50);
		
	}
	
	 public void mousePressed(MouseEvent e) {

	        int mouseX = e.getX();
	        int mouseY = e.getY();

	        //boolean mousePressed = mouseOver(mouseX,mouseY,ConstantVariables.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT);

	        //PLAY Button
	        if(mouseOver(mouseX,mouseY,Constants.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT)) {
	            this.gamePanel.setGameState(State.PLAY);
	           // game.gameState = State.GAME;
	            System.out.println(gamePanel.getGameState());
	            //this.setState(State.GAME);
	        }
	        //HELP Button
	        if(mouseOver(mouseX,mouseY,Constants.BOARD_WIDTH/2 -100,300,BUTTON_WIDTH,BUTTON_HEIGHT)){
	            this.gamePanel.setGameState(State.HELP);
	            System.out.println(gamePanel.getGameState());
	        }
	        //BACK Button
	        if(gamePanel.getGameState() == State.HELP){
	            if(mouseOver(mouseX,mouseY,100,Constants.BOARD_HEIGHT-100,100,40)){
	                this.gamePanel.setGameState(State.MENU);
	                System.out.println("Back Button Pressed");
	                System.out.println(gamePanel.getGameState());
	                return;
	            }
	        }

	        if(gamePanel.getGameState() == State.HELP){
	            if(mouseOver(mouseX, mouseY,Constants.BOARD_WIDTH -200,Constants.BOARD_HEIGHT -100,100,40 )){
	                this.gamePanel.setGameState(State.PLAY);
	                System.out.println("Help/Play Button Pressed");
	            }
	        }
	        //QUIT Button
	        if(mouseOver(mouseX,mouseY,Constants.BOARD_WIDTH/2 -100,400,BUTTON_WIDTH,BUTTON_HEIGHT)){
	            System.exit(1);
	        }

	    }

	//mouse Over a Button
	
	  public void mouseReleased(MouseEvent e) {

	    }

	    private boolean mouseOver(int mx, int my,int x, int y, int width, int height ){
	        if(mx > x && mx < x + width){
	            if(my > y && my < y + height){
	                return true;
	            }else return false;
	        }else return false;
	    }
	    

	public void renderMenu(Graphics g) {
		if(gamePanel.getGameState()== State.MENU) {
			FontMetrics fontMetrics = g.getFontMetrics(this.font);
            FontMetrics fontMenuMetrics = g.getFontMetrics(this.fontMenu);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 912, 762);
            
            //the menu
            g.setFont(fontMenu);
            g.setColor(Color.YELLOW);
            g.drawString(MENU, Constants.BOARD_WIDTH / 2 - fontMenuMetrics.stringWidth(MENU) /2,135 );

            //The Play Button
            g.setColor(Color.white);
            g.drawRect(Constants.BOARD_WIDTH/2 -100,200,BUTTON_WIDTH,BUTTON_HEIGHT);
            g.setColor(Color.BLUE);
            g.fillRect(Constants.BOARD_WIDTH/2 -97,202,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
            g.setFont(font);
            g.setColor(Color.YELLOW);
            g.drawString(PLAY, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(PLAY) /2,240 );
            
            //The Help Button
            g.setColor(Color.white);
            g.drawRect(Constants.BOARD_WIDTH/2 -100,300,BUTTON_WIDTH,BUTTON_HEIGHT);
            g.setColor(Color.BLUE);
            g.fillRect(Constants.BOARD_WIDTH/2 -97,302,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
            g.setColor(Color.YELLOW);
            g.drawString(HELP,Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(HELP) /2,340 );

            //The Quit Button
            g.setColor(Color.white);
            g.drawRect(Constants.BOARD_WIDTH/2 -100,400,BUTTON_WIDTH,BUTTON_HEIGHT);
            g.setColor(Color.BLUE);
            g.fillRect(Constants.BOARD_WIDTH/2 -97,402,BUTTON_WIDTH-6,BUTTON_HEIGHT-5);
            g.setColor(Color.YELLOW);
            g.drawString(QUIT,Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(QUIT) /2,440 );
            
            g.setColor(Color.GREEN);
            g.drawString("Press Space to Play", 20, 730);
            g.drawString("Esc to Quit", 700, 730);
            gamePanel.repaint();
            
		}
		 else if(gamePanel.getGameState() == State.HELP){
			 
			   FontMetrics fontMenuMetrics = g.getFontMetrics(this.fontMenu);
	           Font font = new Font("Gotham", Font.BOLD, 30);
	           FontMetrics fontMetrics = g.getFontMetrics(font);
	           Font fontMenu = new Font("Gotham", Font.BOLD, 50);
	         
	           //The entire board
	           g.setColor(Color.BLACK);
	           g.fillRect(0,0,Constants.BOARD_WIDTH+12,Constants.BOARD_HEIGHT+12);
	           //the title
	           g.setFont(fontMenu);
	            g.setColor(Color.YELLOW);
	            g.drawString("HELP", Constants.BOARD_WIDTH / 2 - fontMenuMetrics.stringWidth(MENU) /2,135 );
	            g.setFont(font);
	            g.setColor(Color.GREEN);
	            String rules = "The rules are pretty simple:";
	            String line1 = "1. Break all the bricks on the map";
	            String line2 = "2. Don`t lose the ball";
	            String line3 = "3. Have Fun";
	            String line4 = "Hint : Use <- -> to move the padle";
	            g.drawString(rules, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(rules) /2,200 );
	            g.drawString(line1, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(rules) /2,250 );
	            g.drawString(line2, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(rules) /2,300 );
	            g.drawString(line3, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(rules) /2,350 );
	            g.drawString(line4, Constants.BOARD_WIDTH / 2 - fontMetrics.stringWidth(rules) /2,500 );
	           
	           //Back Button
	           
	           g.setColor(Color.white);
	           g.drawRect(100,Constants.BOARD_HEIGHT -100,100,40);
	           g.setColor(Color.BLUE);
	           g.fillRect(102,Constants.BOARD_HEIGHT -98,98,38);
	           g.setColor(Color.YELLOW);
	           g.setFont(font);
	           g.drawString(BACK,108,Constants.BOARD_HEIGHT-70);
	           
	           //Play Button
	           
	           g.setColor(Color.white);
	           g.drawRect(Constants.BOARD_WIDTH -200,Constants.BOARD_HEIGHT -100,100,40);
	           g.setColor(Color.BLUE);
	           g.fillRect(Constants.BOARD_WIDTH -198,Constants.BOARD_HEIGHT -98,98,38);
	           g.setFont(font);
	           g.setColor(Color.YELLOW);
	           g.drawString(PLAY,Constants.BOARD_WIDTH -190,Constants.BOARD_HEIGHT-70);
		 }
		
	           
	}
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

}
