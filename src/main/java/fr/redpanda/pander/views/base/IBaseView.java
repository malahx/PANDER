package fr.redpanda.pander.views.base;

import javax.swing.JFrame;

public interface IBaseView {

	/**
	 * Load the view and link it with a frame
	 * 
	 * @param frame
	 */
	public void loadView(JFrame frame);

}
