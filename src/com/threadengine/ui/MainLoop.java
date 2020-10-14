package com.threadengine.ui;

public class MainLoop implements Runnable {

	private MainPanel panel;
	private Thread thread;
	private boolean inGame;

	public MainLoop(MainPanel panel) {
		this.panel = panel;
		this.thread = new Thread();
		this.inGame = true;
	}

	public void init() {

		this.thread.start();
		System.out.println("Mainloop start on");
	}

	@Override
	public void run() {

		while (inGame) {

			try {
				
				//System.out.println("MainLoop ticking");
				this.thread.sleep(10/2);
				this.panel.render();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void stop() {
		System.out.println("Stopping");
		inGame = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
