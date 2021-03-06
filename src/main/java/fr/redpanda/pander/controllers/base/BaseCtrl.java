/**
 * 
 */
package fr.redpanda.pander.controllers.base;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import fr.redpanda.pander.views.base.BaseView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseCtrl implements IBaseCtrl {
	protected JFrame frame;
	protected BaseView view;
	protected Map<String, Object> viewDatas = new HashMap<>();

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the view
	 */
	public BaseView getView() {
		return view;
	}

	/**
	 * @param viewDatas
	 *            the viewDatas to set
	 */
	public void setViewDatas(Map<String, Object> viewDatas) {
		this.viewDatas = viewDatas;
	}

	/**
	 * @return the viewDatas
	 */
	public Map<String, Object> getViewDatas() {
		return viewDatas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.controllers.base.IBaseCtrl#loadController(javax.swing.
	 * JFrame)
	 */
	@Override
	public BaseCtrl loadController(JFrame frame) {
		this.frame = frame;
		frame.setVisible(true);
		setupDatas();
		getView().loadView(frame);
		initView();
		initEvent();
		return this;
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
