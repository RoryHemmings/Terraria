package dev.terraria.game.states;

import java.awt.Graphics;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.EntityManager;
import dev.terraria.game.entitys.creatures.Player;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.worlds.World;

public class GameState extends State {
	
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, 0);
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
}
