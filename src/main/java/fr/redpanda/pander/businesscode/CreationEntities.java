package fr.redpanda.pander.businesscode;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;

public class CreationEntities {

	protected Candidate candidate;
	protected Company company;
	protected Job job;
	protected Skill skillSoft;
	protected Skill skillTech;
	protected Skill skillOther;

	/** GENERATION DES GETTERS ET DES SETTERS :
	 *
	 */
	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @return the skillSoft
	 */
	public Skill getSkillSoft() {
		return skillSoft;
	}

	/**
	 * @param skillSoft the skillSoft to set
	 */
	public void setSkillSoft(Skill skillSoft) {
		this.skillSoft = skillSoft;
	}

	/**
	 * @return the skillTech
	 */
	public Skill getSkillTech() {
		return skillTech;
	}

	/**
	 * @param skillTech the skillTech to set
	 */
	public void setSkillTech(Skill skillTech) {
		this.skillTech = skillTech;
	}

	/**
	 * @return the skillOther
	 */
	public Skill getSkillOther() {
		return skillOther;
	}

	/**
	 * @param skillOther the skillOther to set
	 */
	public void setSkillOther(Skill skillOther) {
		this.skillOther = skillOther;
	}


	
	/** GENERATION DU CONSTRUCTEUR
	 * @param candidate
	 * @param company
	 * @param job
	 * @param skillSoft
	 * @param skillTech
	 * @param skillOther
	 */
	
	public CreationEntities() {
		super();

		candidate = new Candidate("firstname@lastname.com", "firstname", "lastname");
		candidate.setPassword("hashedpassword");

		company = new Company("IMIE", "00000000000000", "firstname@imie.com", "https://imie-ecole-informatique.fr/");
		company.setPassword("hashedpassword");

		job = new Job("Developer");

		skillSoft = new Skill("Rigoureux", TypeSkill.SOFT);
		skillTech = new Skill("Java", TypeSkill.TECH);
		skillOther = new Skill("Gestion de projet", TypeSkill.TECH);

		List<Skill> skills = new ArrayList<>();
		skills.add(skillSoft);
		skills.add(skillTech);
		skills.add(skillOther);

		job.getSkills().addAll(skills);
		candidate.getSkills().addAll(skills);

		company.getJobs().add(job);

	}
	

}
