/**
 * 
 */
package fr.redpanda.pander.database.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.database.DBManager;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAO implements IDAOBase {
	
	/** the table to use */
	protected String table;

	/** the id to use */
	protected String id;

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
	public ResultSet query(String request) {

		ResultSet rs = null;

		try {
			Statement statement = DBManager.getInstance().getConnection().createStatement();
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
	public BaseEntity prepare(BaseEntity entity, String request) {

		try {
			PreparedStatement prepare = DBManager.getInstance().getConnection().prepareStatement(request,
					Statement.RETURN_GENERATED_KEYS);
			prepare.executeUpdate();
			ResultSet generatedKeys = prepare.getGeneratedKeys();
			if (generatedKeys.next()) {
				entity.setId(generatedKeys.getDouble(1));
			}
			generatedKeys.close();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
			Statement statement = DBManager.getInstance().getConnection().createStatement();
			result = statement.executeUpdate(request);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkUniqueFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkUniqueFields(BaseEntity entity) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkFields(fr.redpanda.pander.entities.
	 * base.checkExists)
	 */
	@Override
	public boolean checkExists(BaseEntity entity) {
		if (entity == null || entity.getId() <= 0) {
			return false;
		}
		ResultSet rs = query("SELECT " + id + " FROM " + table + " WHERE " + id + " = " + entity.getId());
		try {
			if (rs.next()) {
				entity.setId(rs.getDouble(1));
			} else {
				entity = null;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			entity = null;
		}
		return entity != null && entity.getId() >= 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#insert(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public BaseEntity insert(BaseEntity entity) {
		if (!checkExists(entity) && checkFields(entity) && !checkUniqueFields(entity)) {
			prepare(entity, "INSERT INTO " + table + " (" + fields() + ") VALUES (" + parse(entity) + ")");
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#update(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int update(BaseEntity entity) {
		if (checkExists(entity) && checkFields(entity)) {
			return execute("UPDATE " + table + " SET " + parseUpdate(entity) + " WHERE " + id + " = " + entity.getId());
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#delete(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		return execute("DELETE FROM " + table + " WHERE " + id + " = " + entity.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#delete()
	 */
	@Override
	public int delete() {
		return execute("DELETE FROM " + table);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		ResultSet rs = query("SELECT * FROM " + table + " WHERE " + getId() + " = " + id);
		BaseEntity entity = null;
		try {
			if (rs.next()) {
				entity = parse(rs);
			}
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
		ResultSet rs = query("SELECT * FROM " + table);
		try {
			while (rs.next()) {
				entities.add(parse(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

}
