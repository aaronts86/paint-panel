/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * The <code>PopUpMenu</code> class contains the menu items that pop up to the user
 * anytime they right click and allows them to change the color of the background.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class PopupMenu extends JPopupMenu {
    /**
     * Represents a menu item to change the background color to red.
     */
    private JMenuItem myRed;
    /**
     * Represents a menu item to change the background color to blue.
     */
    private JMenuItem myBlue;
    /**
     * Represents a menu item to change the background color to yellow.
     */
    private JMenuItem myYellow;
    /**
     * Represents a menu item to change the background color to white.
     */
    private JMenuItem myWhite;

    /**
     * Parameterized constructor that passes the action array to set
     * the background color.
     * @param anA Action array to change the background color
     * @custom.post The background color is set to the color chosen
     */
    public PopupMenu(final Action[] anA) {
        myRed = new JMenuItem(anA[0]);
        myBlue = new JMenuItem(anA[1]);
        myYellow = new JMenuItem(anA[2]);
        myWhite = new JMenuItem(anA[3]);
        
        myRed.setText("red");
        myBlue.setText("blue");
        myYellow.setText("yellow");
        myWhite.setText("white");
        
        myRed.setToolTipText("red");
        myBlue.setToolTipText("blue");
        myYellow.setToolTipText("yellow");
        myWhite.setToolTipText("white");
        
        add(myRed);
        add(myBlue);
        add(myYellow);
        add(myWhite);
    }
}
