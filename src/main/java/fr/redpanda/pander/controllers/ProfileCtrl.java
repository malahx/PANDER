/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import fr.redpanda.pander.controllers.base.PublicProfileCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.Utils;
import fr.redpanda.pander.utils.date.DateConverter;
import fr.redpanda.pander.views.CandidateView;
import fr.redpanda.pander.views.CompanyView;
import fr.redpanda.pander.views.base.BaseView;
import fr.redpanda.pander.views.base.MainView;
import fr.redpanda.pander.views.models.DocListener;
import fr.redpanda.pander.views.models.SkillTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ProfileCtrl extends PublicProfileCtrl {

	/**
	 * The company events initialization
	 * 
	 * @param user
	 */
	private void initCompanyEvent(User user) {
	}

	/**
	 * The candidate events initialization
	 * 
	 * @param user
	 */
	private void initCandidateEvent(User user) {
		CandidateView cview = (CandidateView) this.view;

		DocListener updateProfile = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				updateCandidate(user);
			}
		};

		cview.getTextCertificate1().getDocument().addDocumentListener(updateProfile);
		cview.getTextCertificate2().getDocument().addDocumentListener(updateProfile);
		cview.getTextBirthday().getDocument().addDocumentListener(updateProfile);
		cview.getTextTransport().getDocument().addDocumentListener(updateProfile);
		cview.getTableTechSkills().getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				CandidateDAO.getInstance().insertSkills((Candidate) user);
			}
		});

		cview.getTableSoftSkills().getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				CandidateDAO.getInstance().insertSkills((Candidate) user);
			}
		});
	}

	/**
	 * The update of the candidate from the view
	 * 
	 * @param user
	 */
	private void updateCandidate(User user) {
		CandidateView view = (CandidateView) this.view;
		Candidate cuser = (Candidate) user;
		cuser.setCertificate1(view.getTextCertificate1().getText());
		cuser.setCertificate2(view.getTextCertificate2().getText());
		try {
			String s = view.getTextBirthday().getText();
			if (!s.equals("")) {
				cuser.setBirthdate(new SimpleDateFormat("dd/MM/yyyy").parse(s));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cuser.setTransport(view.getTextTransport().getText());
		CandidateDAO.getInstance().update(cuser);
	}

	/**
	 * The constructor
	 * 
	 * @param frame
	 * 
	 */
	public ProfileCtrl() {
		super();
	}

	/**
	 * The constructor for public view (only for candidate)
	 * 
	 * @param publicUser
	 */
	public ProfileCtrl(User publicUser) {
		super(publicUser);
		super.view = new CandidateView() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see fr.redpanda.pander.views.base.ProfileView#isEditable()
			 */
			@Override
			public boolean isEditable() {
				return false;
			}

		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#getView()
	 */
	@Override
	public BaseView getView() {
		if (view == null) {
			if (user instanceof Candidate) {
				view = new CandidateView();
			} else if (user instanceof Company) {
				view = new CompanyView();
			}
		}
		return view;
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
		if (isPublic) {
			view.getNavbar().getTglbtnPublicProfile().setSelected(true);
		} else {
			view.getNavbar().getTglbtnProfile().setSelected(true);
		}
		if (user instanceof Candidate && view instanceof CandidateView) {
			initCandidateView((Candidate) user);
		} else if (user instanceof Company && view instanceof CompanyView) {
			initCompanyView((Company) user);
		}

	}

	/**
	 * The company view initialization
	 * 
	 * @param user
	 */
	private void initCompanyView(User user) {
	}

	/**
	 * The candidate view initialization
	 * 
	 * @param user
	 */
	private void initCandidateView(User user) {
		CandidateView cview = (CandidateView) this.view;
		Candidate cuser = (Candidate) user;
		cview.getTextCertificate1().setText(cuser.getCertificate1());
		cview.getTextCertificate2().setText(cuser.getCertificate2());
		cview.getTextBirthday().setText(DateConverter.getDate(cuser.getBirthdate()));
		cview.getTextTransport().setText(cuser.getTransport());
		List<BaseEntity> skills = SkillDAO.getInstance().get();
		SkillTableModel softSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.SOFT), cuser,
				!isPublic);
		SkillTableModel techSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.TECH), cuser,
				!isPublic);
		cview.getTableSoftSkills().setModel(softSkillsModel);
		cview.getTableSoftSkills().setRowSorter(softSkillsModel.getSorter());
		cview.getTableTechSkills().setModel(techSkillsModel);
		cview.getTableTechSkills().setRowSorter(techSkillsModel.getSorter());
		if (isPublic) {
			cview.getTextBirthday().setEditable(false);
			cview.getTextCertificate1().setEditable(false);
			cview.getTextCertificate2().setEditable(false);
			cview.getTextTransport().setEditable(false);
			cview.getNavbar().getTglbtnPublicProfile().setText(cuser.getFirstname() + " " + cuser.getLastname());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.MainCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		super.initEvent();
		if (view instanceof CandidateView) {
			initCandidateEvent(user);
		} else if (view instanceof CompanyView) {
			initCompanyEvent(user);
		}
	}

}
