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
 * The <code>PanelRedAction</code> class is an action outer class that sets the background
 * of the given panel to red.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class PanelRedAction extends AbstractAction {
    /**
     * The values and the panel to have its background color changed to red
     * are constructed.
     * @param aPanel The panel to have its background changed to red
     * @custom.post The background of the panel will be changed to red
     */
    public PanelRedAction(final PaintPanel aPanel) {
        putValue(Action.SMALL_ICON, new ImageIcon("red-ball.gif"));
        putValue("panel", aPanel);
        putValue(Action.MNEMONIC_KEY, (int) 'R');
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        p.setBackground(Color.RED);
        putValue(Action.SELECTED_KEY, true);
    }
}
