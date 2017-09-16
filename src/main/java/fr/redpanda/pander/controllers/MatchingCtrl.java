/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

	private User user;
	private MatchingFinder mFinder;
	private MatchingTableModel model;

	/**
	 * The constructor
	 */
	public MatchingCtrl() {
		super();
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

		user = (User) getViewDatas().get(TypeData.USER);
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
	}

}
