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
import fr.redpanda.pander.views.JobView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class JobViewTest extends BaseViewTest {

	private JobView view;

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
		view = new JobView();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobView() {
		assertNotNull(view.getContentPane());
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetBtnAdd() {
		assertTrue(contains(view.getContentPane(), view.getBtnAdd()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetBtnClear() {
		assertTrue(contains(view.getContentPane(), view.getBtnClear()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetBtnDelete() {
		assertTrue(contains(view.getContentPane(), view.getBtnDelete()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetFooter() {
		assertTrue(contains(view.getContentPane(), view.getFooter()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblContact() {
		assertTrue(contains(view.getContentPane(), view.getLblContact()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblInfos() {
		assertTrue(contains(view.getContentPane(), view.getLblInfos()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblJobList() {
		assertTrue(contains(view.getContentPane(), view.getLblJobList()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblLien() {
		assertTrue(contains(view.getContentPane(), view.getLblLien()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblName() {
		assertTrue(contains(view.getContentPane(), view.getLblName()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLblSoftSkills() {
		assertTrue(contains(view.getContentPane(), view.getLblSoftSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetLstJob() {
		assertTrue(contains(view.getContentPane(), view.getLstJob()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetNavbar() {
		assertTrue(contains(view.getContentPane(), view.getNavbar()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlButton() {
		assertTrue(contains(view.getContentPane(), view.getPnlButton()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlContent() {
		assertTrue(contains(view.getContentPane(), view.getPnlContent()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlJobInfo() {
		assertTrue(contains(view.getContentPane(), view.getPnlJobInfo()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlJobList() {
		assertTrue(contains(view.getContentPane(), view.getPnlJobList()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlSkillList() {
		assertTrue(contains(view.getContentPane(), view.getPnlSkillList()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlSkills() {
		assertTrue(contains(view.getContentPane(), view.getPnlSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlSoftSkills() {
		assertTrue(contains(view.getContentPane(), view.getPnlSoftSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetPnlTechSkills() {
		assertTrue(contains(view.getContentPane(), view.getPnlTechSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetScrPJobList() {
		assertTrue(contains(view.getContentPane(), view.getScrPJobList()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetScrPSoftSkills() {
		assertTrue(contains(view.getContentPane(), view.getScrPSoftSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetScrPTechSkills() {
		assertTrue(contains(view.getContentPane(), view.getScrPTechSkills()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetSidebar() {
		assertTrue(contains(view.getContentPane(), view.getSidebar()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetTxtContact() {
		assertTrue(contains(view.getContentPane(), view.getTxtContact()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetTxtInfos() {
		assertTrue(contains(view.getContentPane(), view.getTxtInfos()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetTxtLink() {
		assertTrue(contains(view.getContentPane(), view.getTxtLink()));
	}

	/**
	 * Test method for {@link fr.redpanda.pander.views.JobView#JobView()}.
	 */
	@Test
	public void testJobViewgetTxtName() {
		assertTrue(contains(view.getContentPane(), view.getTxtName()));
	}

}
