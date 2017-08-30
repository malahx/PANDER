/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Role;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.date.DateConverter;

/**
 * @author Gwénolé LE HENAFF
 *
 */
//public class UserDAO extends DAOManager implements IDAO<User> {
//
//	private static UserDAO instance;
//	public static UserDAO getInstance() {
//		if (instance == null) {
//			instance = new UserDAO();
//		}
//		return instance;
//	}
//	
//	/**
//	 * 
//	 * @param conn
//	 *            the connection
//	 * @param query
//	 *            the query to apply
//	 * @param user
//	 *            the user to pass
//	 * @return prepared request
//	 * @throws SQLException
//	 */
//	public PreparedStatement prepareUser(Connection conn, String query, User user) throws SQLException {
//		PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//		prepare.setString(1, user.getEmail());
//		prepare.setString(2, user.getPassword());
//		prepare.setString(3, user.getPhone());
//		prepare.setString(4, user.getAddress());
//		prepare.setString(5, user.getPostcode());
//		prepare.setString(6, user.getCity());
//		prepare.setString(7, user.getPhoto());
//		prepare.setString(8, user.getDescription());
//		prepare.setBoolean(9, user.isDisabled());
//		prepare.setString(10, user.getRole().toString());
//		prepare.setString(11, DateConverter.getMySqlDatetime(user.getCreatedAt()));
//		prepare.setString(12, DateConverter.getMySqlDatetime(user.getUpdatedAt()));
//		if (user.getId() != null) {
//			prepare.setLong(13, user.getId());
//		}
//		return prepare;
//	}
//
//	/**
//	 * @param id the id to search
//	 * @return if the id exists on the database
//	 */
//	private boolean isExists(Long id) {
//		String query = "SELECT * FROM kuser WHERE id = ?";
//		boolean value = false;
//		try {
//			Connection conn = getConnection();
//			if (conn == null) {
//				return value;
//			}
//			PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			prepare.setLong(1, id);
//			
//			ResultSet result = prepare.executeQuery();
//			
//			while (result.next()) {
//				value = true;
//				break;
//			}
//			close(null, prepare, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return value;
//	}
//
//	/* (non-Javadoc)
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Object)
//	 */
//	@Override
//	public boolean checkExists(User user) {
//		if (user == null) {
//			return false;
//		}
//		return checkExists(user.getId());
//	}
//
//	/* (non-Javadoc)
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Long)
//	 */
//	@Override
//	public boolean checkExists(Long id) {
//		return id != null && id > 0 && isExists(id);
//	}
//	
//	/* (non-Javadoc)
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Long)
//	 */	
//	@Override
//	public boolean validFields(User user) {
//		if (user == null) {
//			return false;
//		}
//
//		String email = user.getEmail();
//		String password = user.getPassword();
//		Role role = user.getRole();
//		if (email == null || email.isEmpty() || password == null || password.isEmpty() || role == null) {
//			return false;
//		}
//
//		return true;
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#create(java.lang.Object)
//	 */
//	@Override
//	public User create(User user) {
//		if (checkExists(user) || !validFields(user)) {
//			return null;
//		}
//		PreparedStatement prepare = null;
//		Connection conn = null;
//		ResultSet generatedKeys = null;
//
//		String query = "INSERT INTO kuser (email, password, phone, address, postcode, city, photo, description, disabled, role, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			Long id = -1l;
//			conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			Date date = new Date();
//			user.setCreatedAt(date);
//			user.setUpdatedAt(date);
//
//			prepare = prepareUser(conn, query, user);
//			int row = prepare.executeUpdate();
//
//			generatedKeys = prepare.getGeneratedKeys();
//			if (generatedKeys.next()) {
//				id = generatedKeys.getLong(1);
//			}
//
//			if (row == 0 || id < 0) {
//				throw new SQLException("insert error");
//			}
//
//			user.setId(id);
//
//		} catch (SQLException e) {
//			user.setCreatedAt(null);
//			user.setUpdatedAt(null);
//			throw new RuntimeException(e);
//		} finally {
//			close(null, prepare, generatedKeys);
//		}
//		return user;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#delete(java.lang.Object)
//	 */
//	@Override
//	public User delete(User user) {
//		if (!checkExists(user)) {
//			return null;
//		}
//		if (delete(user.getId())) {
//			user.setId(null);
//			user.setCreatedAt(null);
//			user.setUpdatedAt(null);
//		}
//		return user;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#delete(int)
//	 */
//	@Override
//	public boolean delete(Long id) {
//		if (!checkExists(id)) {
//			return false;
//		}
//		PreparedStatement prepare = null;
//		Connection conn = null;
//		Boolean value;
//
//		String query = "DELETE FROM kuser WHERE id = ?";
//
//		try {
//			conn = getConnection();
//			if (conn == null) {
//				return false;
//			}
//
//			prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			prepare.setLong(1, id);
//
//			int row = prepare.executeUpdate();
//
//			if (row == 0) {
//				throw new SQLException("deletion error");
//			}
//
//			value = true;
//
//		} catch (SQLException e) {
//			value = false;
//			throw new RuntimeException(e);
//		} finally {
//			close(null, prepare);
//		}
//		return value;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#update(java.lang.Object)
//	 */
//	@Override
//	public User update(User user) {
//		if (!checkExists(user) || !validFields(user)) {
//			return null;
//		}
//		PreparedStatement prepare = null;
//		Connection conn = null;
//
//		String query = "UPDATE kuser SET email = ?, password = ?, phone = ?, address = ?, postcode = ?, city = ?, photo = ?, description = ?, disabled = ?, role = ?, created_at = ?, updated_at = ? WHERE id = ?";
//
//		Date oldDate = user.getUpdatedAt();
//
//		try {
//			conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			user.setUpdatedAt(new Date());
//
//			prepare = prepareUser(conn, query, user);
//
//			int row = prepare.executeUpdate();
//
//			if (row == 0) {
//				throw new SQLException("update error");
//			}
//
//		} catch (SQLException e) {
//			user.setUpdatedAt(oldDate);
//			throw new RuntimeException(e);
//		} finally {
//			close(null, prepare);
//		}
//		return user;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#findAll()
//	 */
//	@Override
//	public List<User> findAll() {
//
//		List<User> users = new ArrayList<>();
//		
//		String query = "SELECT * FROM kuser u LEFT JOIN company co ON co.id_kuser = u.id LEFT JOIN candidate ca ON ca.id_kuser = u.id";
//		
//		try {
//			Connection conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			
//			ResultSet result = prepare.executeQuery();
//			
//			if (result.next()) {
//				switch (result.getString("role")) {
//				case "ADMIN":
//					users.add(new Admin(result));
//					break;
//				case "CANDIDATE":
//					users.add(new Candidate(result));
//					break;
//				case "COMPANY":
//					users.add(new Company(result));
//					break;
//				default:
//					break;
//				}
//			}
//			close(null, prepare, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return users;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#findBy(int)
//	 */
//	@Override
//	public User findBy(long id) {
//
//		User user = null;
//		
//		String query = "SELECT * FROM kuser u LEFT JOIN company co ON co.id_kuser = u.id LEFT JOIN candidate ca ON ca.id_kuser = u.id WHERE u.id = ?";
//		
//		try {
//			Connection conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			prepare.setLong(1, id);
//			
//			ResultSet result = prepare.executeQuery();
//			
//			if (result.next()) {
//				switch (result.getString("role")) {
//				case "ADMIN":
//					user = new Admin(result);
//					break;
//				case "CANDIDATE":
//					user = new Candidate(result);
//					break;
//				case "COMPANY":
//					user = new Company(result);
//					break;
//				default:
//					break;
//				}
//			}
//			close(null, prepare, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return user;
//	}
//	
//	public User findBy(String email, String password) {
//
//		User user = null;
//		
//		String query = "SELECT * FROM kuser u LEFT JOIN company co ON co.id_kuser = u.id LEFT JOIN candidate ca ON ca.id_kuser = u.id WHERE u.email = ? AND u.password = ?";
//		
//		try {
//			Connection conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//			prepare.setString(1, email);
//			prepare.setString(2, password);
//			
//			ResultSet result = prepare.executeQuery();
//			
//			if (result.next()) {
//				switch (result.getString("role")) {
//				case "ADMIN":
//					user = new Admin(result);
//					break;
//				case "CANDIDATE":
//					user = new Candidate(result);
//					break;
//				case "COMPANY":
//					user = new Company(result);
//					break;
//				default:
//					break;
//				}
//			}
//			close(null, prepare, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return user;
//	}
//
//}
