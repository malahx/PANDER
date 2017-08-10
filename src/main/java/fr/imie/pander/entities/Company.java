/**
 * 
 */
package fr.imie.pander.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class Company extends User {

	private String name;
	private String siret;
	private String contact;
	private String link;
	private List<Job> jobs;

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
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * @param siret
	 *            the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
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
	 * @return the jobs
	 */
	public List<Job> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs
	 *            the jobs to set
	 */
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	/**
	 * @param name
	 * @param siret
	 * @param contact
	 * @param link
	 * @param jobs
	 */
	public Company(String name, String siret, String contact, String link) {
		super();
		this.name = name;
		this.siret = siret;
		this.contact = contact;
		this.link = link;
		this.jobs = new ArrayList<>();
	}

}
