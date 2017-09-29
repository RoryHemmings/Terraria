package dev.terraria.game.tiles;

import dev.terraria.game.gfx.Assets;

public class StoneTile extends Tile {
	public StoneTile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.texture = Assets.stone_block;
	}
}
