package jab.module;

import java.awt.event.InputEvent;

import robocode.Event;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		bot.setAhead(Double.POSITIVE_INFINITY * moveDirection);
		bot.setTurnRight(45 * turnDirection);
		bot.execute();
	}

	public void listen(Event e) {
	}

	public void listenInput(InputEvent e) {
		if (e instanceof java.awt.event.KeyEvent) {
			int keyID = ((java.awt.event.KeyEvent) e).getID();
			int keyCode = ((java.awt.event.KeyEvent) e).getKeyCode();

			if (keyID == 401) { // 401 = KeyEvent.KEY_PRESSED
				switch (keyCode) {
				case 38: // VK_UP
					moveDirection = 1;
					isMoving = true;
					break;
				case 40: // VK_DOWN
					moveDirection = -1;
					isMoving = true;
					break;
				case 39: // VK_RIGHT
					turnDirection = 1;
					break;
				case 37: // VK_LEFT
					turnDirection = -1;
					break;
				}
				move(); // Pastikan move() dieksekusi setiap kali tombol ditekan
			}

			else if (keyID == 402) { // 402 = KeyEvent.KEY_RELEASED
				switch (keyCode) {
				case 38: // VK_UP
				case 40: // VK_DOWN
					moveDirection = 0;
					isMoving = false;
					bot.setAhead(0); // Stop gerakan saat tombol dilepas
					break;
				case 39: // VK_RIGHT
				case 37: // VK_LEFT
					turnDirection = 0;
					break;
				}
				move(); // Panggil move() agar posisi update setelah tombol dilepas
			}
		}
	}

	int moveDirection = 0;
	int turnDirection = 0;
	boolean isMoving = false;

}
