/**
 * 
 */
package fr.redpanda.pander.entities.base;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseEntity {

	protected double id;

	/**
	 * @return the id
	 */
	public double getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(double id) {
		this.id = id;
	}

}
