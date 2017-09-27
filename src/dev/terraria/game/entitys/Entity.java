package dev.terraria.game.entitys;

import java.awt.Graphics;

import dev.terraria.game.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected int x, y, width, height;
	
	public Entity(Handler handler, int x, int y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

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
	
	
}
