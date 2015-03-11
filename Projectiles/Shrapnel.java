package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.*;

import java.lang.Math;

/**
 * Basic class for all projectiles
 */
public class Shrapnel extends Projectiles{
	
	public Shrapnel(Screen screen, int ref, TimeManager currentTime, BasicShape basicShape, Point shooterPosition) {
		super(screen, ref, currentTime, basicShape, shooterPosition);
		id = 5;
		name = "shrapnel";
		shapeChangingDist = 42 + ( 25*getCurrentTime().getHour() + 5*getCurrentTime().getMinute() + getCurrentTime().getSecond()) % 42;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The action that takes place when the projectile is propagating.
	 * At each propagation step, the shape of the projectile changes
	 * due to the corrosive atmosphere
	 * 
	 * @param dist				distance between the shooter and the screen
	 * @param shooterPosition	the position from which the shooter fires
	 */
	public void shoot(int dist, Point shooterPosition) {
		this.shooterPosition = shooterPosition.translate((int) Math.round(Math.sin(dist*Math.PI/2)), 0);
	}
	
	public void dilatation(int dist, int ref) {
		this.ref = ref - dist/10 - 5;
	}
	
	/**
	 * The action that takes places when the projectile hits the screen 
	 * 
	 * @param shooterPosition	the position from which the shooter fires
	 * @param ref				reference distance			
	 */
	protected void hitScreenAction(Point shooterPosition, int ref) {
		Patrat p = new Patrat();
		p.draw(screen, ref, shooterPosition);
	}
}
