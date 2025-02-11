package se.miun.rola2200.dt187g.jpaint.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JPaintFrame extends JFrame {

	private String header;
	private Container c = this.getContentPane();
	private StatusBarPanel statusBarPanel;
	private DrawingPanel drawingPanel;
	private ColorPalettePanel colorPalettePanel;
	private MenuManager menuManager;
	private String drawingTitle;


	public JPaintFrame() {
		init();

		OnChangeListener<StatusBarPanel> listener = new OnChangeListener<StatusBarPanel>() {
            @Override
            public void onChange(StatusBarPanel object) {
                drawingPanel.setDrawColor(object.getSelectedColor());
            }
        };
        
        statusBarPanel.setOnChangeListener(listener);
	}

	public void updateHeader(){
		this.setTitle("JPaint" + " - " + drawingTitle);
	}

	public void setDrawingTitle(String name, String author) {
		if (author != null && !author.isEmpty()) {
			drawingTitle = name + " by " + author;
		} else {
			drawingTitle = name;
		}
		updateHeader();
	}

	public void getDrawingTitle() {
		drawingTitle = drawingPanel.getDrawing().getName() + " by " + drawingPanel.getDrawing().getAuthor();
	}

	private void init() {

		// 1. Sätt storleken på JFrame till vad ni nu känner för.

		this.setSize(800, 600);

		// 2. Se till att programmet stängs ner när man trycker på krysset upp i högra
		// hörnet.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 3. Välj ikon för programmet. Ni kan skapa en mapp som heter "img" i
		 * root-katalogen och hänvisa till den genom "img/filenameOfYourIcon.png".
		 */
		ImageIcon icon = new ImageIcon("img/icon.png");
		JPaintFrame.this.setIconImage(icon.getImage());

		/*
		 * 4. Initialisera strängen "header" med något värde ("JPaint" exempelvis), och
		 * sätt detta som title för programmet. Att vi lagrar vårat applikationsnamn i
		 * en String kommer bli tydligare till kommande uppgifter.
		 */
		header = "JPaint";
		JPaintFrame.this.setTitle(header);

		/*
		 * 5. Sätt layout för denna klass till BorderLayout
		 */
		JPaintFrame.this.setLayout(new BorderLayout());

		/*
		 * 6. Följande kod skapar en JPanel där vi sätter en önskad storlek på höjden
		 * genom att skicka ett Dimension-objekt till prefferedSize (Dimension(width,
		 * height)). Att vi anger width till 0 är mest för att vi inte kommer kunna
		 * påverka detta ändå (den kommer bli så bred som applikationen är bred). Det är
		 * detta JPanel-objekt som kommer inhysa våran ColorPalettePanel samt våran
		 * JComboBox (den som visar vilken typ av form vi ritar).
		 */
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(0, 50));

		/*
		 * 7. Initialisera ColorPalettePanel. Om du väljer att initialisera
		 * ColorPalettePanel via "default"-constructorn (den utan argument), då måste du
		 * anropa addColorPanel för varje ColorPanel-objekt du vill lägga till.
		 * 
		 * Alternativ så anropar du ColorPalettePanel(ArrayList<ColorPanel>) och då
		 * sköter ColorPalettePanel resten
		 */

		ArrayList<ColorPanel> colorPanels = new ArrayList<>();
		colorPalettePanel = new ColorPalettePanel(colorPanels);

		colorPalettePanel.addColorPanel(new ColorPanel(Color.RED));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.GREEN));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.BLUE));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.YELLOW));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.PINK));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.CYAN));
		colorPalettePanel.addColorPanel(new ColorPanel(Color.MAGENTA));

		
		/*
		 * 8.
		 * 8.1 Skapa en String[] som håller "Rectangle" och "Circle"
		 * 8.2 Skapa en JComboBox<String> och initalisera den med arrayen.
		 * 8.3 Välj vilken form som ska vara default.
		 * 
		 * Våran JComboBox kommer vara bunden till den höjd som anges av topPanel.
		 * Däremot så har vi här möjlighet att ange bredd. Sätt bredden till något
		 * rimligt, exempelvis 100.
		 */

		String[] shapes = { "Rectangle", "Circle" };
		JComboBox<String> shapeComboBox = new JComboBox<>(shapes);
		shapeComboBox.addActionListener(e -> {
			JComboBox<String> cb = (JComboBox<String>) e.getSource();
			String shape = (String) cb.getSelectedItem();
			drawingPanel.setActiveShape(shape);
			drawingPanel.repaint();
		});
		shapeComboBox.setPreferredSize(new Dimension(100, 50));


		
		

		/*
		 * 9.
		 * 9.1 Initialisera DrawingPanel
		 * 9.2 Deklarera en CustomMouseAdapter och initialisera den.
		 * 9.3 Lägg till denna CustomMouseAdapter som MouseListener till drawingPanel
		 * 9.4 Lägg även till CustomMouseAdapter som MouseMotionListener till
		 * drawingPanel
		 */
		drawingPanel = new DrawingPanel();
		CustomMouseAdapter customMouseAdapter = new CustomMouseAdapter();
		drawingPanel.addMouseListener(customMouseAdapter);
		drawingPanel.addMouseMotionListener(customMouseAdapter);

		/*
		 * 10.
		 * 10.1 Initialisera StatusBarPanel
		 * 10.2 Sätt en rimlig höjd på StatusBarPanel, exempelvis 25.
		 */
		statusBarPanel = new StatusBarPanel();
		statusBarPanel.setPreferredSize(new Dimension(0, 25));

		/*
		 * 11. Nu när StatusBarPanel väl är initialiserad så kan vi
		 * sätta en MouseListener för våra ColorPanel's. Eftersom vi inte har gått
		 * igenom
		 * anonyma klasser än, och eftersom det enkaste sättet att uträtta detta är
		 * genom en
		 * anonym klass, så följer den med här.
		 * Ni måste fortfarande implementera mousePressed dock.
		 * Det vi vill ska hända är att när ett objekt klickas på, så ska dess
		 * bakgrundsfärg skickas
		 * som argument till StatusBarPanel.updateSelectedColor(Color color).
		 * Vi kommer behöva anropa MouseEvent.getSource() (i ren syntax innebär det
		 * alltså "e.getSource()".
		 * MouseEvent.getSource() returnerar ett Object. Vi kan inte få reda på
		 * bakgrundsfärgen bara genom
		 * ett Object. Så vi måste "casta" det Object som returneras från getSource()
		 * till en ColorPanel.
		 * 
		 * 
		 */
		colorPalettePanel.setMouseListenerForColorPanels(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ColorPanel cp = (ColorPanel) e.getSource();
				statusBarPanel.updateSelectedColor(cp.getColor());

			}
		});

		/*
		 * 12.
		 * 12.1 Sätt layouten för topPanel till BorderLayout.
		 * 12.2 "adda" colorPalettePanel med lämplig constraint (dvs
		 * BorderLayout.LÄMPLIG_CONSTRAINT)
		 * 12.3 "adda" din JComboBox med lämplig constraint (dvs
		 * BorderLayout.LÄMPLIG_CONSTRAINT)
		 */
		topPanel.setLayout(new BorderLayout());
		topPanel.add(colorPalettePanel, BorderLayout.CENTER);
		topPanel.add(shapeComboBox, BorderLayout.EAST);

		/*
		 * 13. Avslutningsvis, lägg till topPanel, drawingPanel och statusBarPanel till
		 * Container c.
		 */
		c.add(topPanel, BorderLayout.NORTH);
		c.add(drawingPanel, BorderLayout.CENTER);
		c.add(statusBarPanel, BorderLayout.SOUTH);

		menuManager = new MenuManager(this, drawingPanel);
		this.setJMenuBar(menuManager.getMenu());

		

	}

	

	class CustomMouseAdapter extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (((Component) e.getSource()).getMousePosition() != null) {
				// Uppdatera koordinater i statusBarPanel
				statusBarPanel.updateCoordinates(e.getX(), e.getY());

				if (drawingPanel.getDrawIsActive()) {
					drawingPanel.setEndPoint(e.getX(), e.getY());
					drawingPanel.repaint();
				}

			} else {
				// Nollställ koordinater i statusBarPanel
				statusBarPanel.updateCoordinates(0, 0);
			}
		}

 		@Override
		public void mouseExited(MouseEvent e) {
			// Nollställ koordinater i statusBarPanel
			statusBarPanel.updateCoordinates(0, 0);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// Uppdatera koordinater i statusBarPanel
			statusBarPanel.updateCoordinates(e.getX(), e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (((Component) e.getSource()) instanceof DrawingPanel) {
				drawingPanel.setDrawIsActive(true);
				drawingPanel.setStartPoint(e.getX(), e.getY());
				
				drawingPanel.setDrawColor(statusBarPanel.getSelectedColor());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			drawingPanel.setDrawIsActive(false);
			drawingPanel.addShape();
		} 
	}



}
