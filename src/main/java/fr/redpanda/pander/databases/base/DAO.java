/**
 * 
 */
package fr.redpanda.pander.databases.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.redpanda.pander.databases.DAOManager;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class DAO implements IDAO {

	/**
	 * Close a statement and a resultSet
	 * 
	 * @param statement
	 * @param resultSet
	 */
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

	/**
	 * Close a statement
	 * 
	 * @param statement
	 */
	protected void close(Statement statement) {
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#executeRequest(java.lang.String)
	 */
	@Override
	public ResultSet executeQuery(String request) {
		ResultSet rs = null;
		try {
			Statement statement = DAOManager.getInstance().getConnection().createStatement();
			rs = statement.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#execute(java.lang.String)
	 */
	@Override
	public BaseEntity executePrepare(BaseEntity entity, String request) {
		PreparedStatement prepare = null;
		ResultSet generatedKeys = null;
		try {
			prepare = DAOManager.getInstance().getConnection().prepareStatement(request,
					Statement.RETURN_GENERATED_KEYS);
			prepare.executeUpdate();
			generatedKeys = prepare.getGeneratedKeys();
			if (generatedKeys.next()) {
				entity.setId(generatedKeys.getDouble(1));
			}
			generatedKeys.close();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
			close(prepare, generatedKeys);
		}
		return entity;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#execute(java.lang.String)
	 */
	@Override
	public int execute(String request) {

		int result = 0;
		try {
			Statement statement = DAOManager.getInstance().getConnection().createStatement();
			result = statement.executeUpdate(request);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

}
