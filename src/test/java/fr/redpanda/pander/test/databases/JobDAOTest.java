/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;
import fr.redpanda.pander.test.databases.base.BaseDAOTest;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class JobDAOTest extends BaseDAOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		entity = new Job("Developpeur");
		Job job = (Job) entity;
		job.getSkills().add(new Skill("Rigoureux1", TypeSkill.SOFT));
		job.getSkills().add(new Skill("Java1", TypeSkill.TECH));
		job.getSkills().add(new Skill("Gestion de projet1", TypeSkill.TECH));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() {
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#insert(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testInsertBaseEntity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#update(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#delete(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testDeleteBaseEntity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.JobDAO#delete()}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * {@link fr.redpanda.pander.databases.JobDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceEquals() {
		assertEquals(JobDAO.getInstance(), JobDAO.getInstance());
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.JobDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull(JobDAO.getInstance());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#parse(java.sql.ResultSet)}.
	 */
	@Test
	public void testParseResultSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#parse(fr.redpanda.pander.entities.Job, fr.redpanda.pander.entities.Company)}.
	 */
	@Test
	public void testParseJobCompany() {
		Job job = (Job) entity;
		String result = "'" + job.getName() + "','','','',NULL,NULL,0";
		assertEquals(JobDAO.getInstance().parse(job, new Company()), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#insert(fr.redpanda.pander.entities.Job, fr.redpanda.pander.entities.Company)}.
	 */
	@Test
	public void testInsertJobCompany() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#get(fr.redpanda.pander.entities.Company)}.
	 */
	@Test
	public void testGetCompany() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#parseUpdate(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseUpdate() {
		Job job = (Job) entity;
		String result = "name = '" + job.getName()
				+ "',presentation = '',link = '',contact = '',created_at = NULL,updated_at = NULL";
		assertEquals(JobDAO.getInstance().parseUpdate(entity), result);
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.JobDAO#fields()}.
	 */
	@Test
	public void testFields() {
		String result = "name,presentation,link,contact,created_at,updated_at,id_company";
		assertEquals(JobDAO.getInstance().fields(), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckFieldsTrue() {
		assertTrue(JobDAO.getInstance().checkFields(entity));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckFieldsFalse() {
		assertTrue(JobDAO.getInstance().checkFields(new Job()));
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#parse(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testParseBaseEntity() {
		JobDAO.getInstance().parse(entity);
		fail();
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#getSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testGetSkills() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#insertSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testInsertSkills() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.JobDAO#deleteSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testDeleteSkillsIBaseSkillEntity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.JobDAO#deleteSkills()}.
	 */
	@Test
	public void testDeleteSkills() {
		fail("Not yet implemented");
	}

}
