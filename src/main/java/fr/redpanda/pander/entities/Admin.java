/**
 * 
 */
package fr.redpanda.pander.entities;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Admin extends User {

	/**
	 * The empty Constructor
	 */
	public Admin() {
		super();
		this.setRole(Role.ADMIN);
	}

}
