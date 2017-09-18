/**
 * 
 */
package fr.redpanda.pander.test.databases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.redpanda.pander.databases.SkillDAO;
import fr.redpanda.pander.test.databases.base.BaseDAOTest;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillDAOTest extends BaseDAOTest {

	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.databases.SkillDAO#checkUniqueFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	// */
	// @Test
	// public void testCheckUniqueFields() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for {@link fr.redpanda.pander.databases.SkillDAO#SkillDAO()}.
	// */
	// @Test
	// public void testSkillDAO() {
	// fail("Not yet implemented");
	// }

	/**
	 * {@link fr.redpanda.pander.databases.SkillDAO#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertEquals(SkillDAO.getInstance(), SkillDAO.getInstance());
		assertNotNull(SkillDAO.getInstance());
	}

	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.databases.SkillDAO#get(java.lang.String)}.
	// */
	// @Test
	// public void testGetString() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.databases.SkillDAO#getSkills(java.lang.String,
	// java.lang.String, java.lang.String,
	// fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	// */
	// @Test
	// public void testGetSkills() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.databases.SkillDAO#insertSkills(java.lang.String,
	// java.lang.String, java.lang.String,
	// fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	// */
	// @Test
	// public void testInsertSkills() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.databases.SkillDAO#deleteSkills(java.lang.String,
	// java.lang.String, fr.redpanda.pander.entities.base.IBaseSkillEntity)}.
	// */
	// @Test
	// public void testDeleteSkillsStringStringIBaseSkillEntity() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.databases.SkillDAO#deleteSkills(java.lang.String)}.
	// */
	// @Test
	// public void testDeleteSkillsString() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link fr.redpanda.pander.databases.SkillDAO#parse(java.sql.ResultSet)}.
	// */
	// @Test
	// public void testParseResultSet() {
	// fail("Not yet implemented");
	// }

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.SkillDAO#parse(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseBaseEntity() {
		String string = "'" + skillTech.getName() + "','" + skillTech.getType() + "'";
		assertEquals(SkillDAO.getInstance().parse(skillTech), string);
	}

	/**
	 * Test method for
	 * {@link fr.redpanda.pander.databases.SkillDAO#parseUpdate(fr.redpanda.pander.entities.base.BaseEntity)}.
	 */
	@Test
	public void testParseUpdate() {
		String string = "name = '" + skillTech.getName() + "',type = '" + skillTech.getType() + "'";
		assertEquals(SkillDAO.getInstance().parseUpdate(skillTech), string);
	}

	/**
	 * Test method for {@link fr.redpanda.pander.databases.SkillDAO#fields()}.
	 */
	@Test
	public void testFields() {
		assertEquals(SkillDAO.getInstance().fields(), "name,type");
	}

	// /**
	// * Test method for
	// * {@link
	// fr.redpanda.pander.databases.SkillDAO#checkFields(fr.redpanda.pander.entities.base.BaseEntity)}.
	// */
	// @Test
	// public void testCheckFields() {
	// fail("Not yet implemented");
	// }

}
