package fr.redpanda.pander.businesscode;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;

public class Matching {

	private Candidate candidate;
	private Company company;
	private Job job;
	private Double calculateRatio;

	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate
	 *            the candidate to set
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
	 * @param company
	 *            the company to set
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
	 * @param job
	 *            the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * @param candidate
	 * @param company
	 * @param job
	 */
	public Matching(Candidate candidate, Company company, Job job) {
		super();
		this.candidate = candidate;
		this.company = company;
		this.job = job;
		this.calculateRatio = null;
	}

	private List<Skill> getTechSkills(List<Skill> skills) {
		List<Skill> returnTechSkills = new ArrayList<>();
		for (int i = 0; i < skills.size(); i++) {
			Skill skill = skills.get(i);
			if (skill.getType().equals(TypeSkill.TECH)) {
				returnTechSkills.add(skill);
			}
		}
		return returnTechSkills;
	}

	private List<Skill> getSoftSkills(List<Skill> skills) {
		List<Skill> returnSoftSkills = new ArrayList<>();
		for (int i = 0; i < skills.size(); i++) {
			Skill skill = skills.get(i);
			if (skill.getType().equals(TypeSkill.SOFT)) {
				returnSoftSkills.add(skill);
			}
		}
		return returnSoftSkills;
	}

	private List<Skill> getEqualSkills(List<Skill> candidateSkills, List<Skill> jobSkills) {
		List<Skill> returnEqualSkills = new ArrayList<>();
		for (int i = 0; i < candidateSkills.size(); i++) {
			Skill candidateSkill = candidateSkills.get(i);

			for (int j = 0; j < jobSkills.size(); j++) {
				Skill jobSkill = jobSkills.get(j);

				if (candidateSkill.equals(jobSkill)) {
					returnEqualSkills.add(jobSkill);
				}
			}
		}
		return returnEqualSkills;
	}

	public double matchingCalc() {

		if (calculateRatio == null) {

			List<Skill> jobSkills = job.getSkills();
			List<Skill> candidateSkills = candidate.getSkills();
			List<Skill> jobTechSkills = getTechSkills(jobSkills);
			List<Skill> candidateTechSkills = getTechSkills(candidateSkills);
			List<Skill> jobSoftSkills = getSoftSkills(jobSkills);
			List<Skill> candidateSoftSkills = getSoftSkills(candidateSkills);

			List<Skill> equalTechSkills = getEqualSkills(candidateTechSkills, jobTechSkills);
			List<Skill> equalSoftSkills = getEqualSkills(candidateSoftSkills, jobSoftSkills);

			double techMatchingResult = (equalTechSkills.size()) / (jobTechSkills.size());
			double softMatchingResult = (equalSoftSkills.size()) / (jobSoftSkills.size());
			double jokerSkills = (jobTechSkills.size() - equalTechSkills.size()) / (jobTechSkills.size());

			calculateRatio = (techMatchingResult * 60) + (softMatchingResult * 30) + (jokerSkills * 10);

		}
		return calculateRatio;

	}

}
