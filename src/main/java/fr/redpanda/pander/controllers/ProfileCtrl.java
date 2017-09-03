/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import fr.redpanda.pander.controllers.base.MainCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.Utils;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.utils.date.DateConverter;
import fr.redpanda.pander.views.CandidateView;
import fr.redpanda.pander.views.CompanyView;
import fr.redpanda.pander.views.base.BaseView;
import fr.redpanda.pander.views.base.MainView;
import fr.redpanda.pander.views.models.DocListener;
import fr.redpanda.pander.views.models.JobListModel;
import fr.redpanda.pander.views.models.SkillTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ProfileCtrl extends MainCtrl {

	private boolean inLoading;

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
		CompanyView cview = (CompanyView) this.view;
		Company cuser = (Company) user;
		cview.getLstJob().setModel(new JobListModel(cuser));
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
		SkillTableModel softSkillsModel = new SkillTableModel(title, Utils.getSkillsType(skills, TypeSkill.SOFT),
				cuser);
		SkillTableModel techSkillsModel = new SkillTableModel(title, Utils.getSkillsType(skills, TypeSkill.TECH),
				cuser);
		cview.getTableSoftSkills().setModel(softSkillsModel);
		cview.getTableSoftSkills().setRowSorter(softSkillsModel.getSorter());
		cview.getTableTechSkills().setModel(techSkillsModel);
		cview.getTableTechSkills().setRowSorter(techSkillsModel.getSorter());

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
		if (view instanceof CandidateView) {
			initCandidateEvent(user);
		} else if (view instanceof CompanyView) {
			initCompanyEvent(user);
		}
	}

	private void initCompanyEvent(User user) {
		CompanyView cview = (CompanyView) this.view;
		Company cuser = (Company) user;
		List<BaseEntity> skills = SkillDAO.getInstance().get();

		DocListener updateJob = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				if (cview.getLstJob().isSelectionEmpty() || inLoading) {
					return;
				}
				JobDAO.getInstance().update(parse(cview.getLstJob().getSelectedValue(), cview));
				((JobListModel) cview.getLstJob().getModel()).refresh();
			}
		};

		cview.getTxtName().getDocument().addDocumentListener(updateJob);
		cview.getTxtContact().getDocument().addDocumentListener(updateJob);
		cview.getTxtInfos().getDocument().addDocumentListener(updateJob);
		cview.getTxtLink().getDocument().addDocumentListener(updateJob);

		cview.getTxtName().getDocument().addDocumentListener(new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				cview.getBtnAdd().setEnabled(!cview.getTxtName().getText().equals(""));
			}
		});

		cview.getLstJob().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}
				cview.getBtnDelete().setEnabled(!cview.getLstJob().isSelectionEmpty());
				if (!cview.getLstJob().isSelectionEmpty()) {
					Job job = cview.getLstJob().getSelectedValue();
					loadJob(job, cview);

					String[] title = { "Activer", "Compétence" };
					SkillTableModel softSkillsModel = new SkillTableModel(title,
							Utils.getSkillsType(skills, TypeSkill.SOFT), job);
					SkillTableModel techSkillsModel = new SkillTableModel(title,
							Utils.getSkillsType(skills, TypeSkill.TECH), job);
					cview.getTblSoftSkills().setModel(softSkillsModel);
					cview.getTblSoftSkills().setRowSorter(softSkillsModel.getSorter());
					cview.getTblTechSkills().setModel(techSkillsModel);
					cview.getTblTechSkills().setRowSorter(techSkillsModel.getSorter());

					cview.getTblSoftSkills().getModel().addTableModelListener(new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent e) {
							JobDAO.getInstance().insertSkills(cview.getLstJob().getSelectedValue());
						}
					});

					cview.getTblTechSkills().getModel().addTableModelListener(new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent e) {
							JobDAO.getInstance().insertSkills(cview.getLstJob().getSelectedValue());
						}
					});
				}
			}
		});

		cview.getBtnClear().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetJob(cview);
			}
		});

		cview.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!cview.getLstJob().isSelectionEmpty()) {
					Job job = cview.getLstJob().getSelectedValue();
					((JobListModel) cview.getLstJob().getModel()).remove(job);
					JobDAO.getInstance().delete(job);
					resetJob(cview);
				}

			}
		});

		cview.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cview.getTxtName().getText().equals("")) {
					return;
				}
				Job job = parse(new Job(), cview);
				JobDAO.getInstance().insert(job, cuser);
				((JobListModel) cview.getLstJob().getModel()).add(job);
				resetJob(cview);
			}
		});
	}

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

	private void loadJob(Job job, CompanyView view) {
		inLoading = true;
		view.getTxtName().setText(job.getName());
		view.getTxtContact().setText(job.getContact());
		view.getTxtLink().setText(job.getLink());
		view.getTxtInfos().setText(job.getPresentation());
		inLoading = false;
	}

	private Job parse(Job job, CompanyView view) {
		job.setName(view.getTxtName().getText());
		job.setLink(view.getTxtLink().getText());
		job.setPresentation(view.getTxtInfos().getText());
		job.setContact(view.getTxtContact().getText());
		return job;
	}

	private void resetJob(CompanyView view) {
		view.getLstJob().clearSelection();
		view.getTxtContact().setText("");
		view.getTxtInfos().setText("");
		view.getTxtLink().setText("");
		view.getTxtName().setText("");
		view.getTblSoftSkills().setModel(new DefaultTableModel());
		view.getTblTechSkills().setModel(new DefaultTableModel());
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
