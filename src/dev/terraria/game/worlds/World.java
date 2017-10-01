package dev.terraria.game.worlds;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.EntityManager;
import dev.terraria.game.entitys.creatures.Player;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.tiles.GrassTile;
import dev.terraria.game.tiles.Tile;

public class World {

	private Tile[][] tiles;
	private int width, height;
	private int seed;

	private Handler handler;
	private EntityManager entityManager;

	public World(Handler handler, int seed) {
		this.handler = handler;
		this.seed = seed;
		
		this.width = handler.getWidth();
		this.height = handler.getHeight();

		entityManager = new EntityManager(handler, new Player(handler, 0, 0, 4));
		loadWorld();
	}

	public void tick() {
		entityManager.tick();

		Tile tile;
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tile = tiles[x][y];
				if (tile.getCollisionBox().intersects(entityManager.getPlayer().getCollisionBox())) {
					//cause collision
					System.out.println("Colliding");
				}
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return null;
		Tile t = tiles[x][y];
		if(t == null)
			return null;
		return t;
	}

	public void render(Graphics g) {
		entityManager.render(g);

		
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tiles[x][y].render(g);
			}
		}
	}

	public void loadWorld() {
		tiles = new Tile[(width/Tile.TILEWIDTH)+1][1];
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = new GrassTile(x*Tile.TILEWIDTH, height-Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			}
		}
	}

}
