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

import fr.redpanda.pander.controllers.base.BaseCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;
import fr.redpanda.pander.utils.StringManager;
import fr.redpanda.pander.views.AdminView;
import fr.redpanda.pander.views.models.AdminTableModel;
import fr.redpanda.pander.views.models.DocListener;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AdminCtrl extends BaseCtrl {

	/**
	 * The constructor
	 * 
	 * @param frame
	 */
	public AdminCtrl() {
		super();
		super.view = new AdminView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		AdminView view = (AdminView) this.view;
		initBtnHeader(view);
		initEdit(view);
		view.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		view.getTblTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting()) {
					return;
				}
				refreshButton(view);
			}
		});
		view.getTglbtnUsers().doClick();
	}

	/**
	 * Initialization of the edit events
	 * 
	 * @param view
	 */
	private void initEdit(AdminView view) {
		view.getBtnBtn1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTglbtnUsers().isSelected()) {
					generatePassword(view);
				}
				if (view.getTglbtnSkills().isSelected()) {
					addTechSkill(view);
				}
			}
		});

		view.getBtnBtn2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRow(view);
			}
		});

		view.getTxtSkill().getDocument().addDocumentListener(new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				view.getBtnBtn1().setEnabled(view.getTxtSkill().getText().length() > 0 ? true : false);
			}

		});
	}

	/**
	 * The initialization of the button events
	 * 
	 * @param view
	 */
	private void initBtnHeader(AdminView view) {
		view.getTglbtnUsers().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initUser(view);
			}
		});
		view.getTglbtnSkills().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initSkill(view);
			}
		});
	}

	/**
	 * The refresh of the button enable/disable
	 * 
	 * @param view
	 */
	protected void refreshButton(AdminView view) {
		view.getBtnBtn2().setEnabled(true);
		if (view.getTglbtnUsers().isSelected()) {
			view.getBtnBtn1().setEnabled(true);
		}
	}

	/**
	 * The function to delete a row from a table model
	 * 
	 * @param view
	 */
	protected void deleteRow(AdminView view) {
		int selectedRow = view.getTblTable().getSelectedRow();
		if (selectedRow >= 0) {
			AdminTableModel model = (AdminTableModel) view.getTblTable().getModel();
			Object object = model.getObjects().get(selectedRow);
			if (object instanceof User) {
				if (object instanceof Candidate) {
					Candidate candidate = (Candidate) object;
					CandidateDAO.getInstance().delete(candidate);
				} else if (object instanceof Company) {
					Company company = (Company) object;
					CompanyDAO.getInstance().delete(company);
				} else {
					UserDAO.getInstance().delete((User) object);
				}
				view.getBtnBtn1().setEnabled(false);
			}
			if (object instanceof Skill) {
				SkillDAO.getInstance().delete((Skill) object);
			}
			model.getObjects().remove(selectedRow);
			model.fireTableDataChanged();
		}
		view.getBtnBtn2().setEnabled(false);
	}

	/**
	 * The function to add a tech skill
	 * 
	 * @param view
	 */
	protected void addTechSkill(AdminView view) {
		String text = view.getTxtSkill().getText();
		if (text.length() > 0) {
			Skill skill = new Skill(text, TypeSkill.TECH);
			SkillDAO.getInstance().insert(skill);
			AdminTableModel model = (AdminTableModel) view.getTblTable().getModel();
			model.getObjects().add(skill);
			model.fireTableDataChanged();
		}
	}

	/**
	 * the password generation
	 * 
	 * @param view
	 */
	protected void generatePassword(AdminView view) {
		int selectedRow = view.getTblTable().getSelectedRow();
		if (selectedRow >= 0) {
			AdminTableModel model = (AdminTableModel) view.getTblTable().getModel();
			Object object = model.getObjects().get(selectedRow);
			if (object instanceof User) {
				User user = (User) object;
				String password = StringManager.createString();
				user.setPassword(password);
				view.getTxtSkill().setText(password);
				UserDAO.getInstance().update(user);
				model.fireTableDataChanged();
				view.getTblTable().setRowSelectionInterval(selectedRow, selectedRow);
			}
		}
	}

	/**
	 * The function to init the skill datas from the table
	 * 
	 * @param view
	 */
	protected void initSkill(AdminView view) {
		String[] title = { "Nom", "Type" };
		view.updateDatas(title, SkillDAO.getInstance().get());
		view.getTglbtnUsers().setSelected(false);
		view.getBtnBtn1().setText("Ajouter compétence");
		view.getTxtSkill().setText("");
		view.getTxtSkill().setEditable(true);
		view.getBtnBtn1().setEnabled(false);
		view.getLblSubtitle().setText("Compétences");
		view.getLblInfo().setText("Nouvelle compétence : ");
		view.getBtnBtn2().setEnabled(false);
	}

	/**
	 * The function to init the users datas from the table
	 * 
	 * @param view
	 */
	private void initUser(AdminView view) {
		String[] title = { "Email", "Mise à jour" };
		view.getLblSubtitle().setText("Utilisateurs");
		List<BaseEntity> users = UserDAO.getInstance().get();
		for (BaseEntity user : users) {
			if (user instanceof Candidate) {
				CandidateDAO.getInstance().getSkills((IBaseSkillEntity) user);
			} else if (user instanceof Company) {
				Company company = JobDAO.getInstance().get((Company) user);
				for (Job job : company.getJobs()) {
					JobDAO.getInstance().getSkills(job);
				}
			}
		}
		view.updateDatas(title, users);
		view.getTglbtnSkills().setSelected(false);
		view.getBtnBtn1().setText("Générer mot de passe");
		view.getTxtSkill().setText("");
		view.getTxtSkill().setEditable(false);
		view.getBtnBtn1().setEnabled(false);
		view.getLblInfo().setText("Mot de passe généré : ");
		view.getBtnBtn2().setEnabled(false);
	}

}
