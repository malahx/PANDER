package fr.redpanda.pander.managers;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.redpanda.pander.controllers.AuthCtrl;
import fr.redpanda.pander.controllers.BaseCtrl;
import fr.redpanda.pander.utils.views.ViewUtils;

public class ViewsManager {

	private static ViewsManager instance = null;

	public static ViewsManager getInstance() {
		if (instance == null) {
			instance = new ViewsManager();
		}
		return instance;
	}

	private JFrame frame;
	private List<BaseCtrl> controllers;
	private int currentControllerIndex;
	private BaseCtrl currentController;

	public void start() {
		ViewUtils.configure(frame);
		controllers = new ArrayList<BaseCtrl>();
		currentControllerIndex = -1;
		loadController(new AuthCtrl(frame));
	}

	public ViewsManager add(BaseCtrl controller) {
		this.controllers.add(controller);
		return this;
	}

	public ViewsManager next(BaseCtrl controller) {
		controller.setViewDatas(controllers.get(currentControllerIndex).getViewDatas());
		loadController(controller);
		return this;
	}

	private void loadController(BaseCtrl controller) {
		currentController = controller;
		this.controllers.add(currentController);
		currentControllerIndex++;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controllers.get(currentControllerIndex).loadController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	protected ViewsManager() {
		this.frame = new JFrame();
		controllers = new ArrayList<BaseCtrl>();
		currentControllerIndex = -1;
	}

	/**
	 * @param clazz
	 *            the controller to test
	 * @return if the controller is instance of clazz
	 */
	public boolean isCurrentController(Class<?> clazz) {
		return clazz.isInstance(controllers.get(currentControllerIndex));
	}
}
