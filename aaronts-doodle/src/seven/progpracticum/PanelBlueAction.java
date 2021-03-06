/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 * The <code>PanelBlueAction</code> class is an action outer class that sets the background
 * of the given panel to blue.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class PanelBlueAction extends AbstractAction {
    /**
     * The values and the panel to have its background color changed to blue
     * are constructed.
     * @param aPanel The panel to have its background changed to blue
     * @custom.post The background of the panel will be changed to blue
     */
    public PanelBlueAction(final PaintPanel aPanel) {
        putValue(Action.SMALL_ICON, new ImageIcon("blue-ball.gif"));
        putValue("panel", aPanel);
        putValue(Action.MNEMONIC_KEY, (int) 'B');
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        p.setBackground(Color.BLUE);
        putValue(Action.SELECTED_KEY, true);
    }
}

