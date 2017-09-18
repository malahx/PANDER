/**
 * 
 */
package fr.redpanda.pander.test.views.base;

import java.awt.Component;

import javax.swing.JPanel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseViewTest {

	/**
	 * Verify if a component is contained in a panel and in is sub panel
	 * 
	 * @param main
	 *            the main panel
	 * @param entity
	 *            the entity to test
	 * @return
	 */
	public boolean contains(JPanel main, Component entity) {
		boolean result = true;
		Component[] components = main.getComponents();
		for (int i = 0; i < components.length && !result; i++) {
			if (entity.equals(components[i])) {
				result = true;
			} else if (components[i] instanceof JPanel) {
				JPanel panel = (JPanel) components[i];
				result = contains(panel, entity);
			}
		}
		return result;
	}

}
