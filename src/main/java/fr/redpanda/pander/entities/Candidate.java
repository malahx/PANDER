/**
 * 
 */
package fr.redpanda.pander.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Candidate extends User implements IBaseSkillEntity {

	private String firstname;
	private String lastname;
	private String transport;
	private String link1;
	private String link2;
	private String certificate1;
	private String certificate2;
	private String cv;
	private Date birthdate;
	private List<Skill> skills;
	private Mind mind;

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the transport
	 */
	public String getTransport() {
		return transport;
	}

	/**
	 * @param transport
	 *            the transport to set
	 */
	public void setTransport(String transport) {
		this.transport = transport;
	}

	/**
	 * @return the link1
	 */
	public String getLink1() {
		return link1;
	}

	/**
	 * @param link1
	 *            the link1 to set
	 */
	public void setLink1(String link1) {
		this.link1 = link1;
	}

	/**
	 * @return the link2
	 */
	public String getLink2() {
		return link2;
	}

	/**
	 * @param link2
	 *            the link2 to set
	 */
	public void setLink2(String link2) {
		this.link2 = link2;
	}

	/**
	 * @return the certificate1
	 */
	public String getCertificate1() {
		return certificate1;
	}

	/**
	 * @param certificate1
	 *            the certificate1 to set
	 */
	public void setCertificate1(String certificate1) {
		this.certificate1 = certificate1;
	}

	/**
	 * @return the certificate2
	 */
	public String getCertificate2() {
		return certificate2;
	}

	/**
	 * @param certificate2
	 *            the certificate2 to set
	 */
	public void setCertificate2(String certificate2) {
		this.certificate2 = certificate2;
	}

	/**
	 * @return the cv
	 */
	public String getCv() {
		return cv;
	}

	/**
	 * @param cv
	 *            the cv to set
	 */
	public void setCv(String cv) {
		this.cv = cv;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate != null ? new Date(birthdate.getTime()) : null;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate != null ? new Date(birthdate.getTime()) : null;
	}

	@Override
	public List<Skill> getSkills() {
		return skills;
	}

	@Override
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
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

	public Candidate() {
		super();
		this.setRole(Role.CANDIDATE);
		this.setSkills(new ArrayList<>());
	}

	public Candidate(String email) {
		super(email);
		this.setRole(Role.CANDIDATE);
		this.setSkills(new ArrayList<>());
	}

	/**
	 * @param email
	 * @param firstname
	 * @param lastname
	 */
	public Candidate(String email, String firstname, String lastname) {
		super(email);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setRole(Role.CANDIDATE);
		this.setSkills(new ArrayList<>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return firstname + " " + lastname + " (" + email + ")";
	}

}
