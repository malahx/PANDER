/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.redpanda.pander.database.base.BaseDAO;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.StringManager;
import fr.redpanda.pander.utils.date.DateConverter;

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

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return (UserDAO) instance;
	}

	public BaseEntity getByEmail(String email) {
		ResultSet rs = query("SELECT * FROM " + TABLE + " WHERE " + EMAIL + " = " + email);
		BaseEntity entity = null;
		try {
			if (rs.next()) {
				entity = parse(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
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
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public BaseEntity get(BaseEntity entity, double id) {
		ResultSet rs = query("SELECT * FROM " + TABLE + " WHERE " + ID + " = " + id);
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
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#parse(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public String parse(BaseEntity entity) {

		String result = "";
		User user = (User) entity;
		result += "'" + user.getEmail() + "',";
		result += "'" + user.getPassword() + "',";
		result += "'" + user.getRole() + "',";
		result += user.isDisabled() ? 1 : 0;
		result += "'" + user.getPhone() + "',";
		result += "'" + user.getAddress() + "',";
		result += "'" + user.getPostcode() + "',";
		result += "'" + user.getCity() + "',";
		result += "'" + user.getPhoto() + "',";
		result += "'" + user.getDescription() + "',";
		result += "'" + DateConverter.getMySqlDatetime(user.getCreatedAt()) + "',";
		result += "'" + DateConverter.getMySqlDatetime(user.getUpdatedAt()) + "'";
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
		User user = (User) entity;
		result += "'" + EMAIL + "'" + " = '" + user.getEmail() + "' ";
		result += "'" + PASSWORD + "'" + " = '" + user.getPassword() + "' ";
		result += "'" + ROLE + "'" + " = '" + user.getRole() + "' ";
		result += "'" + DISABLED + "'" + " = " + (user.isDisabled() ? 1 : 0);
		result += "'" + PHONE + "'" + " = '" + user.getPhone() + "' ";
		result += "'" + ADDRESS + "'" + " = '" + user.getAddress() + "' ";
		result += "'" + POSTCODE + "'" + " = '" + user.getPostcode() + "' ";
		result += "'" + CITY + "'" + " = '" + user.getCity() + "' ";
		result += "'" + PHOTO + "'" + " = '" + user.getPhoto() + "' ";
		result += "'" + DESCRIPTION + "'" + " = '" + user.getDescription() + "' ";
		result += "'" + CREATED_AT + "'" + " = '" + DateConverter.getMySqlDatetime(user.getCreatedAt()) + "' ";
		result += "'" + UPDATED_AT + "'" + " = '" + DateConverter.getMySqlDatetime(user.getUpdatedAt()) + "'";
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
		result += "'" + EMAIL + "',";
		result += "'" + PASSWORD + "',";
		result += "'" + ROLE + "',";
		result += "'" + DISABLED + "',";
		result += "'" + PHONE + "',";
		result += "'" + ADDRESS + "',";
		result += "'" + POSTCODE + "',";
		result += "'" + CITY + "',";
		result += "'" + PHOTO + "',";
		result += "'" + DESCRIPTION + "',";
		result += "'" + CREATED_AT + "',";
		result += "'" + UPDATED_AT + "'";
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

		Skill skill = (Skill) entity;
		if (skill.getName() == null) {
			return false;
		}
		return true;

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
		return getByEmail(((User) entity).getEmail()) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet resultSet) {
		throw new UnsupportedOperationException("Not supported on UserDAO.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.BaseDAO#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		throw new UnsupportedOperationException("Not supported on UserDAO.");
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

}
