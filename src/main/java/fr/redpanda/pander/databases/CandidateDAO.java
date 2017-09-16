/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.databases.base.BaseUserDAO;
import fr.redpanda.pander.databases.base.IBaseSkillDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CandidateDAO extends BaseUserDAO implements IBaseSkillDAO {

	/** the table */
	public static final String TABLE = "candidate";

	/** the id */
	public static final String ID = "id_kuser";

	/** the firstname field */
	public static final String FIRSTNAME = "firstname";

	/** the lastname field */
	public static final String LASTNAME = "lastname";

	/** the birthdate field */
	public static final String BIRTHDATE = "birthdate";

	/** the transport field */
	public static final String TRANSPORT = "transport";

	/** the link1 field */
	public static final String LINK1 = "link1";

	/** the link2 field */
	public static final String LINK2 = "link2";

	/** the certificate1 field */
	public static final String CERTIFICATE1 = "certificate1";

	/** the certificate2 field */
	public static final String CERTIFICATE2 = "certificate2";

	/** the cv field */
	public static final String CV = "cv";

	public static final String TABLE_SKILL = "candidate_skill";
	public static final String ID_SKILL = "id_skill";
	public static final String ID_CANDIDATE = "id_candidate";

	/** The Constructor */
	protected CandidateDAO() {
		super(TABLE, ID);
	}

	private static CandidateDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static CandidateDAO getInstance() {
		if (instance == null) {
			instance = new CandidateDAO();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Candidate candidate = (Candidate) super.parse(new Candidate(), rs);

		if (candidate == null) {
			return null;
		}

		try {
			// candidate.setId(rs.getDouble(ID));
			candidate.setFirstname(rs.getString(FIRSTNAME));
			candidate.setLastname(rs.getString(LASTNAME));
			candidate.setBirthdate(rs.getTimestamp(BIRTHDATE));
			candidate.setTransport(rs.getString(TRANSPORT));
			candidate.setLink1(rs.getString(LINK1));
			candidate.setLink2(rs.getString(LINK2));
			candidate.setCertificate1(rs.getString(CERTIFICATE1));
			candidate.setCertificate2(rs.getString(CERTIFICATE2));
			candidate.setCv(rs.getString(CV));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return candidate;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#parse(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public String parse(BaseEntity entity) {
		Candidate candidate = (Candidate) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQL(candidate.getId(), false))
				.append(StringManager.toMySQL(candidate.getFirstname(), false))
				.append(StringManager.toMySQL(candidate.getLastname(), false))
				.append(StringManager.toMySQLDate(candidate.getBirthdate(), false))
				.append(StringManager.toMySQL(candidate.getTransport(), false))
				.append(StringManager.toMySQL(candidate.getLink1(), false))
				.append(StringManager.toMySQL(candidate.getLink2(), false))
				.append(StringManager.toMySQL(candidate.getCertificate1(), false))
				.append(StringManager.toMySQL(candidate.getCertificate2(), false))
				.append(StringManager.toMySQL(candidate.getCv(), true));
		return new String(stringBuilder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#parseUpdate(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public String parseUpdate(BaseEntity entity) {
		Candidate candidate = (Candidate) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQLUpdate(FIRSTNAME, candidate.getFirstname(), false))
				.append(StringManager.toMySQLUpdate(LASTNAME, candidate.getLastname(), false))
				.append(StringManager.toMySQLUpdateDate(BIRTHDATE, candidate.getBirthdate(), false))
				.append(StringManager.toMySQLUpdate(TRANSPORT, candidate.getTransport(), false))
				.append(StringManager.toMySQLUpdate(LINK1, candidate.getLink1(), false))
				.append(StringManager.toMySQLUpdate(LINK2, candidate.getLink2(), false))
				.append(StringManager.toMySQLUpdate(CERTIFICATE1, candidate.getCertificate1(), false))
				.append(StringManager.toMySQLUpdate(CERTIFICATE2, candidate.getCertificate2(), false))
				.append(StringManager.toMySQLUpdate(CV, candidate.getCv(), true));
		return new String(stringBuilder);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#fields()
	 */
	@Override
	public String fields() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.last(ID, false)).append(StringManager.last(FIRSTNAME, false))
				.append(StringManager.last(LASTNAME, false)).append(StringManager.last(BIRTHDATE, false))
				.append(StringManager.last(TRANSPORT, false)).append(StringManager.last(LINK1, false))
				.append(StringManager.last(LINK2, false)).append(StringManager.last(CERTIFICATE1, false))
				.append(StringManager.last(CERTIFICATE2, false)).append(StringManager.last(CV, true));
		return new String(stringBuilder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkFields(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public boolean checkFields(BaseEntity entity) {

		Candidate candidate = (Candidate) entity;
		return candidate.getFirstname() != null || candidate.getLastname() != null;

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
		return SkillDAO.getInstance().getSkills(TABLE_SKILL, ID_SKILL, ID_CANDIDATE, entity);
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
		return SkillDAO.getInstance().insertSkills(TABLE_SKILL, ID_SKILL, ID_CANDIDATE, entity);
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
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL, ID_CANDIDATE, entity);
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
	 * @see fr.redpanda.pander.databases.base.BaseUserDAO#delete(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		deleteSkills((IBaseSkillEntity) entity);
		return super.delete(entity);
	}

}
