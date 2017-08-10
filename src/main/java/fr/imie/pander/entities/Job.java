/**
 * 
 */
package fr.imie.pander.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Job {
	private int id;
	private String name;
	private String presentation;
	private String link;
	private String contactEmail;
	private List<Skill> skills;
	private Date createdAt;
	private Date updatedAt;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
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
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail
	 *            the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills to set
	 */
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
	 * @param id
	 * @param name
	 * @param presentation
	 * @param link
	 * @param contactEmail
	 * @param skills
	 * @param createdAt
	 * @param updatedAt
	 */
	public Job(int id, String name, String presentation, String link, String contactEmail, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.presentation = presentation;
		this.link = link;
		this.contactEmail = contactEmail;
		this.skills = new ArrayList<>();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}
