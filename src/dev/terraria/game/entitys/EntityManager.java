package dev.terraria.game.entitys;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.creatures.Player;

public class EntityManager {
	
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Handler handler;
	private Player player;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		addEntity(player);
	}
	
	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
