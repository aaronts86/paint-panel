/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

/**
 * The <code>StrokeRedAction</code> class is an action outer class that sets the stroke color
 * to the red hue in RGB form.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class StrokeRedAction extends AbstractAction {
    /**
     * The values and the panel to have its stroke color changed to red
     * are constructed.
     * @param aPanel The panel to have its stroke color changed to red
     * @custom.post The stroke color of the panel will be changed to red
     */
    public StrokeRedAction(final PaintPanel aPanel) {
        putValue("panel", aPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        
        final AbstractButton redBox = (AbstractButton) anEvent.getSource();
        final boolean selected = redBox.getModel().isSelected();
        
        if (selected) {
            p.setMyR(255);
        } else {
            p.setMyR(0);
        }
    }

}
