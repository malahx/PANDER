/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAO implements IDAOBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#executeRequest(java.lang.String)
	 */
	@Override
	public ResultSet executeRequest(String request) {

		ResultSet resultSet = null;

		try {
			Statement statement = DBManager.getInstance().getConnection().createStatement();
			resultSet = statement.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;

	}

}
