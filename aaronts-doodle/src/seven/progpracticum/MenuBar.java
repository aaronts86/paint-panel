/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 * The <code>MenuBar</code> class holds the top-down menu bar for the DoodleGUI.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
    /**
     * Represents a File drop-down menu.
     */
    private JMenu myFileMenu;
    /**
     * Represents an Options drop-down menu.
     */
    private JMenu myOptionsMenu;
    /**
     * Represents a Help drop-down menu.
     */
    private JMenu myHelpMenu;
    
    /**
     * Represents a Line Width drop-down submenu.
     */
    private JMenu myLineWidthSubmenu;
    /**
     * Represents a Line Color drop-down submenu.
     */
    private JMenu myLineColorSubmenu;
    
    /**
     * Represents an Open menu item that opens a dialog box to open the doodle.
     */
    private JMenuItem myOpenMenuItem;
    /**
     * Represents a Save menu item that opens a dialog box to save the doodle.
     */
    private JMenuItem mySaveMenuItem;
    /**
     * Represents a Print menu item that prompts the user to print the doodle.
     */
    private JMenuItem myPrintMenuItem;
    /**
     * Represents an Exit menu item that closes the applications.
     */
    private JMenuItem myExitMenuItem;
    /**
     * Represents a Help menu item.
     */
    private JMenuItem myHelpMenuItem;
    /**
     * Represents an About menu item.
     */
    private JMenuItem myAboutMenuItem;
    
    /**
     * Represents a radio button in the line width submenu to choose a line width of 1.
     */
    private JRadioButtonMenuItem myRadio1;
    /**
     * Represents a radio button in the line width submenu to choose a line width of 3.
     */
    private JRadioButtonMenuItem myRadio3;
    /**
     * Represents a radio button in the line width submenu to choose a line width of 5.
     */
    private JRadioButtonMenuItem myRadio5;
    
    /**
     * Represents a buttongroup of radio buttons to choose the line width.
     */
    private ButtonGroup myLineWidthGroup;
    
    /**
     * Represents a checkbox menu item that stays open after the user selects it.
     * Determines the line color.
     */
    private StayOpenCheckBoxMenuItem myRedBox;
    /**
     * Represents a checkbox menu item that stays open after the user selects it.
     * Determines the line color.
     */
    private StayOpenCheckBoxMenuItem myGreenBox;
    /**
     * Represents a checkbox menu item that stays open after the user selects it.
     * Determines the line color.
     */
    private StayOpenCheckBoxMenuItem myBlueBox;
    
    /**
     * Paramaterized constructor for the menubar to define the panel, toolbar and actions
     * associated with the DoodleGUI in relation to the menubar.
     * 
     * @param aPanel must contain only letters, numbers and underscores
     * @param aToolBar must contain only letters, numbers and underscores
     * @param anA must contain only letters, numbers and underscores
     * 
     * @custom.post Menubar is added to DoodleGUI
     */
    public MenuBar(final PaintPanel aPanel, final ToolBar aToolBar, final Action[] anA) {
        super();
        myFileMenu = new JMenu("File");
        myOptionsMenu = new JMenu("Options");
        myHelpMenu = new JMenu("Help");
        
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        myHelpMenu.setMnemonic(KeyEvent.VK_H);

        myOpenMenuItem = new JMenuItem("Open");
        mySaveMenuItem = new JMenuItem("Save");
        myPrintMenuItem = new JMenuItem("Print");
        myExitMenuItem = new JMenuItem("Exit");
        
        mySaveMenuItem.setEnabled(false);
        myExitMenuItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        myExitMenuItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent anEvent) {
                    System.exit(0);
                }
            });
        
        myFileMenu.add(new AbstractAction("New")            
            {
                {
                    putValue("panel", aPanel);
                    putValue("toolbar", aToolBar);
                }
                
                @Override
                public void actionPerformed(ActionEvent anEvent) {
                    final PaintPanel p = (PaintPanel) getValue("panel");
                    final ToolBar t = (ToolBar) getValue("toolbar");
                    final List<PaintStore> clearList = new ArrayList<>();
                    p.setMyDrawing(clearList);
                    p.setMyR(0);
                    p.setMyG(0);
                    p.setMyB(0);
                    p.repaint();
                    t.getMyWhite().doClick();
                    myRadio1.doClick();
                    myRedBox.setSelected(false);
                    myGreenBox.setSelected(false);
                    myBlueBox.setSelected(false);
                }
            });
        myFileMenu.add(myOpenMenuItem);
        myFileMenu.add(mySaveMenuItem);
        myFileMenu.add(myPrintMenuItem);
        myFileMenu.addSeparator();
        myFileMenu.add(myExitMenuItem);
        add(myFileMenu);
        
        myLineWidthSubmenu = new JMenu("Line Width");
        myRadio1 = new JRadioButtonMenuItem(anA[0]);
        myRadio3 = new JRadioButtonMenuItem(anA[1]);
        myRadio5 = new JRadioButtonMenuItem(anA[2]);
        
        myRadio1.setText("Size: 1");
        myRadio1.setSelected(true);
        myRadio3.setText("Size: 3");
        myRadio5.setText("Size: 5");
        
        myLineWidthGroup = new ButtonGroup();
        myLineWidthGroup.add(myRadio1);
        myLineWidthGroup.add(myRadio3);
        myLineWidthGroup.add(myRadio5);
        myLineWidthSubmenu.add(myRadio1);
        myLineWidthSubmenu.add(myRadio3);
        myLineWidthSubmenu.add(myRadio5);
        
        myLineColorSubmenu = new JMenu("Line Color");
        myRedBox = new StayOpenCheckBoxMenuItem(anA[3]);
        myGreenBox = new StayOpenCheckBoxMenuItem(anA[4]);
        myBlueBox = new StayOpenCheckBoxMenuItem(anA[5]);
        
        myRedBox.setText("R");
        myGreenBox.setText("G");
        myBlueBox.setText("B");
        myLineColorSubmenu.add(myRedBox);
        myLineColorSubmenu.add(myGreenBox);
        myLineColorSubmenu.add(myBlueBox);
        
        myOptionsMenu.add(myLineWidthSubmenu);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(myLineColorSubmenu);
        add(myOptionsMenu);
        
        myHelpMenuItem = new JMenuItem("Help");
        myAboutMenuItem = new JMenuItem("About");
        
        myHelpMenu.add(myHelpMenuItem);
        myHelpMenu.add(myAboutMenuItem);
        add(myHelpMenu);
    }
}
