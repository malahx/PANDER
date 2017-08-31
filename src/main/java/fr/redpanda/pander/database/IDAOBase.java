/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IDAOBase {

	/**
	 * Parse a {@link ResultSet} to a {@link BaseEntity}
	 * 
	 * @param resultSet
	 *            the result set
	 * @return the entity
	 */
	public BaseEntity parse(ResultSet resultSet);

	/**
	 * Parse a {@link BaseEntity} to a {@link String}
	 * 
	 * @param entity
	 *            the entity to parse
	 * @return the string
	 */
	public String parse(BaseEntity entity);
	
	/**
	 * Parse fields in a {@link String}
	 * @return the fields
	 */
	public String fields();

	/**
	 * Execute a SQL request
	 * 
	 * @param request
	 *            the SQL request
	 * @return the result of the request
	 */
	public ResultSet executeRequest(String request);

	/**
	 * Execute a SQL request
	 * 
	 * @param request
	 *            the SQL request
	 * @return the id
	 */
	public double execute(String request);

	/**
	 * Insert a {@link BaseEntity} on the database
	 * 
	 * @param item
	 *            the item to insert
	 */
	public void insert(BaseEntity item);

	/**
	 * Update a {@link BaseEntity} on the database
	 * 
	 * @param item
	 *            the item to update
	 */
	public void update(BaseEntity item);

	/**
	 * Delete a {@link BaseEntity} on the database
	 * 
	 * @param item
	 *            the item to delete
	 */
	public void delete(BaseEntity item);

	/**
	 * Delete all datas on the database
	 */
	public void delete();

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
