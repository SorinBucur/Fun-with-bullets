package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.*;

/**
 * Basic class for all projectiles
 */
public class SimpleShell extends Projectiles{
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime, BasicShape basicShape, Point shooterPosition) {
		super(screen, ref, currentTime, basicShape, shooterPosition);
		id = 8;
		name = "simpleshell";
		shapeChangingDist = Integer.MAX_VALUE;
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
		this.shooterPosition = shooterPosition;
	}
	
	public void dilatation(int dist, int ref) {
		this.ref = ref;
	}
	
	/**
	 * The action that takes places when the projectile hits the screen 
	 * 
	 * @param shooterPosition	the position from which the shooter fires
	 * @param ref				reference distance			
	 */
	protected void hitScreenAction(Point shooterPosition, int ref) {
		Punct p = new Punct();
		p.draw(screen, ref, shooterPosition);
	}
}
