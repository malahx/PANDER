/**
 * 
 */
package fr.redpanda.pander.databases.base;

import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IBaseSkillDAO {

	/**
	 * Get and set skills of an entity
	 * 
	 * @param entity
	 *            an entity which has a skill list
	 * @return the entity
	 */
	public IBaseSkillEntity getSkills(IBaseSkillEntity entity);

	/**
	 * Insert a list of skills from an entity
	 * 
	 * @param candidate
	 * @return
	 */
	public int insertSkills(IBaseSkillEntity entity);

	/**
	 * Delete all skills from an entity
	 * 
	 * @param candidate
	 * @return
	 */
	public int deleteSkills(IBaseSkillEntity entity);

	/**
	 * Delete all linked skills
	 * 
	 * @return
	 */
	public int deleteSkills();

}
