/**
 * 
 */
package fr.redpanda.pander.database;

import java.util.List;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IDAO<T> {

	/**
	 * 
	 * @param o
	 *            the object to create on the database
	 * @return the object created
	 */
	public T create(T o);

	/**
	 * 
	 * @param o
	 *            the object to delete from the database
	 * @return the object deleted
	 */
	public T delete(T o);

	/**
	 * 
	 * @param id
	 *            the id of the data which need to be deleted
	 * @return if the data have been deleted
	 */
	public boolean delete(int id);

	/**
	 * 
	 * @param o
	 *            the object to update on the database
	 * @return the updated object
	 */
	public T update(T o);

	/**
	 * 
	 * @return a list of all object on the database
	 */
	public List<T> findAll();

	/**
	 * 
	 * @param id
	 *            the id to find on the database
	 * @return the object link to the id
	 */
	public T findBy(int id);

}
