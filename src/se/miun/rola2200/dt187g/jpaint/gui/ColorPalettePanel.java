package se.miun.rola2200.dt187g.jpaint.gui;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ColorPalettePanel extends JPanel {

	/*
	 * Varför behöver vi ha en lista som lagrar ColorPanel-objekt?
	 * Det går givetvis att lösa på olika sätt, men detta är ett enkelt
	 * sätt att kunna anropa addMouseListener på respektive ColorPanel-
	 * objekt som ColorPalettePanel håller. Detta kommer vi göra i metoden
	 * setMouseListenerForColorPanels(MouseListener listener). Mer om detta nedan.
	 * */
	private ArrayList<ColorPanel> colorPanels;
	
	
	/*
	 * Oavsett vilken constructor som anropas layout till ColorPalettePanel
	 * sättas till GridLayout.
	 */
    private GridLayout layout;
	
	 


	/*
	 * För denna constructor så ska listan colorPanels initialiseras.
	 */
	public ColorPalettePanel() {
		colorPanels = new ArrayList<>();
		layout = new GridLayout();
		this.setLayout(layout);
	}
	
	/*
	 * 
	 * För denna constructor så skickas en ArrayList med ColorPanel-objekt,
	 * vilket betyder att våran instansvariabel colorPanels initialiseras 
	 * via constructorn parameter (dvs "this.colorPanels = colorPanels").
	 * Om denna constructor anropas så måste varje ColorPanel-objekt som finns 
	 * i listan läggas till denna klass genom att anropa add-metoden för 
	 * denna klass (så att de blir synliga).
	 */
	public ColorPalettePanel(ArrayList<ColorPanel> colorPanels) {
		this.colorPanels = colorPanels;
		layout = new GridLayout();
        this.setLayout(layout);
		for (var cp : colorPanels) {
			addColorPanel(cp);
		}

	}

	/*
	 * När addColorPanel anropas så ska det ColorPanel-objekt som
	 * skickas som argument läggas till i listan colorPanels 
	 * (detta för att enkelt kunna iterera över de ColorPanels som 
	 * finns tillgängliga inom denna klass i samband med att en 
	 * MouseListener ska sättas).
	 * Den ColorPanel som skickas som argument ska också grafiskt läggas
	 * till denna klass genom att anropa add-metoden för denna klass 
	 * (så att de blir synliga).
	 */
	public void addColorPanel(ColorPanel cp) {
		colorPanels.add(cp);
		this.add(cp);
	}

	/*
	 * Klassen ColorPalettePanel har alltså ingen som helst aning om vad
	 * det MouseListener-objekt som skickas som argument till denna metod gör.
	 * Det är inte heller ColorPalettePanel's ansvar att ha koll på det. Den tar
	 * vilken listener som än skickas som argument och sätter den listenern
	 * på samtliga ColorPanel-objekt genom att anropa .addMouseListener(listener) på
	 * samtliga ColorPanel-objekt som finns i listan.
	 */
	public void setMouseListenerForColorPanels(MouseListener listener) {
		for (var cp : colorPanels) {
			cp.addMouseListener(listener);
		}
	}

}
