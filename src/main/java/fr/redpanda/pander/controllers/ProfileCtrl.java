/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.database.CandidateDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
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
			CandidateView cview = (CandidateView) this.view;
			Candidate cuser = (Candidate) user;
			cview.getTextCertificate1().setText(cuser.getCertificate1());
			cview.getTextCertificate2().setText(cuser.getCertificate2());
			cview.getTextBirthday().setText(DateConverter.getDate(cuser.getBirthdate()));
			cview.getTextTransport().setText(cuser.getTransport());
		} else if (user instanceof Company && view instanceof CompanyView) {
			CompanyView cview = (CompanyView) this.view;
			Company cuser = (Company) user;
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
		DocListener updateProfile = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				updateUser();
			}
		};
		if (view instanceof CandidateView) {
			CandidateView cview = (CandidateView) this.view;
			cview.getTextCertificate1().getDocument().addDocumentListener(updateProfile);
			cview.getTextCertificate2().getDocument().addDocumentListener(updateProfile);
			cview.getTextBirthday().getDocument().addDocumentListener(updateProfile);
			cview.getTextTransport().getDocument().addDocumentListener(updateProfile);
		} else if (view instanceof CompanyView) {
			CompanyView cview = (CompanyView) this.view;
		}
	}

	private void updateUser() {
		User user = (User) getViewDatas().get(TypeData.USER);
		if (user instanceof Candidate && view instanceof CandidateView) {
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
		} else if (user instanceof Company && view instanceof CompanyView) {
			CompanyView view = (CompanyView) this.view;
			Company cuser = (Company) user;
		}

	}

}
