package dev.terraria.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage grass_block, stone_block, player_left, player_right;
	private static SpriteSheet sheet;
	
	private static final int width = 16, height = 16;
	
	public static void init () {
		sheet = new SpriteSheet(ImageLoader.loadImage("res/Sheet.png"));
		
		grass_block = sheet.crop(0, 0, width, height);
		stone_block = sheet.crop(width, 0, width, height);
		player_right = sheet.crop(0, height, 15, 24);
		player_left = sheet.crop(15, height, 15, 24);
	}
	
}
