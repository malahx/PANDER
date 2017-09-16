/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.databases.base.BaseUserDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CompanyDAO extends BaseUserDAO {

	/** the table */
	public static final String TABLE = "company";

	/** the id */
	public static final String ID = "id_kuser";

	/** the name field */
	public static final String NAME = "name";

	/** the siret field */
	public static final String SIRET = "siret";

	/** the contact field */
	public static final String CONTACT = "contact";

	/** the link field */
	public static final String LINK = "link";

	/** The Constructor */
	protected CompanyDAO() {
		super(TABLE, ID);
	}

	private static CompanyDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static CompanyDAO getInstance() {
		if (instance == null) {
			instance = new CompanyDAO();
		}
		return instance;
	}

	/**
	 * Test if a SIRET number is index in the database
	 * 
	 * @param siret
	 * @return
	 */
	public boolean isExists(String siret) {

		ResultSet rs = executeQuery("SELECT " + ID + " FROM " + TABLE + " WHERE " + SIRET + " = '" + siret + "'");
		boolean result = false;
		try {
			if (rs.next()) {
				result = rs.getDouble(ID) > 0 ? true : false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Company company = (Company) super.parse(new Company(), rs);
		try {
			// company.setId(rs.getDouble(ID));
			company.setName(rs.getString(NAME));
			company.setSiret(rs.getString(SIRET));
			company.setContact(rs.getString(CONTACT));
			company.setLink(rs.getString(LINK));
		} catch (SQLException e) {
			e.printStackTrace();
			company = null;
		}
		return company;

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
		Company company = (Company) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQL(company.getId(), false))
				.append(StringManager.toMySQL(company.getName(), false))
				.append(StringManager.toMySQL(company.getSiret(), false))
				.append(StringManager.toMySQL(company.getContact(), false))
				.append(StringManager.toMySQL(company.getLink(), true));
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
		Company company = (Company) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQLUpdate(NAME, company.getName(), false))
				.append(StringManager.toMySQLUpdate(SIRET, company.getSiret(), false))
				.append(StringManager.toMySQLUpdate(CONTACT, company.getContact(), false))
				.append(StringManager.toMySQLUpdate(LINK, company.getLink(), true));
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
		stringBuilder.append(StringManager.last(ID, false)).append(StringManager.last(NAME, false))
				.append(StringManager.last(SIRET, false)).append(StringManager.last(CONTACT, true));
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

		Company company = (Company) entity;
		if (company.getName() == null || company.getSiret() == null) {
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#checkUniqueFields(fr.redpanda.
	 * pander.entities.base.BaseEntity)
	 */
	@Override
	public boolean checkUniqueFields(BaseEntity entity) {
		return isExists(((Company) entity).getSiret());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseUserDAO#delete(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		for (Job job : ((Company) entity).getJobs()) {
			JobDAO.getInstance().delete(job);
		}
		return super.delete(entity);
	}

}
