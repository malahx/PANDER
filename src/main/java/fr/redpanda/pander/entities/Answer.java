/**
 * 
 */
package fr.redpanda.pander.entities;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Answer extends BaseEntity {

	private String title;
	private Skill skill;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}

	/**
	 * @param skill
	 *            the skill to set
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Answer() {
		super();
	}

}
