/**
 * 
 */
package fr.redpanda.pander.databases.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class DAO {

	protected void close(Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		close(statement);
	}

	protected void close(Statement statement) {
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
