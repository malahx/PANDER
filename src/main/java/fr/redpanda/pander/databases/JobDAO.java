/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.databases.base.IBaseSkillDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;
import fr.redpanda.pander.utils.date.DateConverter;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class JobDAO extends BaseDAO implements IBaseSkillDAO {

	/** the table */
	public static final String TABLE = "job";

	/** the id */
	public static final String ID = "id";

	/** the name field */
	public static final String NAME = "name";

	/** the presentation field */
	public static final String PRESENTATION = "presentation";

	/** the link field */
	public static final String LINK = "link";

	/** the contact field */
	public static final String CONTACT = "contact";

	/** the created at field */
	public static final String CREATED_AT = "created_at";

	/** the updated at field */
	public static final String UPDATED_AT = "updated_at";

	/** the company id field */
	public static final String ID_COMPANY = "id_company";

	/** the skill table */
	public static final String TABLE_SKILL = "job_skill";

	/** the skill id on the job skill table */
	public static final String ID_SKILL = "id_skill";

	/** the job id on the job skill table */
	public static final String ID_JOB = "id_job";

	protected JobDAO() {
		super(TABLE, ID);
	}

	private static JobDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static JobDAO getInstance() {
		if (instance == null) {
			instance = new JobDAO();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Job job = new Job();
		try {
			job.setId(rs.getDouble(ID));
			job.setName(rs.getString(NAME));
			job.setPresentation(rs.getString(PRESENTATION));
			job.setLink(rs.getString(LINK));
			job.setContact(rs.getString(CONTACT));
			job.setCreatedAt(rs.getTimestamp(CREATED_AT));
			job.setUpdatedAt(rs.getTimestamp(UPDATED_AT));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return job;

	}

	public String parse(Job job, Company company) {
		//TODO à revoir en stringbuilder
		String result = "'" + (job.getName() == null ? "" : job.getName()) + "',";
		result += "'" + (job.getPresentation() == null ? "" : job.getPresentation()) + "',";
		result += "'" + (job.getLink() == null ? "" : job.getLink()) + "',";
		result += "'" + (job.getContact() == null ? "" : job.getContact()) + "',";
		result += (job.getCreatedAt() == null ? "NULL" : "'" + DateConverter.getMySqlDatetime(job.getCreatedAt()) + "'")
				+ ",";
		result += (job.getUpdatedAt() == null ? "NULL" : "'" + DateConverter.getMySqlDatetime(job.getUpdatedAt()) + "'")
				+ ",";
		result += String.valueOf(company.getId());
		return result;
	}

	public BaseEntity insert(Job job, Company company) {
		if (!checkExists(job) && checkFields(job)) {
			job.setCreatedAt(new Date());
			job.setUpdatedAt(new Date());
			executePrepare(job, "INSERT INTO " + TABLE + " (" + fields() + ") VALUES (" + parse(job, company) + ")");
		}
		return job;
	}

	public Company get(Company company) {

		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " WHERE " + ID_COMPANY + " = " + company.getId());
		try {
			while (rs.next()) {
				company.getJobs().add((Job) parse(rs));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IDAOBase#parseUpdate(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdate(BaseEntity entity) {
		//TODO à revoir en stringbuilder
		Job job = (Job) entity;
		String result = NAME + " = '" + job.getName() + "',";
		result += PRESENTATION + " = '" + job.getPresentation() + "',";
		result += LINK + " = '" + (job.getLink() == null ? "" : job.getLink()) + "',";
		result += CONTACT + " = '" + (job.getContact() == null ? "" : job.getContact()) + "',";
		result += CREATED_AT + " = "
				+ (job.getCreatedAt() == null ? "NULL" : "'" + DateConverter.getMySqlDatetime(job.getCreatedAt()) + "'")
				+ ",";
		result += UPDATED_AT + " = " + (job.getUpdatedAt() == null ? "NULL"
				: "'" + DateConverter.getMySqlDatetime(job.getUpdatedAt()) + "'");
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IDAOBase#fields()
	 */
	@Override
	public String fields() {
		//TODO à revoir en stringbuilder
		return NAME + "," + PRESENTATION + "," + LINK + "," + CONTACT + "," + CREATED_AT + "," + UPDATED_AT + ","
				+ ID_COMPANY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IDAOBase#checkFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkFields(BaseEntity entity) {
		return ((Job) entity).getName() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IDAOBase#parse(fr.redpanda.pander.entities.
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
	 * fr.redpanda.pander.database.IDAOBase#insert(fr.redpanda.pander.entities.base.
	 * BaseEntity)
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
		Job job = (Job) entity;
		job.setUpdatedAt(new Date());
		return super.update(entity);
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
		deleteSkills((IBaseSkillEntity) entity);
		return super.delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#delete()
	 */
	@Override
	public int delete() {
		deleteSkills();
		return super.delete();
	}

	@Override
	public IBaseSkillEntity getSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().getSkills(TABLE_SKILL, ID_SKILL, ID_JOB, entity);
	}

	@Override
	public int insertSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().insertSkills(TABLE_SKILL, ID_SKILL, ID_JOB, entity);
	}

	@Override
	public int deleteSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL, ID_JOB, entity);
	}

	@Override
	public int deleteSkills() {
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL);
	}

}
