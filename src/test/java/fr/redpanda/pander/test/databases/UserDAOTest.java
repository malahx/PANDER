/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.test.databases.base.BaseDAOTest;

/**
 * @author Gwénolé LE HENAFF
 */
public class UserDAOTest extends BaseDAOTest {

	private void deleteAdmin() {
		execute("DELETE FROM " + UserDAO.TABLE + " WHERE " + UserDAO.EMAIL + " = '" + admin.getEmail() + "'");
	}

	private void insertAdmin() {
		deleteAdmin();
		execute("INSERT INTO " + UserDAO.TABLE + " (" + UserDAO.getInstance().fields() + ") VALUES ("
				+ UserDAO.getInstance().parse(admin) + ")");
	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.UserDAO#checkUniqueFields(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testCheckUniqueFields() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.UserDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceEquals() {
		assertEquals(UserDAO.getInstance(), UserDAO.getInstance());
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.UserDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull(UserDAO.getInstance());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#get(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetStringStringExists() {
		insertAdmin();
		assertNotNull(UserDAO.getInstance().get(admin.getEmail(), admin.getPassword()));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#get(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetStringStringNotExists() {
		deleteAdmin();
		assertNull(UserDAO.getInstance().get(admin.getEmail(), admin.getPassword()));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#isExists(java.lang.String)}.
	 */
	@Test
	public void testIsExistsFalse() {
		deleteAdmin();
		assertFalse(UserDAO.getInstance().isExists(admin.getEmail()));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#isExists(java.lang.String)}.
	 */
	@Test
	public void testIsExistsTrue() {
		insertAdmin();
		assertTrue(UserDAO.getInstance().isExists(admin.getEmail()));
	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.UserDAO#parse(fr.redpanda.pander.entities.base.BaseEntity, java.sql.ResultSet)}.
//	 */
//	@Test
//	public void testParseBaseEntityResultSet() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.UserDAO#get(fr.redpanda.pander.entities.base.BaseEntity, double)}.
//	 */
//	@Test
//	public void testGetBaseEntityDouble() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.UserDAO#parse(java.sql.ResultSet)}.
//	 */
//	@Test
//	public void testParseResultSet() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#parse(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseBaseEntity() {
		String result = "'" + admin.getEmail() + "','" + admin.getPassword() + "','" + admin.getRole().toString()
				+ "','0','','','','','','',NULL,NULL";
		assertEquals(UserDAO.getInstance().parse(admin), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.UserDAO#parseUpdate(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseUpdate() {
		String result = "email = '" + admin.getEmail() + "',password = '" + admin.getPassword() + "',role = '"
				+ admin.getRole().toString()
				+ "',disabled = '0',phone = '',address = '',postcode = '',city = '',photo = '',description = '',created_at = NULL,updated_at = NULL";
		assertEquals(UserDAO.getInstance().parseUpdate(admin), result);
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.UserDAO#fields()}.
	 */
	@Test
	public void testFields() {
		String result = "email,password,role,disabled,phone,address,postcode,city,photo,description,created_at,updated_at";
		assertEquals(UserDAO.getInstance().fields(), result);
	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.UserDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testCheckFields() {
//		fail("Not yet implemented");
//	}

}
