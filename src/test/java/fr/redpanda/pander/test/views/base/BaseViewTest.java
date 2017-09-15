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
