/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.databases.base.BaseUserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.date.DateConverter;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CandidateDAO extends BaseUserDAO {

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

	protected static CandidateDAO instance = null;

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

	public Candidate getSkills(Candidate candidate) {

		List<Skill> skills = new ArrayList<>();
		ResultSet rs = query(
				"SELECT " + ID_SKILL + " FROM " + TABLE_SKILL + " WHERE " + ID_CANDIDATE + " = " + candidate.getId());
		try {
			while (rs.next()) {
				skills.add((Skill) SkillDAO.getInstance().get(rs.getDouble(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		candidate.setSkills(skills);
		return candidate;

	}

	public int insertSkills(Candidate candidate) {
		int result = 0;
		deleteSkills(candidate);
		for (Skill skill : candidate.getSkills()) {
			result += execute("INSERT INTO " + TABLE_SKILL + " (" + ID_CANDIDATE + "," + ID_SKILL + ") VALUES ("
					+ candidate.getId() + "," + skill.getId() + ")");
		}
		return result;
	}

	private int deleteSkills(BaseEntity entity) {
		return execute("DELETE FROM " + TABLE_SKILL + " WHERE " + ID_CANDIDATE + " = " + entity.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Candidate candidate = (Candidate) super.parse(new Candidate(), rs);
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
			candidate = null;
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

		String result = "";
		Candidate candidate = (Candidate) entity;
		result += "'" + candidate.getId() + "',";
		result += "'" + candidate.getFirstname() + "',";
		result += "'" + candidate.getLastname() + "',";
		result += candidate.getBirthdate() == null ? "NULL, "
				: "'" + DateConverter.getMySqlDate(candidate.getBirthdate()) + "',";
		result += "'" + candidate.getTransport() + "',";
		result += "'" + candidate.getLink1() + "',";
		result += "'" + candidate.getLink2() + "',";
		result += "'" + candidate.getCertificate1() + "',";
		result += "'" + candidate.getCertificate2() + "',";
		result += "'" + candidate.getCv() + "'";
		return result;
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

		String result = "";
		Candidate candidate = (Candidate) entity;
		result += FIRSTNAME + " = '" + candidate.getFirstname() + "',";
		result += LASTNAME + " = '" + candidate.getLastname() + "',";
		result += BIRTHDATE + " = " + (candidate.getBirthdate() == null ? "NULL"
				: "'" + DateConverter.getMySqlDate(candidate.getBirthdate()) + "'") + ",";
		result += TRANSPORT + " = " + (candidate.getTransport() == null ? "" : "'" + candidate.getTransport()) + "',";
		result += LINK1 + " = '" + (candidate.getLink1() == null ? "" : candidate.getLink1()) + "',";
		result += LINK2 + " = '" + (candidate.getLink2() == null ? "" : candidate.getLink2()) + "',";
		result += CERTIFICATE1 + " = '" + (candidate.getCertificate1() == null ? "" : candidate.getCertificate1())
				+ "',";
		result += CERTIFICATE2 + " = '" + (candidate.getCertificate2() == null ? "" : candidate.getCertificate2())
				+ "',";
		result += CV + " = '" + (candidate.getCv() == null ? "" : candidate.getCv()) + "'";
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#fields()
	 */
	@Override
	public String fields() {

		String result = "";
		result += ID + ",";
		result += FIRSTNAME + ",";
		result += LASTNAME + ",";
		result += BIRTHDATE + ",";
		result += TRANSPORT + ",";
		result += LINK1 + ",";
		result += LINK2 + ",";
		result += CERTIFICATE1 + ",";
		result += CERTIFICATE2 + ",";
		result += CV;
		return result;

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
		if (candidate.getFirstname() == null || candidate.getLastname() == null) {
			return false;
		}
		return true;

	}

}