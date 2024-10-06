package se.miun.rola2200.dt187g.jpaint.gui;

import java.awt.Color;

import javax.swing.JPanel;

import se.miun.rola2200.dt187g.jpaint.Drawing;

public class DrawingPanel extends JPanel {

	private Drawing drawing;
	

	/*
	 * Beroende på vilken konstruktor som anropas så kommer antingen 
	 * bakgrunden för denna komponent sättas till den färg som skickas som argument,
	 * alternativt sätts bakgrunden till vit (Color.WHITE).
	 */
	
	public DrawingPanel() {
		setBackground(Color.WHITE);
	}
	
	public DrawingPanel(Color background) {
		setBackground(background);
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public Drawing getDrawing() {
		return this.drawing;
	}
	
}
