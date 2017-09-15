/**
 * 
 */
package fr.redpanda.pander.test.controllers.decorator;

import javax.swing.JFrame;

import fr.redpanda.pander.controllers.RegisterCtrl;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.views.RegisterView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class RegisterCtrlDecorator extends RegisterCtrl {

	private boolean isBtnActive;

	/**
	 * @return the isBtnActive
	 */
	public boolean isBtnActive() {
		return isBtnActive;
	}

	/**
	 * The Constructor
	 * 
	 * @param mainFrame
	 * @param frame
	 * @param user
	 */
	public RegisterCtrlDecorator(JFrame mainFrame, JFrame frame, User user) {
		super(mainFrame, frame, user);
	}
	
	public boolean refresh(RegisterView view) {
		return super.refresh(view);
	}

}
