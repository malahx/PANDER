/**
 * 
 */
package fr.redpanda.pander.entities;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.base.DateEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Job extends DateEntity implements IBaseSkillEntity {

	private String name;
	private String presentation;
	private String link;
	private String contact;
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

	/**
	 * @return the presentation
	 */
	public String getPresentation() {
		return presentation;
	}

	/**
	 * @param presentation
	 *            the presentation to set
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the skills
	 */
	@Override
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills to set
	 */
	@Override
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * The constructor
	 */
	public Job() {
		super();
		this.setSkills(new ArrayList<>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
