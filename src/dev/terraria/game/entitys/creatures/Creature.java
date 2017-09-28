package dev.terraria.game.entitys.creatures;

import java.awt.Rectangle;

import dev.terraria.game.Handler;
import dev.terraria.game.entitys.Entity;

public abstract class Creature extends Entity {

	protected boolean isMoving = false;
	protected int moveX, moveY;

	double power = 0;
	private final double jump_power = 10;
	public static final double gravity = -0.5;
	protected boolean isGrounded;
	private boolean hasLanded = false;

	protected boolean jump = false;
	protected boolean continueJumping = true;
	
	protected Rectangle collisionBox;

	public Creature(Handler handler, int x, int y, Rectangle collisionBox) {
		super(handler, x, y);
		this.collisionBox = collisionBox;
		System.out.println(collisionBox);
	}

	public void move() {
		x += moveX;
		y = (int) (y - (handler.getGame().getDeltaTime() * power));
	}
	
	protected void updateCollisionBoxPosition() {
		collisionBox.x = x + collisionBox.width/2;
		collisionBox.y = y + collisionBox.height/2;
	}

	public void jump() {
		power = jump_power;
		hasLanded = false;
	}

	public void addGravity() {
		if (!isGrounded) {
			power = power + (handler.getGame().getDeltaTime() * gravity);
		} else if (isGrounded) {
			if (!hasLanded) {
				land();
				hasLanded = true;
			}
		}
	}
	
	public void land() {
		power = 0;
		jump = false;
		continueJumping = true;
	}

	public void setMoving(boolean m) {
		isMoving = m;
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public boolean isGrounded() {
		return isGrounded;
	}

	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}

	public boolean isMoving() {
		return isMoving;
	}

	protected int health;
}
