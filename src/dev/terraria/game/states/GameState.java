package dev.terraria.game.states;

import java.awt.Graphics;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.EntityManager;
import dev.terraria.game.entitys.creatures.Player;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.worlds.World;

public class GameState extends State {
	
	private EntityManager entityManager;
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, 0);
		handler.setWorld(world);
		entityManager = new EntityManager(handler, new Player(handler, 0, 0, 4));
	}

	@Override
	public void tick() {
		entityManager.tick();
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		entityManager.render(g);
		world.render(g);
	}
	
}
