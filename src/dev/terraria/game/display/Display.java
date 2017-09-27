package dev.terraria.game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private int width, height;
	private String title;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Display (String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		makeDisplay();
	}
	
	public void makeDisplay() {
		Dimension size = new Dimension(width, height);
		frame = new JFrame(title);
		canvas = new Canvas();
		
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		canvas.setPreferredSize(size);
		canvas.setMinimumSize(size);
		canvas.setMaximumSize(size);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
