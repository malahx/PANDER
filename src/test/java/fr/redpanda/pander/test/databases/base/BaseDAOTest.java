/**
 * 
 */
package fr.redpanda.pander.test.databases.base;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAOTest extends BaseMysql {
	
	protected BaseEntity entity;

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
	 */
	@Before
	public void setUp() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#getTable()}.
	 */
	@Test
	public void testGetTable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#getId()}.
	 */
	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#BaseDAO(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testBaseDAO() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#executeQuery(java.lang.String)}.
	 */
	@Test
	public void testExecuteQuery() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#executePrepare(fr.redpanda.pander.entities.base.BaseEntity, java.lang.String)}.
	 */
	@Test
	public void testExecutePrepare() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#execute(java.lang.String)}.
	 */
	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#checkUniqueFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckUniqueFields() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#checkExists(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckExists() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#insert(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#update(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#delete(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testDeleteBaseEntity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#delete()}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.BaseDAO#get(double)}.
	 */
	@Test
	public void testGetDouble() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#get()}.
	 */
	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}
