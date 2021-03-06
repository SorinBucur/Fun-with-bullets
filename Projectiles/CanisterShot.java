package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.*;

/**
 * Basic class for all projectiles
 */
public class CanisterShot extends Projectiles{

	
	public CanisterShot(Screen screen, int ref, TimeManager currentTime, BasicShape shape, Point shooterPosition) {
		super(screen, ref, currentTime, shape, shooterPosition);
		id = 3;
		name = "canistershot";
		shapeChangingDist = 42 + ( 9*getCurrentTime().getHour() + 3*getCurrentTime().getMinute() + getCurrentTime().getSecond()) % 42;
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
		this.shooterPosition = shooterPosition.translate(-dist, 0);
	}
	
	public void dilatation(int dist, int ref) {
		this.ref = ref - dist/10 - 3;
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
