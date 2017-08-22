package fr.redpanda.pander.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	@Override
	public void loadView(JFrame frame) {
		frame.setTitle("PANDER : "  + getPageName());
		ViewUtils.configure(frame, getContentPane());
	}
}
