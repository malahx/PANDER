/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class DAOManager {


	private static String dbName = "pander";

	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	private static final String DB_HOST = "localhost";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private static Connection connection = null;
	
	/**
	 * 
	 * @return the active or created connection
	 */
	protected Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				try {
					Class.forName(DB_DRIVER).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				connection = DriverManager.getConnection(getUrl(), DB_USER, DB_PASS);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	/**
	 * 
	 * @param connection a connection to close
	 * @param prepares all prepare to close
	 * @param resultSet a result set to close
	 */
	protected void close(Connection connection, Statement[] prepares, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			for (Statement p : prepares) {
				if (p != null) {
					p.close();
				}
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param connection a connection to close
	 * @param prepares a prepare to close
	 * @param resultSet a result set to close
	 */
	protected void close(Connection connection, Statement prepare, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		close(connection, prepare);
	}
	
	/**
	 * 
	 * @param connection a connection to close
	 * @param prepares a prepare to close
	 */
	protected void close(Connection connection, Statement prepare) {
		try {
			if (prepare != null) {
				prepare.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return the dbName
	 */
	public static String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	public static void setDbName(String dbName) {
		DAOManager.dbName = dbName;
	}
	
	/**
	 * 
	 * @return the url
	 */
	private static String getUrl() {
		return "jdbc:mysql://" + DB_HOST + "/" + dbName + "?noAccessToProcedureBodies=true";
	}

}
