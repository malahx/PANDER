/**
 * 
 */
package fr.redpanda.pander.databases.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAO extends DAO implements IBaseDAO {

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
		super();
		this.table = table;
		this.id = id;
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
		ResultSet rs = executeQuery("SELECT " + id + " FROM " + table + " WHERE " + id + " = " + entity.getId());
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
			executePrepare(entity, "INSERT INTO " + table + " (" + fields() + ") VALUES (" + parse(entity) + ")");
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
		Integer i = null;
		if (checkExists(entity) && checkFields(entity)) {
			i = execute("UPDATE " + table + " SET " + parseUpdate(entity) + " WHERE " + id + " = " + entity.getId());
		}
		return i;
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
		execute("DELETE FROM " + JobDAO.TABLE_SKILL + " WHERE " + JobDAO.ID_SKILL + " = " + entity.getId());
		execute("DELETE FROM " + CandidateDAO.TABLE_SKILL + " WHERE " + CandidateDAO.ID_SKILL + " = " + entity.getId());
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
		ResultSet rs = executeQuery("SELECT * FROM " + table + " WHERE " + getId() + " = " + id);
		BaseEntity entity = null;
		try {
			if (rs.next()) {
				entity = parse(rs);
			}
			rs.close();
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
		ResultSet rs = executeQuery("SELECT * FROM " + table);
		try {
			while (rs.next()) {
				entities.add(parse(rs));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

}
