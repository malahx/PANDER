/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.test.databases.base.BaseDAOTest;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CompanyDAOTest extends BaseDAOTest {

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.CompanyDAO#checkUniqueFields(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testCheckUniqueFields() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.CompanyDAO#delete(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testDeleteBaseEntity() {
//		fail("Not yet implemented");
//	}

	/**
	 * {@link fr.redpanda.pander.databases.CompanyDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceEquals() {
		assertEquals(CompanyDAO.getInstance(), CompanyDAO.getInstance());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CompanyDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull(CompanyDAO.getInstance());
	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.CompanyDAO#isExists(java.lang.String)}.
//	 */
//	@Test
//	public void testIsExists() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.CompanyDAO#parse(java.sql.ResultSet)}.
//	 */
//	@Test
//	public void testParseResultSet() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CompanyDAO#parse(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseBaseEntity() {
		String result = "0,'" + company.getName() + "','" + company.getSiret() + "','',''";
		assertEquals(CompanyDAO.getInstance().parse(company), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CompanyDAO#parseUpdate(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseUpdate() {
		String result = "name = '" + company.getName() + "',siret = '" + company.getSiret()
				+ "',contact = '',link = ''";
		assertEquals(CompanyDAO.getInstance().parseUpdate(company), result);
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.CompanyDAO#fields()}.
	 */
	@Test
	public void testFields() {
		String result = "id_kuser,name,siret,contact";
		assertEquals(CompanyDAO.getInstance().fields(), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CompanyDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckFieldsTrue() {
		assertTrue(CompanyDAO.getInstance().checkFields(company));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CompanyDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckFieldsFalse() {
		assertFalse(CompanyDAO.getInstance().checkFields(new Company()));
	}

}
