package fr.redpanda.pander.managers;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.redpanda.pander.controllers.AuthCtrl;
import fr.redpanda.pander.controllers.base.BaseCtrl;
import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * 
 * @author Gwénolé LE HENAFF
 *
 */
public class ViewsManager {

	private static ViewsManager instance = null;

	/**
	 * 
	 * @return the instance
	 */
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

	/**
	 * @return the currentController
	 */
	public BaseCtrl getCurrentController() {
		return currentController;
	}

	/**
	 * Start the application
	 */
	public void start() {
		System.setProperty("file.encoding", "UTF-8");
		ViewUtils.configure(frame);
		controllers = new ArrayList<BaseCtrl>();
		currentControllerIndex = -1;
		loadController(new AuthCtrl());
	}

	/**
	 * Add a new controller
	 * 
	 * @param controller
	 * @return
	 */
	public ViewsManager add(BaseCtrl controller) {
		this.controllers.add(controller);
		return this;
	}

	/**
	 * Switch to a new controller
	 * 
	 * @param controller
	 * @return
	 */
	public ViewsManager next(BaseCtrl controller) {
		controller.setViewDatas(controllers.get(currentControllerIndex).getViewDatas());
		loadController(controller);
		return this;
	}

	/**
	 * Load the controller
	 * 
	 * @param controller
	 */
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

	/**
	 * The constructor
	 */
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
