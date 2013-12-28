/**
 * Aaron Schraufnagel
 */
package seven.progpracticum;

import java.awt.EventQueue;

/**
 * The <code>DoodleMain</code> class holds the main method to run the DoodleGUI.
 *
 * @author Aaron Schraufnagel
 * @custom.inv None
 */
public final class DoodleMain {
    /**
     * Private constructor that inhibits the <code>DoodleMain</code> class from being
     * instantiated.
     */
    private DoodleMain() {
        throw new IllegalStateException("DoodleMain class cannot be instantiated");
    }

    /**
     * @param aRgs the arguments for the main method of array type String
     * @custom.post DoodleGUI is initialized and run
     */
    public static void main(String[] aRgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoodleGUI();
            }
        });
    }
}
