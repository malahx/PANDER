/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.test.databases.base.BaseDAOTest;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CandidateDAOTest extends BaseDAOTest {

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#delete(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testDeleteBaseEntity() {
		fail("Not yet implemented");
	}

	/**
	 * {@link fr.redpanda.pander.databases.CandidateDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceEquals() {
		assertEquals(CandidateDAO.getInstance(), CandidateDAO.getInstance());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#getInstance()}.
	 */
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull(CandidateDAO.getInstance());
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#parse(java.sql.ResultSet)}.
	 */
	@Test
	public void testParseResultSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#parse(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseBaseEntity() {
		String result = "0,'firstname','lastname',NULL,'','','','','',''";
		assertEquals(CandidateDAO.getInstance().parse(candidate), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#parseUpdate(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseUpdate() {
		String result = "firstname = '" + candidate.getFirstname() + "',lastname = '" + candidate.getLastname()
				+ "',birthdate = NULL,transport = '',link1 = '',link2 = '',certificate1 = '',certificate2 = '',cv = ''";
		assertEquals(CandidateDAO.getInstance().parseUpdate(candidate), result);
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.CandidateDAO#fields()}.
	 */
	@Test
	public void testFields() {
		String result = "id_kuser,firstname,lastname,birthdate,transport,link1,link2,certificate1,certificate2,cv";
		assertEquals(CandidateDAO.getInstance().fields(), result);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testCheckFields() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#getSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testGetSkills() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#insertSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testInsertSkills() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#deleteSkills(fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	 */
	@Test
	public void testDeleteSkillsIBaseSkillEntity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.CandidateDAO#deleteSkills()}.
	 */
	@Test
	public void testDeleteSkills() {
		fail("Not yet implemented");
	}

}
