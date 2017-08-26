/**
 * 
 */
package fr.redpanda.pander.controllers;

import javax.swing.JFrame;

import fr.redpanda.pander.views.MatchingView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingCtrl extends MainCtrl {

	/**
	 * 
	 */
	public MatchingCtrl(JFrame frame) {
		super.frame = frame;
		super.view = new MatchingView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		MatchingView view = (MatchingView) this.view;
		view.getNavbar().getTglbtnMatching().setSelected(true);
	}

}
