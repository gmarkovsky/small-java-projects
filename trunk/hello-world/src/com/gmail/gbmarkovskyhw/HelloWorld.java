package com.gmail.gbmarkovskyhw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HelloWorld extends JFrame implements Runnable {
	private static final String HELLO_KITTY = "Hello Kitty!";
	private static final String HELLO_WORLD = "Hello world!";
	private static final long serialVersionUID = -5548007195374209578L;
	private JButton label;
	protected boolean order = true;
	
	
	public HelloWorld() {
		super("Hello application");
		label = new JButton(HELLO_WORLD);
		label.setFont(new Font("Arial", Font.BOLD, 72));
		label.setFocusable(false);
		label.setForeground(Color.GREEN);
		label.setBackground(Color.RED);
		
		add(label);
		
		final Random random = new Random();
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				label.setForeground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				label.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			}
		}, 0, 400);
		
		Timer timer2 = new Timer();
		
		timer2.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (order) {
					label.setText(HELLO_KITTY);
				} else {
					label.setText(HELLO_WORLD);
				}
				order = !order;
			}
		}, 0, 2000);
		
		
		setSize(640, 480);
		setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		new HelloWorld().setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new HelloWorld());
	}
}
