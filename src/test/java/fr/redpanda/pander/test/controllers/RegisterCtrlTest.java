/**
 * 
 */
package fr.redpanda.pander.test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.redpanda.pander.test.controllers.base.BaseCtrlTest;
import fr.redpanda.pander.test.controllers.decorator.RegisterCtrlDecorator;
import fr.redpanda.pander.views.RegisterView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class RegisterCtrlTest extends BaseCtrlTest {

	private JFrame mainFrame;
	private JFrame registerFrame;
	private RegisterView view;
	// AuthCtrl authCtrl;
	// AuthView authView;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		// ViewsManager.getInstance().start();
		// authCtrl = (AuthCtrl) ViewsManager.getInstance().getCurrentController();
		// authView = (AuthView) authCtrl.getView();
		// mainFrame = authCtrl.getFrame();
		// authView.getBtnCompany().doClick();
		// registerCtrl = authCtrl.getRegisterCtrl();
		// registerFrame = registerCtrl.getFrame();
		mainFrame = new JFrame();
		registerFrame = new JFrame();
		baseCtrl = new RegisterCtrlDecorator(mainFrame, registerFrame, company);
		baseCtrl.loadController(registerFrame);
		view = (RegisterView) baseCtrl.getView();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		// mainFrame.dispose();
		// registerFrame.dispose();
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.controllers.RegisterCtrl#initView()}.
	 */
	@Test
	public void testInitView() {
		assertTrue(registerFrame.getWidth() == 400);
		assertTrue(registerFrame.getHeight() == 250);
		assertTrue(registerFrame.getDefaultCloseOperation() == JFrame.DISPOSE_ON_CLOSE);
		assertTrue(registerFrame.isAlwaysOnTop());
		assertTrue(registerFrame.getWindowListeners().length > 0);
		assertEquals(view.getLblName().getText(), "Nom");
		assertEquals(view.getLblOtherName().getText(), "SIRET");
	}

	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.controllers.RegisterCtrl#initEvent()}.
	// */
	// @Test
	// public void testInitEvent() {
	// fail("Not yet implemented");
	// }

	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.controllers.RegisterCtrl#RegisterCtrl(javax.swing.JFrame,
	// javax.swing.JFrame, fr.redpanda.pander.entities.User)}.
	// */
	// @Test
	// public void testRegisterCtrl() {
	// fail("Not yet implemented");
	// }

	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.controllers.RegisterCtrl#register(fr.redpanda.pander.views.RegisterView)}.
	// */
	// @Test
	// public void testRegister() {
	// fail("Not yet implemented");
	// }

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.controllers.RegisterCtrl#refresh(fr.redpanda.pander.views.RegisterView)}.
	 */
	@Test
	public void testRefresh() {
		String string = "test";
		assertFalse(view.getBtnRegister().isEnabled());
		view.getTextName1().setText(string);
		assertFalse(((RegisterCtrlDecorator) baseCtrl).refresh(view));
		view.getTextName2().setText(string);
		assertFalse(((RegisterCtrlDecorator) baseCtrl).refresh(view));
		view.getPwdPass().setText(string);
		assertFalse(((RegisterCtrlDecorator) baseCtrl).refresh(view));
		assertEquals(view.getLblInfo().getText(), "Le mot de passe ne correspond pas.");
		view.getPwdPassVerify().setText(string);
		assertFalse(((RegisterCtrlDecorator) baseCtrl).refresh(view));
		view.getTextEmail().setText(string);
		assertEquals(view.getLblInfo().getText(), "Votre email n'est pas valide.");
		view.getTextEmail().setText("test@test.test");
		assertTrue(((RegisterCtrlDecorator) baseCtrl).refresh(view));
		assertEquals(view.getLblInfo().getText(), "Merci de compléter ces informations.");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.controllers.RegisterCtrl#close()}.
	 */
	@Test
	public void testClose() {
		view.getBtnCancel().doClick();
		assertFalse(registerFrame.isDisplayable());
		assertTrue(mainFrame.isEnabled());
	}

}
