/**
 * 
 */
package fr.redpanda.pander.utils;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Utils {
	public static List<BaseEntity> getSkills(List<BaseEntity> skills, TypeSkill type) {
		List<BaseEntity> s = new ArrayList<>();
		for (BaseEntity skill : skills) {
			if (((Skill) skill).getType().equals(type)) {
				s.add(skill);
			}
		}
		return s;
	}
}
