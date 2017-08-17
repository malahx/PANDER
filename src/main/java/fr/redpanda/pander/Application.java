/**
 * 
 */
package fr.redpanda.pander;

import fr.redpanda.pander.controllers.AuthCtrl;
import fr.redpanda.pander.controllers.MainCtrl;

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
