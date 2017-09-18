/**
 * 
 */
package fr.redpanda.pander.test.controllers;

import org.junit.After;
import org.junit.Before;

import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.test.controllers.base.BaseCtrlTest;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AuthCtrlTest extends BaseCtrlTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ViewsManager.getInstance().start();
		baseCtrl = ViewsManager.getInstance().getCurrentController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	// /**
	// * Test method for {@link fr.redpanda.pander.controllers.AuthCtrl#login()}.
	// */
	// @Test
	// public void testLogin() {
	// DAOManager.getInstance().execute("INSERT INTO " + UserDAO.TABLE + " (" +
	// UserDAO.getInstance().fields() + ") VALUES (" +
	// UserDAO.getInstance().parse(candidate) + ")");
	// fail("Not yet implemented");
	// }

	// /**
	// * Test method for {@link fr.redpanda.pander.controllers.AuthCtrl#initView()}.
	// */
	// @Test
	// public void testInitView() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for {@link
	// fr.redpanda.pander.controllers.AuthCtrl#initEvent()}.
	// */
	// @Test
	// public void testInitEvent() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.controllers.AuthCtrl#AuthCtrl(javax.swing.JFrame)}.
	// */
	// @Test
	// public void testAuthCtrl() {
	// assertbaseCtrl.getFrame()
	// fail("Not yet implemented");
	// }

}
