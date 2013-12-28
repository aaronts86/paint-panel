/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.GeneralPath;

/**
 * The <code>PaintStore</code> class holds doodle's path, stroke width and stroke color
 * everytime a line is drawn.
 *
 * @author Aaron Schraufnagel
 * @custom.inv myStroke == 1, 3, or 5
 */
public final class PaintStore {
    /**
     * The path of the doodle's line from start to finish.
     */
    private GeneralPath myPath;
    /**
     * The stroke with of the doodle's line.
     */
    private BasicStroke myStroke;
    /**
     * The color of the doodle's line.
     */
    private Color myColor;
    
    /**
     * The parameterized constructor of the PaintStore class constructs an object of
     * PaintStore type with the given parameters.
     * @param aPath The path of the line doodle from start to finish
     * @param aStroke == 1, 3, or 5
     * @param aColor The color of the line doodle
     * @custom.post A PaintStore object is constructed with the given parameters
     */
    public PaintStore(final GeneralPath aPath, final BasicStroke aStroke,
                      final Color aColor) {
        myPath = aPath;
        myStroke = aStroke;
        myColor = aColor;
    }

    /**
     * The line doodle's path is returned.
     * @return myPath The path of the line doodle from start to finish
     */
    public GeneralPath getMyPath() {
        return myPath;
    }

    /**
     * The width of the line doodle's stroke is returned.
     * @return myStroke The width of the line doodle
     */
    public BasicStroke getMyStroke() {
        return myStroke;
    }

    /**
     * The line doodle's color is returned.
     * @return myColor The color of the line doodle
     */
    public Color getMyColor() {
        return myColor;
    }
}
