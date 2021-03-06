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
 * The <code>PanelYellowAction</code> class is an action outer class that sets the background
 * of the given panel to yellow.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class PanelYellowAction extends AbstractAction {
    /**
     * The values and the panel to have its background color changed to yellow
     * are constructed.
     * @param aPanel The panel to have its background changed to yellow
     * @custom.post The background of the panel will be changed to yellow
     */
    public PanelYellowAction(final PaintPanel aPanel) {
        putValue(Action.SMALL_ICON, new ImageIcon("yellow-ball.gif"));
        putValue("panel", aPanel);
        putValue(Action.MNEMONIC_KEY, (int) 'Y');
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        p.setBackground(Color.YELLOW);
        putValue(Action.SELECTED_KEY, true);
    }
}
