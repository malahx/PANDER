/**
 * 
 */
package fr.redpanda.pander.controllers.base;

import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.base.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class PublicProfileCtrl extends MainCtrl {

	protected User publicUser;
	
	public PublicProfileCtrl() {
		super();
	}

	/**
	 * @param publicUser
	 */
	public PublicProfileCtrl(User publicUser) {
		super();
		super.isPublic = true;
		super.user = publicUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.IBaseCtrl#initView()
	 */
	@Override
	public void initView() {

		super.initView();
		if (isPublic) {
			MainView view = (MainView) this.view;
			view.getNavbar().getTglbtnPublicProfile().setSelected(true);
			view.getNavbar().getTglbtnPublicProfile().setVisible(true);
			ViewUtils.colorLight(view.getSidebar());
			ViewUtils.colorLight(view.getFooter());
			ViewUtils.colorDark(view.getFooter().getBtnExit());
			ViewUtils.colorDark(view.getFooter().getBtnLogout());
			ViewUtils.colorTextWhite(view.getFooter().getBtnExit());
			ViewUtils.colorTextWhite(view.getFooter().getBtnLogout());
		}

	}
}
