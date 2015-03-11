package Shapes;

import Screen.Screen;
import Constants.Symbols;

/**
 * Class that defines the general behaviour of a shape
 */
public class Romb extends BasicShape{
	
	/**
	 * Draws the current shape on the given screen
	 * Setez varfurile rombului pt a desena linii intre ele
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, 
			Point centerGrav) {
		Point sus, dreapta, stanga, jos;
		sus = centerGrav.translate(0, -2*ref);
		dreapta = centerGrav.translate(ref, 0);
		stanga = centerGrav.translate(-ref, 0);
		jos = centerGrav.translate(0, 2*ref);
		screen.drawLineOnScreen(sus, stanga, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(stanga, jos, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(jos, dreapta, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(dreapta, sus, Symbols.RHOMBUS_SYMBOL);
		
	}
}
