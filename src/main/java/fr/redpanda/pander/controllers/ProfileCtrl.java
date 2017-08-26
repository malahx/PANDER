/**
 * 
 */
package fr.redpanda.pander.controllers;

import javax.swing.JFrame;

import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.BaseView;
import fr.redpanda.pander.views.CandidateView;
import fr.redpanda.pander.views.CompanyView;
import fr.redpanda.pander.views.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ProfileCtrl extends MainCtrl {
	
	@Override
	public BaseView getView() {
		if (view == null) {
			User user = (User) getViewDatas().get(TypeData.USER);
			if (user instanceof Company) {
				view = new CompanyView();
			} else {
				view = new CandidateView();
			}
		}
		return view;
	}

	/**
	 * @param frame
	 * 
	 */
	public ProfileCtrl(JFrame frame) {
		super.frame = frame;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		MainView view = (MainView) this.view;
		view.getNavbar().getTglbtnProfile().setSelected(true);
	}

}
