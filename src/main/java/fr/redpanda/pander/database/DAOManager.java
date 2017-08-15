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

	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	private static final String DB_HOST = "localhost";
	private static final String DB_NAME = "pander";
	private static final String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME + "?noAccessToProcedureBodies=true";
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
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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

}
