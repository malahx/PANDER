/**
 * 
 */
package fr.redpanda.pander.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import fr.redpanda.pander.databases.DAOManager;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class EntitiesCreation extends DAOManager {

	protected Candidate candidate;
	protected Company company;
	protected Job job;
	protected Skill skillSoft;
	protected Skill skillTech;
	protected Skill skillOther;

	@Before
	public void setUp() {

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
