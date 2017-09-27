package dev.terraria.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	public boolean left, right, space;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = true;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			right = true;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) 
			space = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			left = false;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			right = false;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) 
			space = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
