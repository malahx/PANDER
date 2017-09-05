/**
 * 
 */
package fr.redpanda.pander.entities.base;

import java.util.Date;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class DateEntity extends BaseEntity {

	private Date createdAt;
	private Date updatedAt;

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt != null ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt != null ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt != null ? new Date(updatedAt.getTime()) : null;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt != null ? new Date(updatedAt.getTime()) : null;
	}

}
