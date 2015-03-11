package Shapes;

import Screen.Screen;
import Constants.Symbols;

/**
 * Class that defines the general behaviour of a shape
 */
public class Patrat extends BasicShape{
	public static Point stangasus, dreaptasus, stangajos, dreaptajos;
	
	/**
	 * Draws the current shape on the given screen
	 * Setez colturile patratului pt a desena linii intre ele
	 * 
	 * @param screen		screen to draw on
	 * @param ref			reference distance
	 * @param centerGrav	center of gravity of the current shape on screen
	 */
	public void draw(Screen screen, int ref, 
			Point centerGrav) {
		//Point stangasus, dreaptasus, stangajos, dreaptajos;
		stangasus = centerGrav.translate(-ref, -ref);
		dreaptasus = centerGrav.translate(ref, -ref);
		stangajos = centerGrav.translate(-ref, ref);
		dreaptajos = centerGrav.translate(ref, ref);
		screen.drawLineOnScreen(dreaptasus, stangasus, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(stangasus, stangajos, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(stangajos, dreaptajos, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(dreaptajos, dreaptasus, Symbols.SQUARE_SYMBOL);
		
	}
}
