package Shapes;

import Screen.Screen;
import Constants.Symbols;

/**
 * Class that defines the general behaviour of a shape
 */
public class Dreptunghi extends BasicShape{
	
	/**
	 * Draws the current shape on the given screen
	 * Setez colturile dreptunghiului pt a desena linii intre ele
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, 
			Point centerGrav) {
		Point stangasus, dreaptasus, stangajos, dreaptajos;
		stangasus = centerGrav.translate(-2*ref, -ref);
		dreaptasus = centerGrav.translate(2*ref, -ref);
		stangajos = centerGrav.translate(-2*ref, ref);
		dreaptajos = centerGrav.translate(2*ref, ref);
		screen.drawLineOnScreen(dreaptasus, stangasus, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(stangasus, stangajos, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(stangajos, dreaptajos, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(dreaptajos, dreaptasus, Symbols.RECTANGLE_SYMBOL);
		
	}
}
