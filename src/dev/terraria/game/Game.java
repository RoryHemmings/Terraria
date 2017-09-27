package dev.terraria.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.terraria.game.display.Display;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.input.KeyManager;
import dev.terraria.game.states.GameState;
import dev.terraria.game.states.State;

public class Game implements Runnable{
	
	private int width, height;
	private String title;
	private Display display;
	
	private Graphics g;
	private BufferStrategy bs;
	
	private Handler handler;
	private KeyManager km;
	private double delta;
	
	private State gameState;
	
	private Thread loop;
	private boolean running = false;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	
		loop = new Thread(this);
	}
	
	public void init() {
		display = new Display(title, width, height);
		handler = new Handler(this);
		km = new KeyManager();
		display.getFrame().addKeyListener(km);
		
		Assets.init();
		gameState = new GameState(handler);
		
		State.setState(gameState);
	}

	public void tick() {
		if(State.getState() != null)
			State.getState().tick();
	}
	
	public void render() {
		if(display.getCanvas().getBufferStrategy() == null) {
			display.getCanvas().createBufferStrategy(3);
		}
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		if(State.getState() != null) 
			State.getState().render(g);
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		delta = 0;
		long now;
		long lastTime = System.nanoTime();
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				delta--;
			}
		}
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		loop.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			loop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Display getDisplay() {
		return display;
	}
	
	public KeyManager getKeyManager() {
		return km;
	}
	
	public double getDeltaTime() {
		return delta;
	}
}
