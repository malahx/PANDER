/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import fr.redpanda.pander.controllers.base.MainCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.Utils;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.utils.date.DateConverter;
import fr.redpanda.pander.views.BaseView;
import fr.redpanda.pander.views.CandidateView;
import fr.redpanda.pander.views.CompanyView;
import fr.redpanda.pander.views.MainView;
import fr.redpanda.pander.views.models.DocListener;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ProfileCtrl extends MainCtrl {

	@Override
	public BaseView getView() {
		if (view == null) {
			User user = (User) getViewDatas().get(TypeData.USER);
			if (user instanceof Candidate) {
				view = new CandidateView();
			} else if (user instanceof Company) {
				view = new CompanyView();
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
		User user = (User) getViewDatas().get(TypeData.USER);
		if (user instanceof Candidate && view instanceof CandidateView) {
			initCandidateView(user);
		} else if (user instanceof Company && view instanceof CompanyView) {
			initCompanyView(user);
		}

	}

	private void initCompanyView(User user) {
		updateCompany(user);
	}

	private void initCandidateView(User user) {
		CandidateView cview = (CandidateView) this.view;
		Candidate cuser = (Candidate) user;
		cview.getTextCertificate1().setText(cuser.getCertificate1());
		cview.getTextCertificate2().setText(cuser.getCertificate2());
		cview.getTextBirthday().setText(DateConverter.getDate(cuser.getBirthdate()));
		cview.getTextTransport().setText(cuser.getTransport());
		String[] title = { "Activer", "Compétence" };
		List<BaseEntity> skills = SkillDAO.getInstance().get();
		cview.updateDatas(cview.getTableSoftSkills(), title, Utils.getSkills(skills, TypeSkill.SOFT), cuser);
		cview.updateDatas(cview.getTableTechSkills(), title, Utils.getSkills(skills, TypeSkill.TECH), cuser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.MainCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		super.initEvent();
		User user = (User) getViewDatas().get(TypeData.USER);
		DocListener updateProfile = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				updateUser();
			}
		};
		if (view instanceof CandidateView) {
			initCandidateEvent(user, updateProfile);
		} else if (view instanceof CompanyView) {
			initCompanyEvent(user, updateProfile);
		}
	}

	private void initCompanyEvent(User user, DocListener updateProfile) {
		CompanyView cview = (CompanyView) this.view;
	}

	private void initCandidateEvent(User user, DocListener updateProfile) {
		CandidateView cview = (CandidateView) this.view;
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
	}

	private void updateUser() {
		User user = (User) getViewDatas().get(TypeData.USER);
		if (user instanceof Candidate && view instanceof CandidateView) {
			updateCandidate(user);
		} else if (user instanceof Company && view instanceof CompanyView) {
			updateCompany(user);
		}

	}

	/**
	 * @param user
	 */
	private void updateCompany(User user) {
		CompanyView view = (CompanyView) this.view;
		Company cuser = (Company) user;
	}

	/**
	 * @param user
	 */
	private void updateCandidate(User user) {
		CandidateView view = (CandidateView) this.view;
		Candidate cuser = (Candidate) user;
		cuser.setCertificate1(view.getTextCertificate1().getText());
		cuser.setCertificate2(view.getTextCertificate2().getText());
		try {
			String s = view.getTextBirthday().getText();
			cuser.setBirthdate(!s.equals("") ? new SimpleDateFormat("dd/MM/yyyy").parse(s) : null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cuser.setTransport(view.getTextTransport().getText());
		CandidateDAO.getInstance().update(cuser);
	}

}
