/**
 * 
 */
package fr.redpanda.pander.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Job extends BaseEntity implements IBaseSkillEntity {

	private String name;
	private String presentation;
	private String link;
	private String contact;
	private List<Skill> skills;
	private Date createdAt;
	private Date updatedAt;

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
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 * @param name
	 */
	public Job(String name) {
		super();
		this.setName(name);
		this.setSkills(new ArrayList<>());
	}

	/**
	 * @param id
	 * @param name
	 * @param presentation
	 * @param link
	 * @param contactEmail
	 * @param skills
	 * @param createdAt
	 * @param updatedAt
	 */
	public Job(double id, String name, String presentation, String link, String contactEmail, Date createdAt,
			Date updatedAt) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPresentation(presentation);
		this.setLink(link);
		this.setContact(contactEmail);
		this.setSkills(new ArrayList<>());
		this.setCreatedAt(createdAt);
		this.setUpdatedAt(updatedAt);
	}

	/**
	 * 
	 */
	public Job() {
		super();
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
