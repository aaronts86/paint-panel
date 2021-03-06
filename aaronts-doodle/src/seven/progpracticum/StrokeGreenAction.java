/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

/**
 * The <code>StrokeGreenAction</code> class is an action outer class that sets the stroke color
 * to the green hue in RGB form.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class StrokeGreenAction extends AbstractAction {
    /**
     * The values and the panel to have its stroke color changed to green
     * are constructed.
     * @param aPanel The panel to have its stroke color changed to green
     * @custom.post The stroke color of the panel will be changed to green
     */
    public StrokeGreenAction(final PaintPanel aPanel) {
        putValue("panel", aPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        
        final AbstractButton greenBox = (AbstractButton) anEvent.getSource();
        final boolean selected = greenBox.getModel().isSelected();
        
        if (selected) {
            p.setMyG(255);
        } else {
            p.setMyG(0);
        }
    }

}
