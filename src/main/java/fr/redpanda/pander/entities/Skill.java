/**
 * 
 */
package fr.redpanda.pander.entities;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Skill {
	private String id;
	private String name;
	private String type;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public Skill(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

}
