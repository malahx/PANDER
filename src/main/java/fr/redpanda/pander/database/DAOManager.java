/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
}
