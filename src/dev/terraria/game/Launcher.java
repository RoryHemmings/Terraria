package dev.terraria.game;

import dev.terraria.game.display.Display;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Terraria", 1200, 800);
		game.start();
	}
}
