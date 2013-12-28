/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.JFrame;

/**
 * The <code>DoodleGUI</code> class builds the frame for the Doodle Form.
 * 
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
public class DoodleGUI {
    /** 
     * myFrame holds the value for the Doodle frame.
     */
    private final JFrame myFrame;
    /** 
     * myMenuBar holds the value for a top-down menubar.
     */
    private final MenuBar myMenuBar;
    /** 
     * myToolBar holds the value for the external toolbar.
     */
    private final ToolBar myToolBar;
    
    /** 
     * myPopupMenu holds the value for a popup menu whenever the user right-clicks.
     */
    private final PopupMenu myPopupMenu;
    
    /** 
     * myPanel holds the value for the panel that the user doodles on.
     */
    private final PaintPanel myPanel;

    /** 
     * myColorActions is an array of actions that change the background color of the panel.
     */
    private Action[] myColorActions;
    /** 
     * myStrokeActions is an array of actions that change the doodle drawing stroke.
     */
    private Action[] myStrokeActions;
    
    /**
     * Constructor that initializes the Doodle GUI.
     * @custom.post DoodleGUI is instantiated and displayed to the user.
     */
    public DoodleGUI() {
        myFrame = new JFrame("Aaron's Amazing Doodle Machine");
        myPanel = new PaintPanel();

        setupColorActions();
        setupStrokeActions();
        
        myToolBar = new ToolBar(myColorActions);
        myPopupMenu = new PopupMenu(myColorActions);
        myMenuBar = new MenuBar(myPanel, myToolBar, myStrokeActions);
        
        myPanel.setComponentPopupMenu(myPopupMenu);
        
        myFrame.setJMenuBar(myMenuBar);
        myFrame.add(myToolBar, BorderLayout.SOUTH);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("blue-ball.gif"));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
    
    /**
     * The action array that sets up the actions to change the background color of the
     * panel are initialized.
     * 
     * @custom.post Action array of background color changes are initiialized
     */
    private void setupColorActions() {
        myColorActions = new Action[4];
        myColorActions[0] = new PanelRedAction(myPanel);
        myColorActions[1] = new PanelBlueAction(myPanel);
        myColorActions[2] = new PanelYellowAction(myPanel);
        myColorActions[3] = new PanelWhiteAction(myPanel);
    }
    
    /**
     * The action array that sets up the actions to change the stroke color and width
     * are initialized.
     * 
     * @custom.post Action array of stroke color and width changes are initiialized
     */
    private void setupStrokeActions() {
        myStrokeActions = new Action[6];
        myStrokeActions[0] = myPanel.new StrokeItemAction(new BasicStroke(1));
        myStrokeActions[1] = myPanel.new StrokeItemAction(new BasicStroke(3));
        myStrokeActions[2] = myPanel.new StrokeItemAction(new BasicStroke(5));
        myStrokeActions[3] = new StrokeRedAction(myPanel);
        myStrokeActions[4] = new StrokeGreenAction(myPanel);
        myStrokeActions[5] = new StrokeBlueAction(myPanel);
    }
}
