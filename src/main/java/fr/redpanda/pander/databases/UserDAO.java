/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Role;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class UserDAO extends BaseDAO {

	public static final String TABLE = "kuser";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String DISABLED = "disabled";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String POSTCODE = "postcode";
	public static final String CITY = "city";
	public static final String PHOTO = "photo";
	public static final String DESCRIPTION = "description";
	public static final String CREATED_AT = "created_at";
	public static final String UPDATED_AT = "updated_at";

	protected UserDAO() {
		super(TABLE, ID);
	}

	private static UserDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public BaseEntity get(String email, String password) {
		ResultSet rs = executeQuery(
				"SELECT * FROM " + TABLE + " u LEFT JOIN " + CompanyDAO.TABLE + " co ON co." + CompanyDAO.ID + " = u."
						+ ID + " LEFT JOIN " + CandidateDAO.TABLE + " ca ON ca." + CandidateDAO.ID + " = u." + ID
						+ " WHERE u." + EMAIL + " = '" + email + "' AND u." + PASSWORD + " = '" + password + "'");
		BaseEntity entity = null;
		try {
			if (rs.next()) {
				String role = rs.getString(ROLE);
				if (role.equals(Role.CANDIDATE.toString())) {
					entity = CandidateDAO.getInstance().parse(rs);
				} else if (role.equals(Role.COMPANY.toString())) {
					entity = CompanyDAO.getInstance().parse(rs);
				} else if (role.equals(Role.ADMIN.toString())) {
					entity = parse(new Admin(), rs);
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			entity = null;
		}
		return entity;
	}

	public boolean isExists(String email) {
		ResultSet rs = executeQuery("SELECT " + ID + " FROM " + TABLE + " WHERE " + EMAIL + " = '" + email + "'");
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

	public BaseEntity parse(BaseEntity entity, ResultSet rs) {

		User user = (User) entity;
		try {
			user.setId(rs.getDouble(ID));
			user.setEmail(rs.getString(EMAIL));
			user.setPassword(rs.getString(PASSWORD));
			user.setRole(StringManager.getRoleFrom(rs.getString(ROLE)));
			user.setDisabled(rs.getBoolean(DISABLED));
			user.setPhone(rs.getString(PHONE));
			user.setAddress(rs.getString(ADDRESS));
			user.setPostcode(rs.getString(POSTCODE));
			user.setCity(rs.getString(CITY));
			user.setPhoto(rs.getString(PHOTO));
			user.setDescription(rs.getString(DESCRIPTION));
			user.setCreatedAt(rs.getTimestamp(CREATED_AT));
			user.setUpdatedAt(rs.getTimestamp(UPDATED_AT));
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		return user;

	}

	public BaseEntity get(BaseEntity entity, double id) {
		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " WHERE " + ID + " = " + id);
		try {
			if (rs.next()) {
				entity = parse(entity, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		BaseEntity entity = null;
		String role;
		try {
			role = rs.getString(ROLE);
			if (role.equals(Role.CANDIDATE.toString())) {
				entity = CandidateDAO.getInstance().parse(rs);
			} else if (role.equals(Role.COMPANY.toString())) {
				entity = CompanyDAO.getInstance().parse(rs);
			} else if (role.equals(Role.ADMIN.toString())) {
				entity = parse(new Admin(), rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;

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
		User user = (User) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQL(user.getEmail(), false))
				.append(StringManager.toMySQL(user.getPassword(), false))
				.append(StringManager.toMySQL(user.getRole(), false))
				.append(StringManager.toMySQL(user.isDisabled(), false))
				.append(StringManager.toMySQL(user.getPhone(), false))
				.append(StringManager.toMySQL(user.getAddress(), false))
				.append(StringManager.toMySQL(user.getPostcode(), false))
				.append(StringManager.toMySQL(user.getCity(), false))
				.append(StringManager.toMySQL(user.getPhoto(), false))
				.append(StringManager.toMySQL(user.getDescription(), false))
				.append(StringManager.toMySQLDateTime(user.getCreatedAt(), false))
				.append(StringManager.toMySQLDateTime(user.getUpdatedAt(), true));
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
		User user = (User) entity;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringManager.toMySQLUpdate(EMAIL, user.getEmail(), false))
				.append(StringManager.toMySQLUpdate(PASSWORD, user.getPassword(), false))
				.append(StringManager.toMySQLUpdate(ROLE, user.getRole(), false))
				.append(StringManager.toMySQLUpdate(DISABLED, user.isDisabled(), false))
				.append(StringManager.toMySQLUpdate(PHONE, user.getPhone(), false))
				.append(StringManager.toMySQLUpdate(ADDRESS, user.getAddress(), false))
				.append(StringManager.toMySQLUpdate(POSTCODE, user.getPostcode(), false))
				.append(StringManager.toMySQLUpdate(CITY, user.getCity(), false))
				.append(StringManager.toMySQLUpdate(PHOTO, user.getPhoto(), false))
				.append(StringManager.toMySQLUpdate(DESCRIPTION, user.getDescription(), false))
				.append(StringManager.toMySQLUpdateDateTime(CREATED_AT, user.getCreatedAt(), false))
				.append(StringManager.toMySQLUpdateDateTime(UPDATED_AT, user.getUpdatedAt(), true));
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
		stringBuilder.append(StringManager.last(EMAIL, false)).append(StringManager.last(PASSWORD, false))
				.append(StringManager.last(ROLE, false)).append(StringManager.last(DISABLED, false))
				.append(StringManager.last(PHONE, false)).append(StringManager.last(ADDRESS, false))
				.append(StringManager.last(POSTCODE, false)).append(StringManager.last(CITY, false))
				.append(StringManager.last(PHOTO, false)).append(StringManager.last(DESCRIPTION, false))
				.append(StringManager.last(CREATED_AT, false)).append(StringManager.last(UPDATED_AT, true));
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
		User user = (User) entity;
		return user.getEmail() != null && user.getPassword() != null && user.getRole() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkUniqueFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkUniqueFields(BaseEntity entity) {
		return isExists(((User) entity).getEmail());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.BaseDAO#insert(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public BaseEntity insert(BaseEntity entity) {
		User user = (User) entity;
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		return super.insert(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.BaseDAO#update(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public int update(BaseEntity entity) {
		User user = (User) entity;
		user.setUpdatedAt(new Date());
		return super.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.base.BaseDAO#get()
	 */
	@Override
	public List<BaseEntity> get() {

		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " LEFT JOIN " + CompanyDAO.TABLE + " ON "
				+ CompanyDAO.TABLE + "." + CompanyDAO.ID + " = " + ID + " LEFT JOIN " + CandidateDAO.TABLE + " ON "
				+ CandidateDAO.TABLE + "." + CandidateDAO.ID + " = " + ID);
		List<BaseEntity> entities = new ArrayList<>();
		try {
			while (rs.next()) {
				entities.add(parse(rs));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;

	}

}
