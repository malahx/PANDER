/**
 * 
 */
package fr.redpanda.pander.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Job {

	private Long id;
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
	public Job(Long id, String name, String presentation, String link, String contactEmail, Date createdAt,
			Date updatedAt) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPresentation(presentation);
		this.setLink(link);
		this.setContactEmail(contactEmail);
		this.setSkills(new ArrayList<>());
		this.setCreatedAt(createdAt);
		this.setUpdatedAt(updatedAt);
	}

	/**
	 * @param result
	 * @throws SQLException
	 */
	public Job(ResultSet result) throws SQLException {
		super();
		this.setId(result.getLong("id"));
		this.setName(result.getString("name"));
		this.setPresentation(result.getString("presentation"));
		this.setLink(result.getString("link"));
		this.setContactEmail(result.getString("contactEmail"));
		this.setSkills(new ArrayList<>());
		this.setCreatedAt(new Date(result.getDate("createdAt").getTime()));
		this.setUpdatedAt(new Date(result.getDate("updatedAt").getTime()));
	}

}
