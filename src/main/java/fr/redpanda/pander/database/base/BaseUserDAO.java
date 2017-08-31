/**
 * 
 */
package fr.redpanda.pander.database.base;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseUserDAO extends BaseDAO {

	/**
	 * The constructor
	 * 
	 * @param table
	 *            the table to use
	 * @param id
	 *            the id to use
	 */
	public BaseUserDAO(String table, String id) {
		super(table, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.BaseDAO#insert(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public BaseEntity insert(BaseEntity entity) {
		UserDAO.getInstance().insert(entity);
		return super.insert(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.BaseDAO#update(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int update(BaseEntity entity) {
		UserDAO.getInstance().update(entity);
		return super.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.BaseDAO#delete(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		int n = super.delete(entity);
		UserDAO.getInstance().delete(entity);
		return n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.BaseDAO#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		return UserDAO.getInstance().get(super.get(id), id);
	}

}
