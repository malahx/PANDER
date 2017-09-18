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
import fr.redpanda.pander.utils.StringManager;

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

	/**
	 * The constructor
	 */
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

	/**
	 * Parse a job with his company linked
	 * 
	 * @param job
	 * @param company
	 * @return
	 */
	public String parse(Job job, Company company) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQL(job.getName(), false))
				.append(StringManager.toMySQL(job.getPresentation(), false))
				.append(StringManager.toMySQL(job.getLink(), false))
				.append(StringManager.toMySQL(job.getContact(), false))
				.append(StringManager.toMySQLDateTime(job.getCreatedAt(), false))
				.append(StringManager.toMySQLDateTime(job.getUpdatedAt(), false))
				.append(StringManager.toMySQL(company.getId(), true));
		return new String(stringBuilder);
	}

	/**
	 * Insert a job with his company linked
	 * 
	 * @param job
	 * @param company
	 * @return
	 */
	public BaseEntity insert(Job job, Company company) {
		if (!checkExists(job) && checkFields(job)) {
			job.setCreatedAt(new Date());
			job.setUpdatedAt(new Date());
			executePrepare(job, "INSERT INTO " + TABLE + " (" + fields() + ") VALUES (" + parse(job, company) + ")");
		}
		return job;
	}

	/**
	 * Add all job from a company
	 * 
	 * @param company
	 * @return
	 */
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
		Job job = (Job) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQLUpdate(NAME, job.getName(), false))
				.append(StringManager.toMySQLUpdate(PRESENTATION, job.getPresentation(), false))
				.append(StringManager.toMySQLUpdate(LINK, job.getLink(), false))
				.append(StringManager.toMySQLUpdate(CONTACT, job.getContact(), false))
				.append(StringManager.toMySQLUpdateDateTime(CREATED_AT, job.getCreatedAt(), false))
				.append(StringManager.toMySQLUpdateDateTime(UPDATED_AT, job.getUpdatedAt(), true));
		return new String(stringBuilder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IDAOBase#fields()
	 */
	@Override
	public String fields() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.last(NAME, false)).append(StringManager.last(PRESENTATION, false))
				.append(StringManager.last(LINK, false)).append(StringManager.last(CONTACT, false))
				.append(StringManager.last(CREATED_AT, false)).append(StringManager.last(UPDATED_AT, false))
				.append(StringManager.last(ID_COMPANY, true));
		return new String(stringBuilder);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseSkillDAO#getSkills(fr.redpanda.pander.
	 * entities.base.IBaseSkillEntity)
	 */
	@Override
	public IBaseSkillEntity getSkills(IBaseSkillEntity entity) {
		return SkillDAO.getInstance().getSkills(TABLE_SKILL, ID_SKILL, ID_JOB, entity);
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
		return SkillDAO.getInstance().insertSkills(TABLE_SKILL, ID_SKILL, ID_JOB, entity);
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
		return SkillDAO.getInstance().deleteSkills(TABLE_SKILL, ID_JOB, entity);
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

}
