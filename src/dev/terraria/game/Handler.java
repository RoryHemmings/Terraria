package dev.terraria.game;

import dev.terraria.game.worlds.World;

public class Handler {
	
	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public void setWorld(World w) {
		this.world = w;
	}
	
	public World getWorld() {
		return world;
	}
	
	public static float clamp(float val, float min, float max) {
	    return Math.max(min, Math.min(max, val));
	}
}
