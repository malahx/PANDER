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
	private Long id;
	private String name;
	private String type;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
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
	public Skill(Long id, String name, String type) {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
	}

}
