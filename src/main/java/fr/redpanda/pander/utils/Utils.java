/**
 * 
 */
package fr.redpanda.pander.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Utils {

	public static List<BaseEntity> getSkillsType(List<BaseEntity> skills, TypeSkill type) {
		List<BaseEntity> s = new ArrayList<>();
		for (BaseEntity skill : skills) {
			if (((Skill) skill).getType().equals(type)) {
				s.add(skill);
			}
		}
		return s;
	}

	public static void generateCandidate() {
		List<BaseEntity> skills = SkillDAO.getInstance().get();
		for (int i = 0; i < 30; i++) {
			Candidate candidate = new Candidate();
			candidate.setEmail("candidate" + i);
			candidate.setPassword("candidate");
			candidate.setFirstname("Candidate");
			candidate.setLastname("CANDIDATE");
			int n = ThreadLocalRandom.current().nextInt(0, skills.size());
			for (int j = 0; j < n; j++) {
				int k = 0;
				do {
					k = ThreadLocalRandom.current().nextInt(0, skills.size());
				} while (candidate.getSkills().contains(skills.get(k)));
				candidate.getSkills().add((Skill) skills.get(k));
			}
			CandidateDAO.getInstance().insert(candidate);
			CandidateDAO.getInstance().insertSkills(candidate);
		}
	}
}
