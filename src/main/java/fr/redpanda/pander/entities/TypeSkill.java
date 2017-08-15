/**
 * 
 */
package fr.redpanda.pander.entities;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public enum TypeSkill {

	SOFT("SOFT"),
	TECH("TECH");

	private final String text;

	/**
	 * @param text
	 */
	private TypeSkill(final String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
	
}
