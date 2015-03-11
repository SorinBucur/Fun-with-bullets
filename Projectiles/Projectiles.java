package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.BasicShape;
import Shapes.Point;

/**
 * Basic class for all projectiles
 */
public abstract class Projectiles {
	protected Screen screen;
	protected int ref;
	protected TimeManager currentTime;
	protected int shapeChangingDist;
	protected BasicShape shape;
	protected Point shooterPosition;
	protected String name;
	protected int id;
	
	public Projectiles(Screen screen, int ref, TimeManager currentTime, BasicShape shape, Point shooterPosition) {
		this.screen = screen;
		this.ref = ref;
		this.currentTime = currentTime;
		this.shape = shape;
		this.shooterPosition = shooterPosition;
	}
	
	Screen getScreen() {
		return screen;
	}
	
	int getRef() {
		return ref;
	}
	
	TimeManager getCurrentTime() {
		return currentTime;
	}
	
	BasicShape getShape() {
		return shape;
	}
	
	Point getShooterPosition() {
		return shooterPosition;
	}
	
	/**
	 * The action that takes place when the projectile is propagating.
	 * At each propagation step, the shape of the projectile changes
	 * due to the corrosive atmosphere
	 * 
	 * @param dist				distance between the shooter and the screen
	 * @param shooterPosition	the position from which the shooter fires
	 */
	public abstract void shoot(int dist, Point shooterPosition);
	
	/**
	 * Dilatarea dimensiunilor proiectilelor
	 * Se modifica dupa formula
	 * 
	 * @param dist
	 * @param ref
	 */
	public abstract void dilatation(int dist, int ref);
	
	
	/**
	 * Daca distana este mai mare decat shapeChangingDist 
	 * atunci schimbam centrul de greutate si ref dupa formula proiectilului actual
	 * dupa care trecem la cel in care se transforma
	 * 
	 * @param dist
	 */
	public void changeProjectile(int dist) {
		//System.out.println(name);
		//System.out.println("dist: "+dist+" scd: "+shapeChangingDist);
		if ( dist >= shapeChangingDist ) {
			//System.out.print("schimbare " + shooterPosition.getX() + " " + shooterPosition.getY() + " " + ref);
			shoot(shapeChangingDist, shooterPosition);
			dilatation(shapeChangingDist, ref);
			dist = dist - shapeChangingDist;
			//System.out.println(" || " + shooterPosition.getX() + " " + shooterPosition.getY() + " " + ref);
			switch (name) {
			case "canistershot": {
				HeatedShot hs = new HeatedShot(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				hs.changeProjectile(dist);
				break;
			}
			case "carcass": {
				HeatedShot hs = new HeatedShot(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				hs.changeProjectile(dist);
				break;
			}
			case "chainshot": {
				Shrapnel sh = new Shrapnel(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				sh.changeProjectile(dist);
				break;
			}
			case "heatedshot": {
				SpiderShot ss = new SpiderShot(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				ss.changeProjectile(dist);
				break;
			}
			case "shrapnel": {
				SpiderShot ss = new SpiderShot(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				ss.changeProjectile(dist);
				break;
			}
			case "spidershot": {
				SimpleShell s = new SimpleShell(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				s.changeProjectile(dist);
				break;
			}
			case "trigrapeshot": {
				Shrapnel sh = new Shrapnel(getScreen(), getRef(), getCurrentTime(), getShape(), getShooterPosition());
				//System.out.println(name);
				sh.changeProjectile(dist);
				break;
			}
			}
		}
		
		else {
			//System.out.print("pozitie " + shooterPosition.getX() + " " + shooterPosition.getY() + " " + ref + " | " );
			shoot(dist, shooterPosition);
			dilatation(dist, ref);
			//System.out.println(name + " pozitie " + shooterPosition.getX() + " " + shooterPosition.getY() + " " + ref);
			hitScreenAction(shooterPosition, ref);
			
		}
	}
	
	/**
	 * The action that takes places when the projectile hits the screen 
	 * 
	 * @param shooterPosition	the position from which the shooter fires
	 * @param ref				reference distance			
	 */
	protected abstract void hitScreenAction(Point shooterPosition, int ref);
	
}
