/**
 * 
 */
package fr.redpanda.pander.test.databases.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.TypeSkill;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAOTest extends BaseMysql {

	protected Admin admin;
	protected Candidate candidate;
	protected Company company;
	protected Job job;
	protected Skill skillSoft;
	protected Skill skillTech;
	protected Skill skillOther;

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
	 * Instanciate Objects
	 */
	@Before
	public void setUp() {

		admin = new Admin();
		admin.setEmail("admin@admin.fr");
		admin.setPassword("password");

		candidate = new Candidate();
		candidate.setEmail("candidate@candidate.fr");
		candidate.setPassword("password");
		candidate.setFirstname("firstname");
		candidate.setLastname("lastname");

		company = new Company();
		company.setEmail("company@company.fr");
		company.setPassword("password");
		company.setName("name");
		company.setSiret("1234567891011");

		job = new Job();
		job.setName("Developpeur");

		skillSoft = new Skill("Rigoureux1", TypeSkill.SOFT);
		skillTech = new Skill("Java1", TypeSkill.TECH);
		skillOther = new Skill("Gestion de projet1", TypeSkill.TECH);

		List<Skill> skills = new ArrayList<>();
		skills.add(skillSoft);
		skills.add(skillTech);
		skills.add(skillOther);

		job.getSkills().addAll(skills);
		candidate.getSkills().addAll(skills);

		company.getJobs().add(job);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#getTable()}.
//	 */
//	@Test
//	public void testGetTable() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#getId()}.
//	 */
//	@Test
//	public void testGetId() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#BaseDAO(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testBaseDAO() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#executeQuery(java.lang.String)}.
//	 */
//	@Test
//	public void testExecuteQuery() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#executePrepare(fr.redpanda.pander.entities.base.BaseEntity, java.lang.String)}.
//	 */
//	@Test
//	public void testExecutePrepare() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#execute(java.lang.String)}.
//	 */
//	@Test
//	public void testExecute() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#checkUniqueFields(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testCheckUniqueFields() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#checkExists(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testCheckExists() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#insert(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#update(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#delete(fr.redpanda.pander.entities.base.BaseEntity)}.
//	 */
//	@Test
//	public void testDeleteBaseEntity() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#delete()}.
//	 */
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for
//	 * {@link fr.redpanda.pander.databases.base.BaseDAO#get(double)}.
//	 */
//	@Test
//	public void testGetDouble() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link fr.redpanda.pander.databases.base.BaseDAO#get()}.
//	 */
//	@Test
//	public void testGet() {
//		fail("Not yet implemented");
//	}

}
