package dev.terraria.game.tiles;

import java.awt.Rectangle;

import dev.terraria.game.gfx.Assets;

public class StoneTile extends Tile {
	public StoneTile(int id, Rectangle collisionBox) {
		super(Assets.stone_block, id, collisionBox);
	}
}
