/**
 * 
 */
package fr.redpanda.pander.controllers.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.controllers.HomeCtrl;
import fr.redpanda.pander.controllers.MatchingCtrl;
import fr.redpanda.pander.controllers.ProfileCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.base.MainView;
import fr.redpanda.pander.views.models.DocListener;
import fr.redpanda.pander.views.subviews.SidebarEditable;

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
		if (user instanceof Candidate) {
			view.getNavbar().getLblUser().setText("CANDIDAT");
			view.getNavbar().getLblLogouser().setIcon(new ImageIcon(Img.HOME_CANDIDATE));
			view.getSidebar().initCandidate((Candidate) user);
		} else {
			view.getNavbar().getLblUser().setText("ENTREPRISE");
			view.getNavbar().getLblLogouser().setIcon(new ImageIcon(Img.HOME_COMPANY));
			view.getSidebar().initCompany((Company) user);
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
			DocListener updateProfile = new DocListener() {

				@Override
				public void update(DocumentEvent e) {
					updateUser(sidebar);
				}
			};
			sidebar.getTxtAdress().getDocument().addDocumentListener(updateProfile);
			sidebar.getTxtCity().getDocument().addDocumentListener(updateProfile);
			sidebar.getTxtDescriptionTitle().getDocument().addDocumentListener(updateProfile);
			sidebar.getTxtPhone().getDocument().addDocumentListener(updateProfile);
			sidebar.getTxtCp().getDocument().addDocumentListener(updateProfile);
		}

	}

	/**
	 * 
	 */
	private void updateUser(SidebarEditable sidebar) {
		User user = (User) getViewDatas().get(TypeData.USER);
		user.setEmail(sidebar.getTxtMail().getText());
		user.setAddress(sidebar.getTxtAdress().getText());
		user.setCity(sidebar.getTxtCity().getText());
		user.setDescription(sidebar.getTxtDescriptionTitle().getText());
		user.setPhone(sidebar.getTxtPhone().getText());
		user.setPostcode(sidebar.getTxtCp().getText());
		if (user instanceof Candidate) {
			updateUser(sidebar, (Candidate) user);
		} else if (user instanceof Company) {
			updateUser(sidebar, (Company) user);
		} else {
			UserDAO.getInstance().update(user);
		}
	}

	/**
	 * @param sidebar
	 * @param cuser
	 */
	private void updateUser(SidebarEditable sidebar, Company cuser) {
		cuser.setLink(sidebar.getTxtLink1().getText());
		cuser.setSiret(sidebar.getTxtName2().getText());
		cuser.setName(sidebar.getTxtName1().getText());
		cuser.setContact(sidebar.getTxtLink2().getText());
		CompanyDAO.getInstance().update(cuser);
	}

	/**
	 * @param sidebar
	 * @param user
	 */
	private void updateUser(SidebarEditable sidebar, Candidate cuser) {
		cuser.setFirstname(sidebar.getTxtName1().getText());
		cuser.setLastname(sidebar.getTxtName2().getText());
		cuser.setLink1(sidebar.getTxtLink1().getText());
		cuser.setLink2(sidebar.getTxtLink2().getText());
		CandidateDAO.getInstance().update(cuser);
	}

}
