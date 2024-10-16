package se.miun.rola2200.dt187g.jpaint.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseAdapter extends MouseAdapter {
    private DrawingPanel drawingPanel;

    public CustomMouseAdapter(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        drawingPanel.setStartPoint(e.getPoint().x, e.getPoint().y);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawingPanel.setEndPoint(e.getPoint().x, e.getPoint().y);
        drawingPanel.repaint(); 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawingPanel.setEndPoint(e.getPoint().x, e.getPoint().y);
        drawingPanel.addShape();
        drawingPanel.repaint();
    }
}
