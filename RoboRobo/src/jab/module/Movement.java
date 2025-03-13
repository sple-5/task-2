package jab.module;

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
		bot.setMaxVelocity(8);
		bot.setAhead(10000);
	}

	public void listen(Event e) {
		if (e instanceof robocode.HitWallEvent) {
			bot.setTurnRight(45);
		}
	}

}
