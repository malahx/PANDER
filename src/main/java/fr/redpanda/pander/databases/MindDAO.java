/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.databases.base.IBaseSkillDAO;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MindDAO extends BaseDAO implements IBaseSkillDAO {

	/** the table */
	public static final String TABLE = "mind";

	/** the id */
	public static final String ID = "id";

	/** the name field */
	public static final String NAME = "name";

	/** the skill table field */
	public static final String TABLE_SKILL = "mind_skill";

	/** the skill id on the mind skill table */
	public static final String ID_SKILL = "id_skill";

	/** the job id on the mind skill table */
	public static final String ID_MIND = "id_mind";

	/** The Constructor */
	protected MindDAO() {
		super(TABLE, ID);
	}

	private static MindDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static MindDAO getInstance() {
		if (instance == null) {
			instance = new MindDAO();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseDAO#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#parse(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public String parse(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#parseUpdate(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdate(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseDAO#fields()
	 */
	@Override
	public String fields() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#checkFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkFields(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseSkillDAO#getSkills(fr.redpanda.pander.
	 * entities.base.IBaseSkillEntity)
	 */
	@Override
	public IBaseSkillEntity getSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().getSkills(TABLE_SKILL, ID_SKILL, ID_MIND, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseSkillDAO#insertSkills(fr.redpanda.
	 * pander.entities.base.IBaseSkillEntity)
	 */
	@Override
	public int insertSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().insertSkills(TABLE_SKILL, ID_SKILL, ID_MIND, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseSkillDAO#deleteSkills(fr.redpanda.
	 * pander.entities.base.IBaseSkillEntity)
	 */
	@Override
	public int deleteSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL, ID_MIND, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseSkillDAO#deleteSkills()
	 */
	@Override
	public int deleteSkills() {
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#insert(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public BaseEntity insert(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#update(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public int update(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#delete(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#delete()
	 */
	@Override
	public int delete() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
