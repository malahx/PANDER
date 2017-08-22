/**
 * 
 */
package fr.redpanda.pander.controllers;

import javax.swing.JFrame;

import fr.redpanda.pander.views.HomeView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class HomeCtrl extends MainCtrl {

	/**
	 * 
	 */
	public HomeCtrl(JFrame frame) {
		super.frame = frame;
		super.view = new HomeView();
	}

}
