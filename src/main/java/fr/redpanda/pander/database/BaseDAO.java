/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAO implements IDAOBase {

	/** the table to use */
	private String table;

	/** the id to use */
	private String id;

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * The constructor
	 * 
	 * @param table
	 *            the table to use
	 * @param id
	 *            the id field to use
	 */
	protected BaseDAO(String table, String id) {
		this.table = table;
		this.id = id;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#execute(java.lang.String)
	 */
	@Override
	public double execute(String request) {
		
		double id = 0;
		try {
			PreparedStatement prepare = DBManager.getInstance().getConnection().prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			prepare.execute();
			ResultSet generatedKeys = prepare.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getDouble(1);
			}

			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#insert(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public void insert(BaseEntity item) {
		execute("INSERT INTO " + table + " " + fields() + " VALUES " + parse(item));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#update(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public void update(BaseEntity item) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#delete(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public void delete(BaseEntity item) {
		execute("DELETE FROM " + table + " WHERE " + id + " = " + item.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#delete()
	 */
	@Override
	public void delete() {
		execute("DELETE FROM " + table);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		ResultSet resultSet = executeRequest("SELECT * FROM " + table + " WHERE " + getId() + " = " + id);
		BaseEntity entity = null;
		try {
			resultSet.next();
			entity = parse(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#get()
	 */
	@Override
	public List<BaseEntity> get() {
		List<BaseEntity> entities = new ArrayList<>();
		ResultSet resultSet = executeRequest("SELECT * FROM " + table);
		try {
			while (resultSet.next()) {
				entities.add(parse(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

}
