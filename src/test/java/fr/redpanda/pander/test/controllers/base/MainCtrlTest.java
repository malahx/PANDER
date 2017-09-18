/**
 * 
 */
package fr.redpanda.pander.test.controllers.base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.redpanda.pander.views.base.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class MainCtrlTest extends BaseCtrlTest {

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.controllers.base.MainCtrl#initView()}.
	 */
	@Test
	public void testInitView() {
		MainView view = (MainView) baseCtrl.getView();
		assertTrue(view.getNavbar().getLblUser().getText().equals("CANDIDAT"));
		assertFalse(view.getNavbar().getTglbtnJob().isVisible());
	}

	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.controllers.base.MainCtrl#initEvent()}.
	// */
	// @Test
	// public void testInitEvent() {
	// fail("Not yet implemented");
	// }

}
