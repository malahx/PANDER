/**
 * 
 */
package fr.redpanda.pander.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Skill extends BaseEntity {

	private String name;
	private TypeSkill type;

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
	public TypeSkill getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeSkill type) {
		this.type = type;
	}

	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public Skill(String name, TypeSkill type) {
		super();
		this.setName(name);
		this.setType(type);
	}

	/**
	 * @param id
	 * @param name
	 * @param type
	 */
	public Skill(double id, String name, TypeSkill type) {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
	}

	/**
	 * @param result
	 * @throws SQLException
	 */
	public Skill(ResultSet result) throws SQLException {
		super();
		this.setId(result.getLong("s.id"));
		this.setName(result.getString("s.name"));
		this.setType(StringManager.getTypeSkillFrom(result.getString("s.type")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return this.id == other.getId();
	}

}
