/**
 * 
 */
package fr.redpanda.pander.views.base;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class ProfileView extends MainView {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.IMainView#isEditable()
	 */
	@Override
	public boolean isEditable() {
		return true;
	}

}
