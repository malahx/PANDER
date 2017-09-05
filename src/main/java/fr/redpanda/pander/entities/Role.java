/**
 * 
 */
package fr.redpanda.pander.entities;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public enum Role {
	CANDIDATE("CANDIDATE"),
	COMPANY("COMPANY"),
	ADMIN("ADMIN");

	private final String text;

	/**
	 * @param text
	 */
	private Role(final String text) {
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
