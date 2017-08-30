/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.entities.User;
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
	 * 
	 */
	public AdminCtrl(JFrame frame) {
		super.frame = frame;
		super.view = new AdminView(this.frame);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		AdminView view = (AdminView) this.view;
		view.getTglbtnUsers().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String[] title = { "Désactiver", "Email", "Mise à jour" };
				view.getLblSubtitle().setText("Utilisateurs");
				view.updateDatas(title, UserDAO.getInstance().findAll());
				view.getTglbtnSkills().setSelected(false);
				view.getBtnBtn1().setText("Générer mot de passe");
				view.getTxtSkill().setText("");
				view.getTxtSkill().setEditable(false);
				view.getBtnBtn1().setEnabled(false);
				view.getLblInfo().setText("Mot de passe généré : ");
				view.getBtnBtn2().setEnabled(false);
			}
		});
		view.getTglbtnSkills().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String[] title = { "Nom", "Type" };
				view.updateDatas(title, new ArrayList<Object>());
				view.getTglbtnUsers().setSelected(false);
				view.getBtnBtn1().setText("Ajouter compétence");
				view.getTxtSkill().setText("");
				view.getTxtSkill().setEditable(true);
				view.getBtnBtn1().setEnabled(false);
				view.getLblSubtitle().setText("Compétences");
				view.getLblInfo().setText("Nouvelle compétence : ");
				view.getBtnBtn2().setEnabled(false);
			}
		});
		view.getBtnBtn1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTglbtnUsers().isSelected()) {
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
				if (view.getTglbtnSkills().isSelected()) {
					String text = view.getTxtSkill().getText();
					if (text.length() > 0) {
						Skill skill = new Skill(text, TypeSkill.TECH);
						//SkillDAO.getInstance().create(skill);
						AdminTableModel model = (AdminTableModel) view.getTblTable().getModel();
						model.getObjects().add(skill);
						model.fireTableDataChanged();
					}
				}
			}
		});

		view.getBtnBtn2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = view.getTblTable().getSelectedRow();
				if (selectedRow >= 0) {
					AdminTableModel model = (AdminTableModel) view.getTblTable().getModel();
					Object object = model.getObjects().get(selectedRow);
					if (object instanceof User) {
						UserDAO.getInstance().delete((User) object);
						view.getBtnBtn1().setEnabled(false);
					}
					if (object instanceof Skill) {
						// SkillDAO.getInstance().delete((Skill) object);
					}
					model.getObjects().remove(selectedRow);
					model.fireTableDataChanged();
				}
				view.getBtnBtn2().setEnabled(false);

			}
		});
		view.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		view.getTxtSkill().getDocument().addDocumentListener(new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				view.getBtnBtn1().setEnabled(view.getTxtSkill().getText().length() > 0 ? true : false);
			}

		});
		view.getTblTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting()) {
					return;
				}
				view.getBtnBtn2().setEnabled(true);
				if (view.getTglbtnUsers().isSelected()) {
					view.getBtnBtn1().setEnabled(true);
				}
			}
		});
		view.getTglbtnUsers().doClick();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#setupDatas()
	 */
	@Override
	public void setupDatas() {
	}

}
