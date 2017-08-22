/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class MainCtrl extends BaseCtrl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {

		MainView view = (MainView) this.view;

		User user = (User) getViewDatas().get(TypeData.USER);
		view.getNavbar().getLblUser().setText(user instanceof Candidate ? "Candidat" : "Entreprise");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {

		MainView view = (MainView) this.view;

		view.getNavbar().getTglbtnHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getNavbar().getTglbtnHome().setSelected(true);
				if (ViewsManager.getInstance().isCurrentController(HomeCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new HomeCtrl(frame));
				view.getNavbar().getTglbtnMatching().setSelected(false);
				view.getNavbar().getTglbtnProfile().setSelected(false);
			}
		});

		view.getNavbar().getTglbtnProfile().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getNavbar().getTglbtnProfile().setSelected(true);
				if (ViewsManager.getInstance().isCurrentController(ProfileCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new ProfileCtrl(frame));
				view.getNavbar().getTglbtnMatching().setSelected(false);
				view.getNavbar().getTglbtnHome().setSelected(false);
			}
		});

		view.getNavbar().getTglbtnProfile().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getNavbar().getTglbtnMatching().setSelected(true);
				if (ViewsManager.getInstance().isCurrentController(MatchingCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new MatchingCtrl(frame));
				view.getNavbar().getTglbtnProfile().setSelected(false);
				view.getNavbar().getTglbtnHome().setSelected(false);
			}
		});

		view.getFooter().getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		view.getFooter().getBtnLogout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().start();
			}
		});

	}

}
