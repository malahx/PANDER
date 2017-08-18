/**
 * 
 */
package fr.redpanda.pander;

import javax.swing.JFrame;

import fr.redpanda.pander.controllers.AuthCtrl;
import fr.redpanda.pander.controllers.MainCtrl;
import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		ViewUtils.configure(frame);
		new AuthCtrl(frame);

	}

}
