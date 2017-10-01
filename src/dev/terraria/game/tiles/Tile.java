package dev.terraria.game.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	
	protected int id;
	protected BufferedImage texture;
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected int x, y, width, height;
	private Rectangle collisionBox;
	
	public Tile(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.collisionBox = new Rectangle(x, y, width, height);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public int getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return id + " | ";
	}
}
