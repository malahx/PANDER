/**
 * 
 */
package fr.redpanda.pander.databases.base;

import java.sql.ResultSet;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IDAO {

	/**
	 * Execute a SQL request
	 * 
	 * @param request
	 *            the SQL request
	 * @return the result of the request
	 */
	public ResultSet executeQuery(String request);

	/**
	 * Prepare a SQL request
	 * 
	 * @param entity
	 *            the {@link BaseEntity} to prepare
	 * @param request
	 *            the SQL request
	 * @return the {@link BaseEntity}
	 */
	public BaseEntity executePrepare(BaseEntity entity, String request);

	/**
	 * Execute a SQL request without a result
	 * 
	 * @param request
	 *            the SQL request
	 * @return the number of modified row
	 */
	public int execute(String request);

}
