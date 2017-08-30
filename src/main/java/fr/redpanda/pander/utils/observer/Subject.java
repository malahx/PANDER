/**
 * 
 */
package fr.redpanda.pander.utils.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class Subject {

	private List<Observer> observers;

	/**
	 * 
	 * @param observer
	 *            the observer to attach
	 */
	protected void Attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * 
	 * @param observer
	 *            the observer to detach
	 */
	protected void Detach(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * 
	 * @param action
	 *            the action to notify
	 */
	protected void Notify(Action action) {
		for (Observer observer : observers) {
			observer.Update(action);
		}
	}

	public Subject() {
		super();
		this.observers = new ArrayList<>();
	}

}
