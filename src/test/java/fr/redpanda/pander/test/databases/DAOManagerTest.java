/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.SystemUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.redpanda.pander.databases.DAOManager;
import fr.redpanda.pander.utils.ProcessManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class DAOManagerTest {

	private static ProcessManager process;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (SystemUtils.IS_OS_LINUX) {
			process = new ProcessManager(ProcessManager.START_MYSQL);
		} else {
			process = new ProcessManager(ProcessManager.WAMP);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (SystemUtils.IS_OS_LINUX) {
			process.close(ProcessManager.STOP_MYSQL);
		} else {
			process.close();
		}
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
	 * {@link fr.redpanda.pander.databases.DAOManager#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 */
	@Test
	public void testGetCreateConnectionNotNull() {
		assertNotNull("getCreateConnection is null", DAOManager.getInstance().getCreateConnection());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	@Test
	public void testGetCreateConnectionValid()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection connectionCreate = DAOManager.getInstance().getCreateConnection();
		Connection createConnection = null;

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		createConnection = DriverManager.getConnection(connectionCreate.getMetaData().getURL(), "root", "");

		assertEquals(connectionCreate, createConnection);

	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void testGetCreateConnectionNotValid()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection connectionCreate = DAOManager.getInstance().getCreateConnection();
		Connection createConnection = null;

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		createConnection = DriverManager.getConnection(connectionCreate.getMetaData().getURL(), "jean-louison", "patator");

		assertNotEquals(connectionCreate, createConnection);

	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 * @throws SQLException 
	 */
	@Test
	public void testGetCreateConnectionRequest() throws SQLException {

		Connection connectionCreate = DAOManager.getInstance().getCreateConnection();

		String dbName = "panderTest";
		Statement statement;
		try {
			statement = connectionCreate.createStatement();
			statement.execute("CREATE DATABASE IF NOT EXISTS " + dbName + ";");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = connectionCreate.createStatement();
			statement.execute("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getConnection()}.
	 */
	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.DAOManager#getdbName()}.
	 */
	@Test
	public void testGetdbName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.DAOManager#connect()}.
	 */
	@Test
	public void testConnect() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#connect(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConnectStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#connect(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConnectStringStringStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea()}.
	 */
	@Test
	public void testConnectCrea() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConnectCreaStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConnectCreaStringStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.DAO#close(java.sql.Statement, java.sql.ResultSet)}.
	 */
	@Test
	public void testCloseStatementResultSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.base.DAO#close(java.sql.Statement)}.
	 */
	@Test
	public void testCloseStatement() {
		fail("Not yet implemented");
	}

}
