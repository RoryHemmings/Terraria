package dev.terraria.game.worlds;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.EntityManager;
import dev.terraria.game.entitys.creatures.Player;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.tiles.Tile;

public class World {

	private int[][] tiles;
	private int width, height;
	private int seed;

	private Handler handler;
	private EntityManager entityManager;

	public World(Handler handler, int seed) {
		this.handler = handler;
		this.seed = seed;

		entityManager = new EntityManager(handler, new Player(handler, 0, 0, 4, new Rectangle(Assets.player_right.getWidth() * 4, Assets.player_right.getWidth() * 4)));
		loadWorld();
	}

	public void tick() {
		entityManager.tick();

		Tile tile;
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tile = Tile.tiles[tiles[x][y]];
				if (tile.getCollisionBox().intersects(entityManager.getPlayer().getCollisionBox())) {
					//cause collision
					System.out.println("Colliding");
				}
			}
		}
	}

	public void render(Graphics g) {
		entityManager.render(g);

		
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				System.out.println(Tile.tiles[tiles[x][y]].getCollisionBox());
				Tile.tiles[tiles[x][y]].render(g, x * Tile.TILEWIDTH, handler.getHeight() - Tile.TILEHEIGHT * (y + 1),
						Tile.TILEWIDTH, Tile.TILEHEIGHT);
			}
		}
	}

	public void loadWorld() {
		tiles = new int[(handler.getWidth() / Tile.TILEWIDTH) + 1][1];
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[0].length; y++) {
				tiles[x][y] = 0;
				Tile.tiles[tiles[x][y]].setPos(x * Tile.TILEWIDTH, handler.getHeight() - Tile.TILEHEIGHT * (y + 1));
				System.out.println(Tile.tiles[tiles[x][y]].getCollisionBox());
			}
		}
	}

}
