package dev.terraria.game.entitys.creatures;

import java.awt.Graphics;

import dev.terraria.game.Handler;
import dev.terraria.game.gfx.Assets;
import dev.terraria.game.tiles.Tile;

public class Player extends Creature {

	private int size;

	private final int speed = 5;
	public static final int LEFT = 0, RIGHT = 1;
	private int direction = RIGHT;

	public static int groundOffset;

	public Player(Handler handler, int x, int y, int size) {
		super(handler, x, y);
		this.size = size;
		this.width = Assets.player_right.getWidth();
		this.height = Assets.player_right.getHeight();

		groundOffset = handler.getHeight() - height * size - Tile.TILEHEIGHT;
		// this.y = groundOffset;
		this.y = 200;
	}

	@Override
	public void tick() {
		handleInput();
		move();

		updateGroundOffset();
		addGravity();
		checkJump();
		checkIfGrounded();
	}

	public void handleInput() {
		moveX = 0;
		moveY = 0;
		if (handler.getGame().getKeyManager().right) {
			moveX = speed;
			setDirection(RIGHT);
		} else if (handler.getGame().getKeyManager().left) {
			moveX = -speed;
			setDirection(LEFT);
		}
		if (handler.getGame().getKeyManager().space) {
			jump = true;
		}
	}

	public void checkJump() {
		if (jump && continueJumping) {
			jump();
			continueJumping = false;
		}
	}

	public void checkForMotion() {
		if (moveX != 0 || moveY != 0)
			this.setMoving(false);
		else
			this.setMoving(true);
	}

	public void updateGroundOffset() {

	}

	public void checkIfGrounded() {
		if (y >= groundOffset) {
			y = groundOffset;
			setGrounded(true);
		} else
			setGrounded(false);
	}

	@Override
	public void render(Graphics g) {
		if (direction == LEFT)
			g.drawImage(Assets.player_left, x, y, Assets.player_right.getWidth() * size,
					Assets.player_right.getHeight() * size, null);
		else if (direction == RIGHT)
			g.drawImage(Assets.player_right, x, y, Assets.player_right.getWidth() * size,
					Assets.player_right.getHeight() * size, null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
