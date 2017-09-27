package dev.terraria.game.worlds;

import java.awt.Graphics;

import dev.terraria.game.Handler;
import dev.terraria.game.tiles.Tile;

public class World {
	
	private int[][] tiles;
	private int width, height;
	private int seed;
	
	private Handler handler;
	
	public World(Handler handler, int seed) {
		this.handler = handler;
		this.seed = seed;
		
		loadWorld();
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for (int x=0;x<tiles.length;x++) {
			for (int y=0;y<tiles[0].length;y++)
				Tile.tiles[tiles[x][y]].render(g, x*Tile.TILEWIDTH, handler.getHeight() - Tile.TILEHEIGHT*(y+1), Tile.TILEWIDTH, Tile.TILEHEIGHT);
		}
	}
	
	public void loadWorld() {
		tiles = new int[(handler.getWidth() / Tile.TILEWIDTH) + 1][1];
		for (int x=0;x<tiles.length;x++) {
			for (int y=0;y<tiles[0].length;y++) {
				if (!(x == 5 && y == 1))
					tiles[x][y] = 0;
			}
		}
	}
	
}
