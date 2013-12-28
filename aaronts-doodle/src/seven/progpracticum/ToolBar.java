/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The <code>ToolBar</code> class contains a toolbar of toggle buttons that allows them
 * to change the color of the background.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
    /**
     * Represents a toggle button to change the background color to red.
     */
    private JToggleButton myRed;
    /**
     * Represents a toggle button to change the background color to blue.
     */
    private JToggleButton myBlue;
    /**
     * Represents a toggle button to change the background color to yellow.
     */
    private JToggleButton myYellow;
    /**
     * Represents a toggle button to change the background color to white.
     */
    private JToggleButton myWhite;
    /**
     * Represents a button group for the toggle buttons that set the background color.
     */
    private ButtonGroup myToggleGroup;
    
    /**
     * Parameterized constructor that passes the action array to set
     * the background color.
     * @param anA Action array to change the background color
     * @custom.post The background color is set to the color chosen
     */
    public ToolBar(final Action[] anA) {
        super("Colors");
        
        myRed = new JToggleButton(anA[0]);
        myBlue = new JToggleButton(anA[1]);
        myYellow = new JToggleButton(anA[2]);
        myWhite = new JToggleButton(anA[3]);
        
        myRed.setToolTipText("Red");
        myBlue.setToolTipText("Blue");
        myYellow.setToolTipText("Yellow");
        myWhite.setToolTipText("White");
        
        myToggleGroup = new ButtonGroup();
        myToggleGroup.add(myRed);
        myToggleGroup.add(myBlue);
        myToggleGroup.add(myYellow);
        myToggleGroup.add(myWhite);
        
        add(myRed);
        add(myBlue);
        add(myYellow);
        add(myWhite);
    }

    /**
     * The toggle button that sets the background color of the panel to red and its
     * attributes is returned.
     * @return myRed The toggle button that sets the background color to red.
     */
    public JToggleButton getMyRed() {
        return myRed;
    }

    /**
     * The toggle button to set the background color of the panel to red is set.
     * @param aRed The toggle button that sets the background color to red
     * @custom.post The toggle button that sets the background color of the panel to red is
     * set.
     */
    public void setMyRed(JToggleButton aRed) {
        this.myRed = aRed;
    }

    /**
     * The toggle button that sets the background color of the panel to blue and its
     * attributes is returned.
     * @return myBlue The toggle button that sets the background color to blue.
     */
    public JToggleButton getMyBlue() {
        return myBlue;
    }

    /**
     * The toggle button to set the background color of the panel to blue is set.
     * @param aBlue The toggle button that sets the background color to blue
     * @custom.post The toggle button that sets the background color of the panel to blue is
     * set
     */
    public void setMyBlue(JToggleButton aBlue) {
        this.myBlue = aBlue;
    }

    /**
     * The toggle button that sets the background color of the panel to yellow and its
     * attributes is returned.
     * @return myYellow The toggle button that sets the background color to yellow.
     */
    public JToggleButton getMyYellow() {
        return myYellow;
    }

    /**
     * The toggle button to set the background color of the panel to yellow is set.
     * @param aYellow The toggle button that sets the background color to yellow
     * @custom.post The toggle button that sets the background color of the panel to yellow is
     * set.
     */
    public void setMyYellow(JToggleButton aYellow) {
        this.myYellow = aYellow;
    }

    /**
     * The toggle button that sets the background color of the panel to white and its
     * attributes is returned.
     * @return myWhite The toggle button that sets the background color to white.
     */
    public JToggleButton getMyWhite() {
        return myWhite;
    }

    /**
     * The toggle button to set the background color of the panel to white is set.
     * @param aWhite The toggle button that sets the background color to white
     * @custom.post The toggle button that sets the background color of the panel to white is
     * set.
     */
    public void setMyWhite(JToggleButton aWhite) {
        this.myWhite = aWhite;
    }
    
}
