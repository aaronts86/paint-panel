/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

/**
 * The <code>StrokeBlueAction</code> class is an action outer class that sets the stroke color
 * to the blue hue in RGB form.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
@SuppressWarnings("serial")
public class StrokeBlueAction extends AbstractAction {
    /**
     * The values and the panel to have its stroke color changed to blue
     * are constructed.
     * @param aPanel The panel to have its stroke color changed to blue
     * @custom.post The stroke color of the panel will be changed to blue
     */
    public StrokeBlueAction(final PaintPanel aPanel) {
        putValue("panel", aPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent anEvent) {
        final PaintPanel p = (PaintPanel) getValue("panel");
        
        final AbstractButton blueBox = (AbstractButton) anEvent.getSource();
        final boolean selected = blueBox.getModel().isSelected();
        
        if (selected) {
            p.setMyB(255);
        } else {
            p.setMyB(0);
        }
    }
}
