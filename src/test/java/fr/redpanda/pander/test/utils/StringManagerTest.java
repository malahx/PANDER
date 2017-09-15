/**
 * 
 */
package fr.redpanda.pander.test.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class StringManagerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#firstLetterUpperCase(java.lang.String)}.
	 */
	@Test
	public void testFirstLetterUpperCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#splitWords(java.lang.String)}.
	 */
	@Test
	public void testSplitWords() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toTitle(java.lang.String)}.
	 */
	@Test
	public void testToTitle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#getRoleFrom(java.lang.String)}.
	 */
	@Test
	public void testGetRoleFrom() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#getTypeSkillFrom(java.lang.String)}.
	 */
	@Test
	public void testGetTypeSkillFrom() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#createString()}.
	 */
	@Test
	public void testCreateString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#isEmail(java.lang.String)}.
	 */
	@Test
	public void testIsEmail() {
		assertFalse(StringManager.isEmail("a@a.a"));
		assertFalse(StringManager.isEmail("aaa"));
		assertFalse(StringManager.isEmail("a.a"));
		assertTrue(StringManager.isEmail("aa@aa.aa"));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQL(java.lang.String, boolean)}.
	 */
	@Test
	public void testToMySQLStringBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQL(fr.redpanda.pander.entities.Role, boolean)}.
	 */
	@Test
	public void testToMySQLRoleBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQL(boolean, boolean)}.
	 */
	@Test
	public void testToMySQLBooleanBooleanTrue() {
		String result = "'1',";
		assertTrue(StringManager.toMySQL(true, false).equals(result));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQL(boolean, boolean)}.
	 */
	@Test
	public void testToMySQLBooleanBooleanFalse() {
		String result = "'0',";
		assertTrue(StringManager.toMySQL(false, false).equals(result));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQL(boolean, boolean)}.
	 */
	@Test
	public void testToMySQLBooleanBooleanLast() {
		String result = "'1'";
		assertTrue(StringManager.toMySQL(true, true).equals(result));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQLUpdate(java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public void testToMySQLUpdateStringStringBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQLUpdate(java.lang.String, fr.redpanda.pander.entities.Role, boolean)}.
	 */
	@Test
	public void testToMySQLUpdateStringRoleBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#toMySQLUpdate(java.lang.String, boolean, boolean)}.
	 */
	@Test
	public void testToMySQLUpdateStringBooleanBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.utils.StringManager#last(java.lang.String, boolean)}.
	 */
	@Test
	public void testLast() {
		String test = "test";
		assertTrue(StringManager.last(test, true).equals(test));
		assertTrue(StringManager.last(test, false).equals(test + ','));
	}

}
