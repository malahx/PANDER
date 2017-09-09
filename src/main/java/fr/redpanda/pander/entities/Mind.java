/**
 * 
 */
package fr.redpanda.pander.entities;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Mind extends BaseEntity implements IBaseSkillEntity {

	private String name;
	private List<Skill> skills;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.entities.base.IBaseSkillEntity#getSkills()
	 */
	@Override
	public List<Skill> getSkills() {
		return skills;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.entities.base.IBaseSkillEntity#setSkills(java.util.List)
	 */
	@Override
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Mind() {
		super();
		skills = new ArrayList<>();
	}

}
