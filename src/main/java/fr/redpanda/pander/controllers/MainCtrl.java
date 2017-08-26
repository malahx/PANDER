/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.MainView;
import fr.redpanda.pander.views.subviews.SidebarEditable;
import fr.redpanda.pander.views.subviews.SidebarPublic;

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
		

		if (view.isEditable()) {
			SidebarEditable sidebar = (SidebarEditable) view.getSidebar();
			sidebar.getTxtAdress().setText(user.getAddress());
			sidebar.getTxtCity().setText(user.getCity());
			sidebar.getTxtDescriptionTitle().setText(user.getDescription());
			sidebar.getTxtPhone().setText(user.getPhone());
			sidebar.getTxtCP().setText(user.getPostcode());
		} else {
			SidebarPublic sidebar = (SidebarPublic) view.getSidebar();
			sidebar.getLblAddress().setText(user.getAddress());
			sidebar.getLblCity().setText(user.getCity());
			sidebar.getLblDescriptionTitle().setText(user.getDescription());
			sidebar.getLblPhone().setText(user.getPhone());
			sidebar.getLblCp().setText(user.getPostcode());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {

		MainView view = (MainView) this.view;

		view.getNavbar().getTglbtnHome().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ViewsManager.getInstance().isCurrentController(HomeCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new HomeCtrl(frame));
			}
		});

		view.getNavbar().getTglbtnProfile().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ViewsManager.getInstance().isCurrentController(ProfileCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new ProfileCtrl(frame));				
			}
		});

		view.getNavbar().getTglbtnMatching().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ViewsManager.getInstance().isCurrentController(MatchingCtrl.class)) {
					return;
				}
				ViewsManager.getInstance().next(new MatchingCtrl(frame));
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

		view.getSidebar().getBtnTelechargCV().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		if (view.isEditable()) {
			SidebarEditable sidebar = (SidebarEditable) view.getSidebar();
			ActionListener updateProfile = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateUser(sidebar);
				}
			};
			sidebar.getTxtAdress().addActionListener(updateProfile);
			sidebar.getTxtCity().addActionListener(updateProfile);
			sidebar.getTxtDescriptionTitle().addActionListener(updateProfile);
			sidebar.getTxtPhone().addActionListener(updateProfile);
			sidebar.getTxtCP().addActionListener(updateProfile);
		}

	}

	/**
	 * 
	 */
	private void updateUser(SidebarEditable sidebar) {
		User user = (User) getViewDatas().get(TypeData.USER);
		user.setAddress(sidebar.getTxtAdress().getText());
		user.setCity(sidebar.getTxtCity().getText());
		user.setDescription(sidebar.getTxtDescriptionTitle().getText());
		user.setPhone(sidebar.getTxtPhone().getText());
		user.setPostcode(sidebar.getTxtCP().getText());
		UserDAO.getInstance().update(user);
	}

}
