/**
 * 
 */
package fr.redpanda.pander;

import fr.redpanda.pander.managers.ViewsManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ViewsManager.getInstance().start();

	}

}
