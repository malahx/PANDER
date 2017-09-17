/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import fr.redpanda.pander.controllers.base.PublicProfileCtrl;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.Utils;
import fr.redpanda.pander.views.JobView;
import fr.redpanda.pander.views.models.DocListener;
import fr.redpanda.pander.views.models.JobListModel;
import fr.redpanda.pander.views.models.SkillTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class JobCtrl extends PublicProfileCtrl {

	private boolean inLoading;
	private Job nextJob;

	/**
	 * 
	 */
	public JobCtrl() {
		super();
		super.view = new JobView();
	}

	/**
	 * @param publicUser
	 */
	public JobCtrl(User publicUser) {
		super(publicUser);
		super.view = new JobView();
	}

	protected void jobDelete(JobView cview) {
		if (!cview.getLstJob().isSelectionEmpty()) {
			Job job = cview.getLstJob().getSelectedValue();
			((JobListModel) cview.getLstJob().getModel()).remove(job);
			JobDAO.getInstance().delete(job);
			resetJob(cview);
		}
	}

	protected void jobListSelection(JobView cview) {
		cview.getBtnDelete().setEnabled(!cview.getLstJob().isSelectionEmpty());
		if (!cview.getLstJob().isSelectionEmpty()) {
			Job job = cview.getLstJob().getSelectedValue();
			loadJob(job, cview);
		}
	}

	/**
	 * @param cview
	 */
	protected void updateJob(JobView cview) {
		if (cview.getLstJob().isSelectionEmpty() || inLoading) {
			return;
		}
		JobDAO.getInstance().update(parse(cview.getLstJob().getSelectedValue(), cview));
		((JobListModel) cview.getLstJob().getModel()).refresh();
	}

	private void loadJob(Job job, JobView view) {
		inLoading = true;
		view.getTxtName().setText(job.getName());
		view.getTxtContact().setText(job.getContact());
		view.getTxtLink().setText(job.getLink());
		view.getTxtInfos().setText(job.getPresentation());
		((SkillTableModel) view.getTblSoftSkills().getModel()).setEntity(job);
		((SkillTableModel) view.getTblTechSkills().getModel()).setEntity(job);
		inLoading = false;
	}

	private Job parse(Job job, JobView view) {
		job.setName(view.getTxtName().getText());
		job.setLink(view.getTxtLink().getText());
		job.setPresentation(view.getTxtInfos().getText());
		job.setContact(view.getTxtContact().getText());
		return job;
	}

	private void resetJob(JobView view) {
		view.getLstJob().clearSelection();
		view.getTxtContact().setText("");
		view.getTxtInfos().setText("");
		view.getTxtLink().setText("");
		view.getTxtName().setText("");
		nextJob = new Job();
		((SkillTableModel) view.getTblSoftSkills().getModel()).setEntity(nextJob);
		((SkillTableModel) view.getTblTechSkills().getModel()).setEntity(nextJob);
	}

	/**
	 * 
	 */
	private void initSkills(JobView view) {
		List<BaseEntity> skills = SkillDAO.getInstance().get();
		SkillTableModel softSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.SOFT), nextJob,
				!isPublic);
		SkillTableModel techSkillsModel = new SkillTableModel(Utils.getSkillsType(skills, TypeSkill.TECH), nextJob,
				!isPublic);
		view.getTblSoftSkills().setModel(softSkillsModel);
		view.getTblSoftSkills().setRowSorter(softSkillsModel.getSorter());
		view.getTblTechSkills().setModel(techSkillsModel);
		view.getTblTechSkills().setRowSorter(techSkillsModel.getSorter());
		view.getTblSoftSkills().getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (view.getLstJob().isSelectionEmpty()) {
					return;
				}
				JobDAO.getInstance().insertSkills(view.getLstJob().getSelectedValue());
			}
		});

		view.getTblTechSkills().getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (view.getLstJob().isSelectionEmpty()) {
					return;
				}
				JobDAO.getInstance().insertSkills(view.getLstJob().getSelectedValue());
			}
		});
	}

	private void jobAdd(JobView view, Company user) {

		if (view.getTxtName().getText().equals("")) {
			return;
		}
		Job job = parse(nextJob, view);
		JobDAO.getInstance().insert(job, user);
		JobDAO.getInstance().insertSkills(job);
		((JobListModel) view.getLstJob().getModel()).add(job);
		resetJob(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.MainCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		JobView cview = (JobView) this.view;
		Company cuser = (Company) user;
		cview.getLstJob().setModel(new JobListModel(cuser));
		nextJob = new Job();
		initSkills(cview);
		if (isPublic) {
			cview.getPnlButton().setEnabled(false);
			cview.getPnlButton().setVisible(false);
			cview.getBtnDelete().setEnabled(false);
			cview.getBtnDelete().setVisible(false);
			cview.getTxtContact().setEditable(false);
			cview.getTxtInfos().setEditable(false);
			cview.getTxtLink().setEditable(false);
			cview.getTxtName().setEditable(false);
			cview.getNavbar().getTglbtnPublicProfile().setText(cuser.getName());
		} else {
			cview.getNavbar().getTglbtnJob().setSelected(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.MainCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		super.initEvent();
		JobView cview = (JobView) this.view;
		Company cuser = (Company) user;

		DocListener updateJob = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				updateJob(cview);
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
				jobListSelection(cview);
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
				jobDelete(cview);

			}
		});

		cview.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jobAdd(cview, cuser);
			}
		});
	}
}
