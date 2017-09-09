/**
 * 
 */
package fr.redpanda.pander.entities;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Answer extends BaseEntity {

	private String title;
	private Mind mind;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the mind
	 */
	public Mind getMind() {
		return mind;
	}

	/**
	 * @param mind
	 *            the mind to set
	 */
	public void setMind(Mind mind) {
		this.mind = mind;
	}

	public Answer() {
		super();
	}

}
