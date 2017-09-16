/**
 * 
 */
package fr.redpanda.pander.views.models;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class DocListener implements DocumentListener {

	/**
	 * Update if insert, remove or changed data.
	 * 
	 * @param e
	 */
	public abstract void update(DocumentEvent e);

	/**
	 * 
	 */
	public DocListener() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		update(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		update(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		update(e);
	}

}
