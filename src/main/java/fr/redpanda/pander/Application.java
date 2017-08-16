/**
 * 
 */
package fr.redpanda.pander;

import fr.redpanda.pander.controller.AuthCtrl;
import fr.redpanda.pander.controller.MainCtrl;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainCtrl.setMainCtrl(new AuthCtrl());

	}

}
