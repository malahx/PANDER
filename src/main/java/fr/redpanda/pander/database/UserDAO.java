/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.date.DateConverter;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class UserDAO extends DAOManager implements IDAO<User> {

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return (UserDAO) instance;
	}
	
	/**
	 * 
	 * @param conn
	 *            the connection
	 * @param query
	 *            the query to apply
	 * @param user
	 *            the user to pass
	 * @return prepared request
	 * @throws SQLException
	 */
	public PreparedStatement prepareUser(Connection conn, String query, User user) throws SQLException {
		PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		prepare.setString(0, user.getEmail());
		prepare.setString(1, user.getPassword());
		prepare.setString(2, user.getPhone());
		prepare.setString(3, user.getAddress());
		prepare.setString(4, user.getPostcode());
		prepare.setString(5, user.getCity());
		prepare.setString(6, user.getPhoto());
		prepare.setString(7, user.getDescription());
		prepare.setBoolean(8, user.isDisabled());
		prepare.setString(9, user.getRole().toString());
		prepare.setString(10, DateConverter.getMySqlDatetime(user.getCreatedAt()));
		prepare.setString(11, DateConverter.getMySqlDatetime(user.getUpdatedAt()));
		prepare.setLong(12, user.getId());
		return prepare;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#create(java.lang.Object)
	 */
	@Override
	public User create(User user) {
		PreparedStatement prepare = null;
		Connection conn = null;
		ResultSet generatedKeys = null;

		String query = "INSERT INTO kuser (email, password, phone, address, postcode, city, photo, description, disabled, role, createdAt, updatedAt, id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Long id = -1l;
			conn = getConnection();
			if (conn == null) {
				return null;
			}

			Date date = new Date();
			user.setCreatedAt(date);
			user.setUpdatedAt(date);

			prepare = prepareUser(conn, query, user);
			int row = prepare.executeUpdate();

			generatedKeys = prepare.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getLong(1);
			}

			if (row == 0 || id < 0) {
				throw new SQLException("insert error");
			}

			user.setId(id);

		} catch (SQLException e) {
			user.setCreatedAt(null);
			user.setUpdatedAt(null);
			throw new RuntimeException(e);
		} finally {
			close(conn, prepare, generatedKeys);
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#delete(java.lang.Object)
	 */
	@Override
	public User delete(User user) {
		if (delete(user.getId())) {
			user.setId(null);
			user.setCreatedAt(null);
			user.setUpdatedAt(null);
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#delete(int)
	 */
	@Override
	public boolean delete(long id) {
		PreparedStatement prepare = null;
		Connection conn = null;
		Boolean value;

		String query = "DELETE FROM kuser WHERE id = ?";

		try {
			conn = getConnection();
			if (conn == null) {
				return false;
			}

			prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(0, id);

			int row = prepare.executeUpdate();

			if (row == 0) {
				throw new SQLException("deletion error");
			}

			value = true;

		} catch (SQLException e) {
			value = false;
			throw new RuntimeException(e);
		} finally {
			close(conn, prepare);
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#update(java.lang.Object)
	 */
	@Override
	public User update(User user) {
		PreparedStatement prepare = null;
		Connection conn = null;

		String query = "UPDATE kuser SET email = ?, SET password = ?, SET phone = ?, SET address = ?, SET postcode = ?, SET city = ?, SET photo = ?, SET description = ?, SET disabled = ?, SET role = ?, SET createdAt = ?, SET updatedAt = ? WHERE id = ?";

		Date oldDate = user.getUpdatedAt();

		try {
			conn = getConnection();
			if (conn == null) {
				return user;
			}

			user.setUpdatedAt(new Date());

			prepare = prepareUser(conn, query, user);

			int row = prepare.executeUpdate();

			if (row == 0) {
				throw new SQLException("update error");
			}

		} catch (SQLException e) {
			user.setUpdatedAt(oldDate);
			throw new RuntimeException(e);
		} finally {
			close(conn, prepare);
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#findAll()
	 */
	@Override
	public List<User> findAll() {
		 throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#findBy(int)
	 */
	@Override
	public User findBy(long id) {
		 throw new UnsupportedOperationException("Not supported yet."); 
	}

}
