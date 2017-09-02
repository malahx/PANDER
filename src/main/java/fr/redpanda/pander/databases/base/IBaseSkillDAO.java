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
	
}
