/**
 * 
 */
package fr.redpanda.pander.entities.base;

import java.util.List;

import fr.redpanda.pander.entities.Skill;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IBaseSkillEntity {

	/**
	 * @return the id
	 */
	public double getId();

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills();

	/**
	 * @param skills
	 *            the skills to set
	 */
	public void setSkills(List<Skill> skills);

}
