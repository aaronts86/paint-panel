/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

/**
 * The <code>PaintPanel</code> class holds the panel the doodle will be drawn on.
 *
 * @author Aaron Schraufnagel
 * @custom.inv myR must be 0 or 255
 *             myG must be 0 or 255
 *             myB must be 0 or 255
 */
@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
    /**
     * Static final variable the holds the default toolkit value.
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    /**
     * Static final variable that holds the screen size.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    /**
     * Static final variable that holds the screen width.
     */
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width / 2;
    
    /**
     * Static final variable that holds the screen height.
     */
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height / 2;
    
    /**
     * Static final variable that holds the size of the screen.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

    /**
     * Represents the starting point of the line.
     */
    private Point myStartPoint;
    /**
     * Represents the end point of the line.
     */
    private Point myEndPoint;
    /**
     * Inner class object representation of the adapter class to handle mouse movement.
     */
    private MouseDoodleAdapter myAdapter;
    /**
     * Represents the drawing path.
     */
    private GeneralPath myPath;
    /**
     * List that holds the previous drawn components on the panel.
     */
    private List<PaintStore> myDrawing;
    /**
     * Represents the size of the stroke.
     */
    private BasicStroke myStroke;
    /**
     * Represents the level of red in RGB form, 0 or 255.
     */
    private int myR;
    /**
     * Represents the level of green in RGB form, 0 or 255.
     */
    private int myG;
    /**
     * Represents the level of blue in RGB form, 0 or 255.
     */
    private int myB;
    
  /**
   * The default constructor for the PaintPanel.
   * @custom.post the components for the PaintPanel are initialized.
   */
    public PaintPanel() {
        super();
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.WHITE);
        myAdapter = new MouseDoodleAdapter();
        addMouseListener(myAdapter);
        addMouseMotionListener(myAdapter);
        myPath = new GeneralPath();
        myDrawing = new ArrayList<>();
        myStroke = new BasicStroke(1);
    }

    /**
     * The paint component that draws the user's doodle on the panel.
     * @param aGraphics The graphics opbject to draw the doodle
     * @custom.post The doodle is drawn on the panel.
     */
    @Override
    public void paintComponent(final Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        final Graphics2D g2d = (Graphics2D) aGraphics;
        
        if (myStartPoint != null) {
            g2d.setStroke(myStroke);
            g2d.setColor(new Color(myR, myG, myB));
            g2d.draw(myPath);
            for (PaintStore p: myDrawing) {
                g2d.setStroke(p.getMyStroke());
                g2d.setColor(p.getMyColor());
                final GeneralPath savePath = p.getMyPath();
                g2d.draw(savePath);
            }
        }
    }
    
    /**
     * Returns all previously drawn doodles.
     * @return myDrawing List of all previously drawn doodles
     */
    public List<PaintStore> getMyDrawing() {
        return myDrawing;
    }

    /**
     * The list of previously drawn doodles is set.
     * @param aDrawing List of drawn doodles
     * @custom.post The list of previously drawn doodles is set
     */
    public void setMyDrawing(List<PaintStore> aDrawing) {
        this.myDrawing = aDrawing;
    }

    /**
     * Returns the current stroke width.
     * @return myStroke The current stroke width is returned
     */
    public BasicStroke getMyStroke() {
        return myStroke;
    }
    
    /**
     * The stroke width is set.
     * @param aStroke Stroke width of the doodle drawing
     * @custom.post The stroke width is set
     */
    public void setMyStroke(BasicStroke aStroke) {
        myStroke = aStroke;
    }
    
    /**
     * The current Red color value of form RGB is returned.
     * @return myR the current red color value
     */
    public int getMyR() {
        return myR;
    }
    
    /**
     * THe current red color value of RGB form is set.
     * @param aR == 0 or 255
     * @custom.post The red color value is set
     */
    public void setMyR(int aR) {
        if (aR == 0 || aR == 255) {
            this.myR = aR;
        }
    }
    
    /**
     * The current Green color value of form RGB is returned.
     * @return myG the current green color value
     */
    public int getMyG() {
        return myG;
    }
    
    /**
     * THe current green color value of RGB form is set.
     * @param aG == 0 or 255
     * @custom.post The green color value is set
     */
    public void setMyG(int aG) {
        if (aG == 0 || aG == 255) {
            this.myG = aG;
        }
    }
    
    /**
     * The current Blue color value of form RGB is returned.
     * @return myB the current blue color value
     */
    public int getMyB() {
        return myB;
    }
    
    /**
     * THe current blue color value of RGB form is set.
     * @param aB == 0 or 255
     * @custom.post The blue color value is set
     */
    public void setMyB(int aB) {
        if (aB == 0 || aB == 255) {
            this.myB = aB;
        }
    }
    
    /**
     * Private inner class that controls mouse movement as the user draws the doodle.
     * @custom.post The user's doodle is displayed on the panel
     */
    private class MouseDoodleAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent anEvent) {
            myStartPoint = anEvent.getPoint();
            myEndPoint = anEvent.getPoint();
        }
        
        @Override
        public void mouseDragged(MouseEvent anEvent) {
            myEndPoint = anEvent.getPoint();
            myPath.append(new Line2D.Double(myStartPoint, myEndPoint), true);
            myStartPoint.setLocation(myEndPoint);
            repaint();
        }
        
        @Override
        public void mouseReleased(MouseEvent anEvent) {
            final GeneralPath copyPath = new GeneralPath(myPath);
            final BasicStroke copyStroke = myStroke;
            final Color copyColor = new Color(myR, myG, myB);
            myDrawing.add(new PaintStore(copyPath, copyStroke, copyColor));
            myPath.reset();
        }
    }
    
    /**
     * Public inner class that changes the width of the stroke based on the user's
     * checkbox selection.
     * @custom.post The stroke width is changed.
     */
    public class StrokeItemAction extends AbstractAction {
        /**
         * The value of the new stroke width is passed to the constructor.
         * @param aStroke The new value of the stroke width.
         * @custom.post Tthe stroke width is changed
         */
        public StrokeItemAction(final BasicStroke aStroke) {
            putValue("stroke", aStroke);
        }
        
        @Override
        public void actionPerformed(ActionEvent anEvent) {
            final BasicStroke s = (BasicStroke) getValue("stroke");
            myStroke = s;
        }
    }
}
