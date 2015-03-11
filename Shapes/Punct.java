package Shapes;

import Screen.Screen;
import Constants.Symbols;

/**
 * Class that defines the general behaviour of a shape
 */
public class Punct extends BasicShape{
	
	/**
	 * Draws the current shape on the given screen
	 * Deseneaza doar punctul pt SimpleShell
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, 
			Point centerGrav) {
		screen.drawLineOnScreen(centerGrav, centerGrav, Symbols.DOT_SYMBOL);
	}
}
