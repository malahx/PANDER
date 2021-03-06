package fr.redpanda.pander.views.base;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.redpanda.pander.utils.constant.Version;
import fr.redpanda.pander.utils.views.ViewUtils;

public abstract class BaseView implements IBaseView {

	protected JPanel contentPane;
	protected String pageName;

	/**
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.base.IBaseView#loadView(javax.swing.JFrame)
	 */
	@Override
	public void loadView(JFrame frame) {
		frame.setTitle("PANDER v" + Version.CURRENT + " : " + getPageName());
		ViewUtils.configure(frame, getContentPane());
	}
}
