package se.miun.rola2200.dt187g.jpaint.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.lang.reflect.Field;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import se.miun.rola2200.dt187g.jpaint.Drawable;
import se.miun.rola2200.dt187g.jpaint.Drawing;
import se.miun.rola2200.dt187g.jpaint.DrawingException;

/**
 * <h1>MenuManager</h1>
 *
 * @author --YOUR NAME HERE--
 * @version 0.1
 * @since YYYY-MM-DD
 */
public class MenuManager {
	private JPaintFrame frame;
	private DrawingPanel drawingPanel;
	private Menu menu;

	public MenuManager(JPaintFrame frame, DrawingPanel drawingPanel) {
		this.frame = frame;
		this.drawingPanel = drawingPanel;
		this.menu = new Menu();
		createMenu();
	}

	public Menu getMenu() {
		return menu;
	}

	private void createMenu() {
		createFileMenu();
		createEditMenu();
		createFilterMenu(); 
	}

	private void createFileMenu() {
		String sFile = "File";
		menu.addJMenu(sFile);
		menu.getJMenu(0).setMnemonic(KeyEvent.VK_F);

		menu.addJMenuItem(sFile, "New...", createNewDrawingAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Load...", createLoadAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Save As...", createSaveAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sFile, "Info", showInfoAction());

		menu.getJMenu(0).addSeparator();
		menu.addJMenuItem(sFile, "Exit", al -> System.exit(0));

	}

	private void createEditMenu() {
		String sEdit = "Edit";
		String sDrawing = "Drawing";
		menu.addJMenu(sEdit);
		menu.addSubJMenu(sEdit, sDrawing);
		menu.getJMenu(1).setMnemonic(KeyEvent.VK_E);

		menu.addJMenuItem(sEdit, "Undo", createUndoAction(),
				KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		menu.addJMenuItem(sDrawing, "Name...", createChangeNameAction());
		menu.addJMenuItem(sDrawing, "Author...", createChangeAuthorAction());

		/*
		 * Denna rad, som du inte får ta bort, kommer skapa ett NullException.
		 * Du måste hantera denna situation i Menu-klassen. I vanliga fall
		 * hade det varit rimligt att ett Exception kastades (klienten bör
		 * i vanliga fall göras medveten om att den försöker skapa ett
		 * JMenuItem till en JMenu som inte existerar), men nu räcker
		 * det med att ingenting alls händer i det läget man anropar
		 * addJMenuItem med en sträng som inte kan hittas.
		 */
		menu.addJMenuItem("This JMenu doesn't exist", "abc");

	}

	private void createFilterMenu() {
		// TODO for assignment 6

	}

	/*
	 * Flera av metoderna nedan kommer anropa JOptionPane.showInputDialog(...).
	 * Denna metod returnerar en String. Tänk på att om användaren trycker på
	 * "Cancel" så kommer null att returneras. När en användare trycker på "Cancel"
	 * så ska givetvis ingenting alls hända; inget felmeddelande till användaren,
	 * inget ändring av det grafiska gränssnittets tillstånd (en teckning ska
	 * inte plötsligt få namnet "null"). Jag har sett många inlämningar där
	 * "Cancel" har hanterats på tämligen oväntade sätt. Så håll det i åtanke,
	 * att Cancel/Avbryt innebär just den saken.
	 * 
	 */

	private ActionListener createNewDrawingAction() {
		return al -> {
			String name = JOptionPane.showInputDialog(frame, "Enter new drawing name:");
			if (name == null)
				return;

			String author = JOptionPane.showInputDialog(frame, "Enter author's name:");
			if (author == null)
				return;

			try {
				Drawing newDrawing = new Drawing(name, author);
				drawingPanel.setDrawing(newDrawing);
				frame.setDrawingTitle(newDrawing.getName(), newDrawing.getAuthor());
			} catch (DrawingException e) {
				JOptionPane.showMessageDialog(frame, e.getMessage(), "JPaint", JOptionPane.ERROR_MESSAGE);
			}
		};
	}

	private ActionListener createChangeNameAction() {
		return al -> {
			String name = JOptionPane.showInputDialog(frame, "Enter new drawing name:");
			if (name != null) {
				Drawing drawing = drawingPanel.getDrawing();

				// ny drawing tjosan
				if (drawing == null) {
					drawing = new Drawing();
					drawingPanel.setDrawing(drawing);
				}
				try {
					drawing.setName(name);
					frame.setDrawingTitle(drawing.getName(), drawing.getAuthor());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}

	private ActionListener createChangeAuthorAction() {
		return al -> {
			String author = JOptionPane.showInputDialog(frame, "Enter new author name:");
			if (author != null) {
				Drawing drawing = drawingPanel.getDrawing();

				if (drawing == null) {
					drawing = new Drawing();
					drawingPanel.setDrawing(drawing);
				}
				try {
					drawing.setAuthor(author);
					frame.setDrawingTitle(drawing.getName(), drawing.getAuthor());
				} catch (DrawingException e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}

	private ActionListener createUndoAction() {
		return al -> {
			// TODO for assignment 5
			Drawing drawing = drawingPanel.getDrawing();

			if (drawing.getSize() > 0) {
				drawing.removeShape(drawing.getSize() - 1);
				drawingPanel.repaint();
			}
		};
	}

	private ActionListener showInfoAction() {
    return al -> {
        Drawing drawing = drawingPanel.getDrawing();
       
                String name = drawing.getName();
                int numberOfShapes = drawing.getSize();
				double totalArea = drawing.getTotalArea(); // Example method, replace with actual
				double totalCircumference = drawing.getTotalCircumference();

                String message = String.format(
                    "Name: %s\nNumber of shapes: %d\nTotal area: %.2f\nTotal circumference: %.2f",
                    name, numberOfShapes, totalArea, totalCircumference
                );

                JOptionPane.showMessageDialog(frame, message, "Drawing Info", JOptionPane.INFORMATION_MESSAGE);
           
    };
}

	private ActionListener createLoadAction() {
		return al -> {
			// TODO for assignment 6
			Drawing drawing = drawingPanel.getDrawing();
			drawing.getSize();
		};
	}

	private ActionListener createSaveAction() {
		return al -> {
			// TODO for assignment 6
		};
	}

}
