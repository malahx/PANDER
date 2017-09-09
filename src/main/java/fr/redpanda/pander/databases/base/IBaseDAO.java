/**
 * 
 */
package fr.redpanda.pander.databases.base;

import java.sql.ResultSet;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IBaseDAO {

	/**
	 * Parse a {@link ResultSet} to a {@link BaseEntity}
	 * 
	 * @param rs
	 *            the result set
	 * @return the entity
	 */
	public BaseEntity parse(ResultSet rs);

	/**
	 * Parse a {@link BaseEntity} to a {@link String} for SQL insert
	 * 
	 * @param entity
	 *            the entity to parse
	 * @return the string
	 */
	public String parse(BaseEntity entity);

	/**
	 * Parse a {@link BaseEntity} to a {@link String} for SQL update
	 * 
	 * @param entity
	 *            the entity to parse
	 * @return the string
	 */
	public String parseUpdate(BaseEntity entity);

	/**
	 * Parse fields in a {@link String}
	 * 
	 * @return the fields
	 */
	public String fields();

	/**
	 * Check if fields can be inserted
	 * 
	 * @param entity
	 *            the entity to check
	 * @return if fields can be inserted
	 */
	public boolean checkFields(BaseEntity entity);

	/**
	 * Check uniques fields
	 * 
	 * @param entity
	 *            the entity to check
	 * @return if fields have unique value
	 */
	public boolean checkUniqueFields(BaseEntity entity);

	/**
	 * Check if fields exists on the database
	 * 
	 * @param entity
	 *            the entity to check
	 * @return if fields exists on the database
	 */
	public boolean checkExists(BaseEntity entity);

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

	/**
	 * Insert a {@link BaseEntity} on the database
	 * 
	 * @param entity
	 *            the entity to insert
	 */
	public BaseEntity insert(BaseEntity entity);

	/**
	 * Update a {@link BaseEntity} on the database
	 * 
	 * @param entity
	 *            the entity to update
	 */
	public int update(BaseEntity entity);

	/**
	 * Delete a {@link BaseEntity} on the database
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	public int delete(BaseEntity entity);

	/**
	 * Delete an id on the database
	 * 
	 * @param id
	 *            the id to delete
	 */
	public int delete(double id);

	/**
	 * Delete all datas on the database
	 */
	public int delete();

	/**
	 * Get a {@link BaseEntity} from an id on the database
	 * 
	 * @param id
	 *            the id to use
	 * @return the {@link BaseEntity} from the id
	 */
	public BaseEntity get(double id);

	/**
	 * Get all {@link BaseEntity} on the database
	 * 
	 * @return the list of the {@link BaseEntity}
	 */
	public List<BaseEntity> get();

}
