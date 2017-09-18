/**
 * 
 */
package fr.redpanda.pander.test.views;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.redpanda.pander.test.views.base.BaseViewTest;
import fr.redpanda.pander.views.AdminView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AdminViewTest extends BaseViewTest {

	private AdminView view;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		view = new AdminView();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminView() {
		assertNotNull(view.getContentPane());
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewLblTitle() {
		assertTrue(contains(view.getContentPane(), view.getLblTitle()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewTglbtnUsers() {
		assertTrue(contains(view.getContentPane(), view.getTglbtnUsers()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewTglbtnSkills() {
		assertTrue(contains(view.getContentPane(), view.getTglbtnSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewLblSubtitle() {
		assertTrue(contains(view.getContentPane(), view.getLblSubtitle()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewScrlTable() {
		assertTrue(contains(view.getContentPane(), view.getScrlTable()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewPnlCopyright() {
		assertTrue(contains(view.getContentPane(), view.getPnlCopyright()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewLblInfo() {
		assertTrue(contains(view.getPnlCopyright(), view.getLblInfo()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewPnlButton() {
		assertTrue(contains(view.getContentPane(), view.getPnlButton()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewTxtSkill() {
		assertTrue(contains(view.getPnlButton(), view.getTxtSkill()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewBtnBtn1() {
		assertTrue(contains(view.getPnlButton(), view.getBtnBtn1()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewBtnBtn2() {
		assertTrue(contains(view.getPnlButton(), view.getBtnBtn2()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewLblCopyright() {
		assertTrue(contains(view.getContentPane(), view.getLblCopyright()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.AdminView#AdminView()}.
	 */
	@Test
	public void testAdminViewBtnExit() {
		assertTrue(contains(view.getContentPane(), view.getBtnExit()));
	}

}
