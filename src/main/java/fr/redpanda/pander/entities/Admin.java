/**
 * 
 */
package fr.redpanda.pander.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Admin extends User {

	/**
	 * 
	 */
	public Admin() {
		super();
	}

	/**
	 * 
	 * @param email
	 */
	public Admin(String email) {
		super(email);
		this.setRole(Role.ADMIN);
	}

	/**
	 * @param result
	 * @throws SQLException
	 */
	public Admin(ResultSet result) throws SQLException {
		super(result);
		this.setRole(Role.ADMIN);
	}

}
