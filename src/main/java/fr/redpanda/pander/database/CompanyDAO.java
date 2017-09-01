/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.database.base.BaseUserDAO;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.base.BaseEntity;

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

	protected static CompanyDAO instance = null;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Company company = (Company) super.parse(new Company(), rs);
		try {
			//company.setId(rs.getDouble(ID));
			company.setName(rs.getString(NAME));
			company.setSiret(rs.getString(SIRET));
			company.setContact(rs.getString(CONTACT));
			company.setLink(rs.getString(LINK));
			rs.close();
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

		String result = "";
		Company company = (Company) entity;
		result += company.getId() + ",";
		result += "'" + (company.getName() == null ? "" : company.getName()) + "',";
		result += "'" + (company.getSiret() == null ? "" : company.getSiret()) + "',";
		result += "'" + (company.getContact() == null ? "" : company.getContact()) + "',";
		result += "'" + (company.getLink() == null ? "" : company.getLink()) + "'";
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
		Company company = (Company) entity;
		result += NAME + " = '" + (company.getName() == null ? "" : company.getName()) + "',";
		result += SIRET + " = '" + (company.getSiret() == null ? "" : company.getSiret()) + "',";
		result += CONTACT + " = '" + (company.getContact() == null ? "" : company.getContact()) + "',";
		result += LINK + " = '" + (company.getLink() == null ? "" : company.getLink()) + "'";
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
		result += NAME + ",";
		result += SIRET + ",";
		result += CONTACT + ",";
		result += LINK;
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

		Company company = (Company) entity;
		if (company.getName() == null || company.getSiret() == null) {
			return false;
		}
		return true;

	}

}
