/**
 * 
 */
package fr.redpanda.pander.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class EntitiesCreation {

	protected Admin admin;
	protected Candidate candidate;
	protected Company company;
	protected Job job;
	protected Skill skillSoft;
	protected Skill skillTech;
	protected Skill skillOther;

	@Before
	public void setUp() throws Exception {

		admin = new Admin();
		admin.setEmail("admin@admin.fr");
		admin.setPassword("password");

		candidate = new Candidate();
		candidate.setEmail("candidate@candidate.fr");
		candidate.setPassword("password");
		candidate.setFirstname("firstname");
		candidate.setLastname("lastname");

		company = new Company();
		company.setEmail("company@company.fr");
		company.setPassword("password");
		company.setName("name");
		company.setSiret("1234567891011");

		job = new Job("Developpeur");

		skillSoft = new Skill("Rigoureux1", TypeSkill.SOFT);
		skillTech = new Skill("Java1", TypeSkill.TECH);
		skillOther = new Skill("Gestion de projet1", TypeSkill.TECH);

		List<Skill> skills = new ArrayList<>();
		skills.add(skillSoft);
		skills.add(skillTech);
		skills.add(skillOther);

		job.getSkills().addAll(skills);
		candidate.getSkills().addAll(skills);

		company.getJobs().add(job);

	}
}
