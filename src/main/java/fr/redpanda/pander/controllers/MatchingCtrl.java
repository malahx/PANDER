/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.redpanda.pander.businesscode.Matching;
import fr.redpanda.pander.businesscode.MatchingFinder;
import fr.redpanda.pander.controllers.base.MainCtrl;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.MatchingView;
import fr.redpanda.pander.views.models.MatchingTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingCtrl extends MainCtrl {

	private MatchingFinder mFinder;
	private MatchingTableModel model;

	/**
	 * 
	 */
	public MatchingCtrl(JFrame frame) {
		super();
		super.frame = frame;
		super.view = new MatchingView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#setupDatas()
	 */
	@Override
	public void setupDatas() {
		super.setupDatas();

		if (!getViewDatas().containsKey(TypeData.MATCHING_FINDER)) {
			mFinder = new MatchingFinder(user);
			getViewDatas().put(TypeData.MATCHING_FINDER, mFinder);
			mFinder.findBestResult();
		} else {
			mFinder = (MatchingFinder) getViewDatas().get(TypeData.MATCHING_FINDER);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		MatchingView view = (MatchingView) this.view;
		view.getNavbar().getTglbtnMatching().setSelected(true);
		String[] title = user instanceof Candidate ? new String[] { "Match", "Nom", "Email", "Poste" }
				: new String[] { "Match", "Prénom", "Nom", "Email", "Poste" };
		model = new MatchingTableModel(title, mFinder.getMatchingsDone(), user instanceof Candidate);
		view.getTblMatching().setModel(model);
		view.getTblMatching().setRowSorter(model.getSorter());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.MainCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		super.initEvent();
		MatchingView view = (MatchingView) this.view;
		view.getBtnMatching().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Matching> matchings = mFinder.findBestResult();
				for (Matching matching : matchings) {
					model.add(matching);
				}

			}
		});
		ListSelectionModel selectionModel = view.getTblMatching().getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				JTable table = view.getTblMatching();
				int row = table.getSelectedRow();
				if (e.getValueIsAdjusting() || view.getTblMatching().getSelectedRow() == -1) {
					return;
				}
				User publicUser;
				if (user instanceof Candidate) {
					publicUser = ((Matching) table.getValueAt(row, -1)).getCompany();
				} else {
					publicUser = ((Matching) table.getValueAt(row, -1)).getCandidate();
				}
				gotoProfile(publicUser);
			}
		});
	}

}
