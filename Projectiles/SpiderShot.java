package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.*;

import java.lang.Math;

/**
 * Basic class for all projectiles
 */
public class SpiderShot extends Projectiles{
	
	
	public SpiderShot(Screen screen, int ref, TimeManager currentTime, BasicShape basicShape, Point shooterPosition) {
		super(screen, ref, currentTime, basicShape, shooterPosition);
		id = 7;
		name = "spidershot";
		shapeChangingDist = 42 + ( 49*getCurrentTime().getHour() + 7*getCurrentTime().getMinute() + getCurrentTime().getSecond()) % 42;
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
		this.shooterPosition = shooterPosition.translate((int) Math.round(Math.sin(dist*Math.PI/2)), (int) Math.round(Math.cos(dist*Math.PI/2)));
	}
	
	public void dilatation(int dist, int ref) {
		this.ref = ref - dist/10 - 7;
	}
	
	/**
	 * The action that takes places when the projectile hits the screen 
	 * 
	 * @param shooterPosition	the position from which the shooter fires
	 * @param ref				reference distance			
	 */
	protected void hitScreenAction(Point shooterPosition, int ref) {
		Dreptunghi d = new Dreptunghi();
		d.draw(screen, ref, shooterPosition);
	}
}
