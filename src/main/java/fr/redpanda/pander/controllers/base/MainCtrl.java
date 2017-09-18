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
import fr.redpanda.pander.controllers.JobCtrl;
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

	protected boolean isPublic = false;
	protected User user;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {

		MainView view = (MainView) this.view;

		if (user instanceof Candidate) {
			view.getNavbar().getLblUser().setText("CANDIDAT");
			view.getNavbar().getLblLogouser().setIcon(new ImageIcon(Img.HOME_CANDIDATE));
			if (!isPublic) {
				view.getNavbar().getTglbtnJob().setVisible(false);
			} else {
				view.getNavbar().getTglbtnJob().setVisible(true);
			}
			view.getSidebar().initCandidate((Candidate) user);
		} else {
			view.getNavbar().getLblUser().setText("ENTREPRISE");
			view.getNavbar().getLblLogouser().setIcon(new ImageIcon(Img.HOME_COMPANY));
			if (isPublic) {
				view.getNavbar().getTglbtnJob().setVisible(false);
			} else {
				view.getNavbar().getTglbtnJob().setVisible(true);
			}
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

		initNavbar(view);
		initFooter(view);
		initEditSidebar(view);

	}

	/**
	 * Initialization of the Navbar Events
	 * 
	 * @param view
	 */
	private void initNavbar(MainView view) {
		view.getNavbar().getTglbtnHome().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gotoHome();
			}
		});

		view.getNavbar().getTglbtnProfile().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gotoProfile();
			}
		});

		view.getNavbar().getTglbtnMatching().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gotoMatching();
			}
		});

		view.getNavbar().getTglbtnJob().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				gotoJob();
			}
		});
	}

	/**
	 * Initialization of the Footer Events
	 * 
	 * @param view
	 */
	private void initFooter(MainView view) {
		view.getFooter().getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		view.getFooter().getBtnLogout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().start();
			}
		});
	}

	/**
	 * Initialization of the Edit sidebar Events
	 * 
	 * @param view
	 */
	private void initEditSidebar(MainView view) {
		if (!view.isEditable()) {
			return;
		}
		SidebarEditable sidebar = (SidebarEditable) view.getSidebar();
		DocListener updateProfile = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				updateUser(sidebar);
			}
		};
		sidebar.getTxtName1().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtName2().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtCity().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtAddress().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtCity().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtDescription().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtPhone().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtPostcode().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtLink1().getDocument().addDocumentListener(updateProfile);
		sidebar.getTxtLink2().getDocument().addDocumentListener(updateProfile);
	}

	/**
	 * The function to go to the Job controller
	 */
	protected void gotoJob() {
		if (ViewsManager.getInstance().isCurrentController(JobCtrl.class)) {
			return;
		}
		ViewsManager.getInstance().next(new JobCtrl());
	}

	/**
	 * The function to go to the Matching controller
	 */
	protected void gotoMatching() {
		if (ViewsManager.getInstance().isCurrentController(MatchingCtrl.class)) {
			return;
		}
		ViewsManager.getInstance().next(new MatchingCtrl());
	}

	/**
	 * The function to go to the Profile controller
	 */
	protected void gotoProfile() {
		if (ViewsManager.getInstance().isCurrentController(ProfileCtrl.class)) {
			return;
		}
		ViewsManager.getInstance().next(new ProfileCtrl());
	}

	/**
	 * The function to go to the Home controller
	 */
	protected void gotoHome() {
		if (ViewsManager.getInstance().isCurrentController(HomeCtrl.class)) {
			return;
		}
		ViewsManager.getInstance().next(new HomeCtrl());
	}

	/**
	 * The function to update users from the sidebar
	 * 
	 * @param sidebar
	 */
	protected void gotoProfile(User publicUser) {
		if (ViewsManager.getInstance().isCurrentController(PublicProfileCtrl.class)) {
			return;
		}
		ViewsManager.getInstance()
				.next(publicUser instanceof Candidate ? new ProfileCtrl(publicUser) : new JobCtrl(publicUser));
	}

	/**
	 * 
	 */
	private void updateUser(SidebarEditable sidebar) {
		user.setEmail(sidebar.getTxtMail().getText());
		user.setAddress(sidebar.getTxtAddress().getText());
		user.setCity(sidebar.getTxtCity().getText());
		user.setDescription(sidebar.getTxtDescription().getText());
		user.setPhone(sidebar.getTxtPhone().getText());
		user.setPostcode(sidebar.getTxtPostcode().getText());
		if (user instanceof Candidate) {
			updateUser(sidebar, (Candidate) user);
		} else if (user instanceof Company) {
			updateUser(sidebar, (Company) user);
		} else {
			UserDAO.getInstance().update(user);
		}
	}

	/**
	 * The function to update a company from the sidebar
	 * 
	 * @param sidebar
	 * @param company
	 */
	private void updateUser(SidebarEditable sidebar, Company company) {
		company.setLink(sidebar.getTxtLink1().getText());
		company.setSiret(sidebar.getTxtName2().getText());
		company.setName(sidebar.getTxtName1().getText());
		company.setContact(sidebar.getTxtLink2().getText());
		CompanyDAO.getInstance().update(company);
	}

	/**
	 * The function to update candidate from the sidebar
	 * 
	 * @param sidebar
	 * @param candidate
	 */
	private void updateUser(SidebarEditable sidebar, Candidate candidate) {
		candidate.setFirstname(sidebar.getTxtName1().getText());
		candidate.setLastname(sidebar.getTxtName2().getText());
		candidate.setLink1(sidebar.getTxtLink1().getText());
		candidate.setLink2(sidebar.getTxtLink2().getText());
		CandidateDAO.getInstance().update(candidate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#setupDatas()
	 */
	@Override
	public void setupDatas() {
		super.setupDatas();
		if (isPublic) {
			return;
		}
		user = (User) getViewDatas().get(TypeData.USER);
	}
}
