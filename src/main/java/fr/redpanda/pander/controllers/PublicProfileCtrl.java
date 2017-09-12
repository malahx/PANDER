/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.util.List;

import javax.swing.JFrame;

import fr.redpanda.pander.controllers.base.MainCtrl;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.Utils;
import fr.redpanda.pander.utils.date.DateConverter;
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.CandidateView;
import fr.redpanda.pander.views.CompanyView;
import fr.redpanda.pander.views.JobView;
import fr.redpanda.pander.views.base.BaseView;
import fr.redpanda.pander.views.base.MainView;
import fr.redpanda.pander.views.models.SkillTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class PublicProfileCtrl extends MainCtrl {

	private User publicUser;

	/**
	 * @param frame
	 * 
	 */
	public PublicProfileCtrl(JFrame frame, User publicUser) {
		super();
		super.frame = frame;
		this.publicUser = publicUser;
	}

	private void initCompanyView(Company cuser) {
		CompanyView cview = (CompanyView) this.view;
		cview.getNavbar().getTglbtnPublicProfile().setText(cuser.getName());
		cview.getSidebar().initCompany((Company) cuser);
	}

	private void initCandidateView(Candidate cuser) {
		CandidateView cview = (CandidateView) this.view;
		cview.getSidebar().initCandidate((Candidate) cuser);
		cview.getNavbar().getTglbtnPublicProfile().setText(cuser.getFirstname() + " " + cuser.getLastname());
		cview.getTextCertificate1().setText(cuser.getCertificate1());
		cview.getTextCertificate2().setText(cuser.getCertificate2());
		cview.getTextBirthday().setText(DateConverter.getDate(cuser.getBirthdate()));
		cview.getTextTransport().setText(cuser.getTransport());
		List<BaseEntity> skills = SkillDAO.getInstance().get();
		SkillTableModel softSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.SOFT), cuser,
				false);
		SkillTableModel techSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.TECH), cuser,
				false);
		cview.getTableSoftSkills().setModel(softSkillsModel);
		cview.getTableSoftSkills().setRowSorter(softSkillsModel.getSorter());
		cview.getTableTechSkills().setModel(techSkillsModel);
		cview.getTableTechSkills().setRowSorter(techSkillsModel.getSorter());
		cview.getTextBirthday().setEditable(false);
		cview.getTextCertificate1().setEditable(false);
		cview.getTextCertificate2().setEditable(false);
		cview.getTextTransport().setEditable(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#getView()
	 */
	@Override
	public BaseView getView() {
		if (view == null) {
			if (publicUser instanceof Candidate) {
				view = new CandidateView() {

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
			} else if (publicUser instanceof Company) {
				view = new JobView() {

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
		view.getNavbar().getTglbtnPublicProfile().setSelected(true);
		view.getNavbar().getTglbtnPublicProfile().setVisible(true);
		if (publicUser instanceof Candidate && view instanceof CandidateView) {
			initCandidateView((Candidate) publicUser);
		} else if (publicUser instanceof Company && view instanceof CompanyView) {
			initCompanyView((Company) publicUser);
		}

		ViewUtils.colorLight(view.getSidebar());
		ViewUtils.colorLight(view.getFooter());
		ViewUtils.colorDark(view.getFooter().getBtnExit());
		ViewUtils.colorDark(view.getFooter().getBtnLogout());
		ViewUtils.colorTextWhite(view.getFooter().getBtnExit());
		ViewUtils.colorTextWhite(view.getFooter().getBtnLogout());

	}

}
