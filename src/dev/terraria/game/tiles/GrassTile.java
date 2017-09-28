package dev.terraria.game.tiles;

import java.awt.Rectangle;

import dev.terraria.game.gfx.Assets;

public class GrassTile extends Tile {
	
	public GrassTile(int id, Rectangle collisionBox) {
		super(Assets.grass_block, id, collisionBox);
	}
	
}
