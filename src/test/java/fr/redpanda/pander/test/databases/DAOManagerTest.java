/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.redpanda.pander.databases.DAOManager;
import fr.redpanda.pander.test.databases.base.BaseMysql;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class DAOManagerTest extends BaseMysql {

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

	private void dbDelete(String dbName) {
		Connection connectionCreate = DAOManager.getInstance().getCreateConnection();
		Statement statement;
		try {
			statement = connectionCreate.createStatement();
			statement.execute("DROP DATABASE IF EXISTS " + dbName);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#getInstance()}.
//	 */
//	@Test
//	public void testGetInstance() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 */
	@Test
	public void testGetCreateConnectionNotNull() {
		assertNotNull(DAOManager.getInstance().getCreateConnection());
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

		assertEquals(connectionCreate.getMetaData().getURL(), createConnection.getMetaData().getURL());

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
		@SuppressWarnings("unused")
		Connection createConnection = null;

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		createConnection = DriverManager.getConnection(connectionCreate.getMetaData().getURL(), "jean-louison",
				"patator");

		fail();

	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.DAOManager#getCreateConnection()}.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetCreateConnectionRequest() {

		Connection connectionCreate = DAOManager.getInstance().getCreateConnection();
		boolean result = false;
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
			ResultSet rs = statement.executeQuery("SHOW DATABASES");

			while (rs.next()) {
				if (rs.getString(1).equals(dbName)) {
					result = true;
				}
			}

			assertTrue(result);

			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Database not found");
		} finally {
			dbDelete(dbName);
		}

	}

//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#getConnection()}.
//	 */
//	@Test
//	public void testGetConnection() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.DAOManager#getdbName()}.
//	 */
//	@Test
//	public void testGetdbName() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.DAOManager#connect()}.
//	 */
//	@Test
//	public void testConnect() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#connect(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testConnectStringString() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#connect(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testConnectStringStringStringStringString() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea()}.
//	 */
//	@Test
//	public void testConnectCrea() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testConnectCreaStringString() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.DAOManager#connectCrea(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testConnectCreaStringStringStringString() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.DAO#close(java.sql.Statement, java.sql.ResultSet)}.
//	 */
//	@Test
//	public void testCloseStatementResultSet() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.DAO#close(java.sql.Statement)}.
//	 */
//	@Test
//	public void testCloseStatement() {
//		fail("Not yet implemented");
//	}

}
