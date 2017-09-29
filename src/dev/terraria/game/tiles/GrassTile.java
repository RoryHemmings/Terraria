package dev.terraria.game.tiles;

import dev.terraria.game.gfx.Assets;

public class GrassTile extends Tile {
	
	public GrassTile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.texture = Assets.grass_block;
	}
	
}
