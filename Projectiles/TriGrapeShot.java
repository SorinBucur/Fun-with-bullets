package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.*;

/**
 * Basic class for all projectiles
 */
public class TriGrapeShot extends Projectiles{
	
	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime, BasicShape basicShape, Point shooterPosition) {
		super(screen, ref, currentTime, basicShape, shooterPosition);
		id = 1;
		name = "trigrapeshot";
		shapeChangingDist = 42 + ( getCurrentTime().getHour() + getCurrentTime().getMinute() + getCurrentTime().getSecond()) % 42;
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
		this.shooterPosition = shooterPosition.translate(dist, 0);
	}
	
	public void dilatation(int dist, int ref) {
		this.ref = ref - dist/10 - 1;
	}
	
	
	/**
	 * The action that takes places when the projectile hits the screen 
	 * 
	 * @param shooterPosition	the position from which the shooter fires
	 * @param ref				reference distance			
	 */
	
	protected void hitScreenAction(Point shooterPosition, int ref) {
		Triunghi t = new Triunghi();
		t.draw(screen, ref, shooterPosition);
	}
}
