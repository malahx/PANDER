package fr.redpanda.pander.controllers.base;

import javax.swing.JFrame;

public interface IBaseCtrl {

	/**
	 * The load controller
	 * 
	 * @param frame
	 *            the frame to attache the view
	 * @return the controller loaded
	 */
	public BaseCtrl loadController(JFrame frame);

	/**
	 * Initialization of the events
	 */
	public void initEvent();

	/**
	 * Initialization of the view
	 */
	public void initView();

	/**
	 * Initialization of the datas
	 */
	public void setupDatas();

}
