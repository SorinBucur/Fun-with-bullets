package Shapes;

import Screen.Screen;
import Constants.Symbols;

/**
 * Class that defines the general behaviour of a shape
 */
public class Triunghi extends BasicShape{
	
	/**
	 * Draws the current shape on the given screen
	 * Setez varfurile triunghiului pt a desena linii intre ele
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, 
			Point centerGrav) {
		Point sus, dreapta, stanga;
		sus = centerGrav.translate(0, -2*ref);
		dreapta = centerGrav.translate(ref, ref);
		stanga = centerGrav.translate(-ref, ref);
		screen.drawLineOnScreen(sus, stanga, Symbols.TRIANGLE_SYMBOL);
		screen.drawLineOnScreen(stanga, dreapta, Symbols.TRIANGLE_SYMBOL);
		screen.drawLineOnScreen(dreapta, sus, Symbols.TRIANGLE_SYMBOL);
		
	}
}
