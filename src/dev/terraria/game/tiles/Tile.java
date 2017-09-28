package dev.terraria.game.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0, new Rectangle(Tile.TILEWIDTH, Tile.TILEHEIGHT));
	public static Tile stoneTile = new StoneTile(1, new Rectangle(Tile.TILEWIDTH, Tile.TILEHEIGHT));
	
	private int id;
	private BufferedImage texture;
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	private Rectangle collisionBox;
	private boolean first = true;
	private int x, y;
	
	public Tile(BufferedImage texture, int id, Rectangle collisionBox) {
		this.texture = texture;
		this.id = id;
		this.collisionBox = collisionBox;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y, int width, int height) {
//		if (first) {
//			collisionBox.x = x;
//			collisionBox.y = y;
//			first = false;
//		}
			
		g.drawImage(texture, x, y, width, height, null);
		g.fillRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
	public int getID() {
		return id;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	public String toString() {
		return id + " | ";
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		collisionBox.x = x;
		collisionBox.y = y;
	}
}
