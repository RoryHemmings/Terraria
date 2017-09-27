package dev.terraria.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new StoneTile(1);
	
	private int id;
	private BufferedImage texture;
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y, int width, int height) {
		g.drawImage(texture, x, y, width, height, null);
	}
	
	public int getID() {
		return id;
	}
	
}
