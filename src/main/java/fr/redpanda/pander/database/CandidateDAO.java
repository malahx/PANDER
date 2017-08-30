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

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Role;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.date.DateConverter;

/**
 * @author Gwénolé LE HENAFF
 *
 */
//public class CandidateDAO extends DAOManager implements IDAO<Candidate> {
//
//	private static CandidateDAO instance;
//
//	public static CandidateDAO getInstance() {
//		if (instance == null) {
//			instance = new CandidateDAO();
//		}
//		return (CandidateDAO) instance;
//	}
//
//	/**
//	 * 
//	 * @param conn
//	 *            the connection
//	 * @param query
//	 *            the query to apply
//	 * @param candidate
//	 *            the candidate to pass
//	 * @return prepared request
//	 * @throws SQLException
//	 */
//	private PreparedStatement prepareCandidate(Connection conn, String query, Candidate candidate) throws SQLException {
//		PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//		prepare.setString(1, candidate.getFirstname());
//		prepare.setString(2, candidate.getLastname());
//		prepare.setString(3, DateConverter.getMySqlDate(candidate.getBirthdate()));
//		prepare.setString(4, candidate.getTransport());
//		prepare.setString(5, candidate.getLink1());
//		prepare.setString(6, candidate.getLink2());
//		prepare.setString(7, candidate.getCertificate1());
//		prepare.setString(8, candidate.getCertificate2());
//		prepare.setString(9, candidate.getCv());
//		prepare.setLong(10, candidate.getId());
//		return prepare;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Long)
//	 */
//	@Override
//	public boolean checkExists(Candidate candidate) {
//		if (candidate == null) {
//			return false;
//		}
//		return checkExists(candidate.getId());
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Long)
//	 */
//	@Override
//	public boolean checkExists(Long id) {
//		return id != null && id > 0 && findBy(id) != null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#checkExists(java.lang.Long)
//	 */
//	@Override
//	public boolean validFields(Candidate candidate) {
//		if (candidate == null) {
//			return false;
//		}
//
//		String email = candidate.getEmail();
//		String password = candidate.getPassword();
//		Role role = candidate.getRole();
//		String firstname = candidate.getFirstname();
//		String lastname = candidate.getLastname();
//		if (email == null || email.isEmpty() || password == null || password.isEmpty() || role == null
//				|| firstname == null || firstname.isEmpty() || lastname == null || lastname.isEmpty()) {
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
//	public Candidate create(Candidate candidate) {
//		if (checkExists(candidate) || !validFields(candidate)) {
//			return null;
//		}
//
//		PreparedStatement prepare = null;
//		Connection conn = null;
//
//		String query = "INSERT INTO candidate (firstname, lastname, birthdate, transport, link1, link2, certificate1, certificate2, cv, id_kuser) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			conn.setAutoCommit(false);
//
//			User user = UserDAO.getInstance().create(candidate);
//
//			if (user == null || user.getId() == null) {
//				conn.rollback();
//				conn.setAutoCommit(true);
//				close(conn, prepare);
//				return null;
//			}
//
//			prepare = prepareCandidate(conn, query, candidate);
//			int row = prepare.executeUpdate();
//
//			if (row == 0) {
//				throw new SQLException("insert error");
//			}
//
//			conn.commit();
//			conn.setAutoCommit(true);
//
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//				conn.setAutoCommit(true);
//			} catch (SQLException e1) {
//				throw new RuntimeException(e1);
//			}
//			candidate.setId(null);
//			candidate.setCreatedAt(null);
//			candidate.setUpdatedAt(null);
//			throw new RuntimeException(e);
//		} finally {
//			close(conn, prepare);
//		}
//		return candidate;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#delete(java.lang.Object)
//	 */
//	@Override
//	public Candidate delete(Candidate candidate) {
//		if (!checkExists(candidate)) {
//			return null;
//		}
//		if (delete(candidate.getId())) {
//			candidate.setId(null);
//			candidate.setCreatedAt(null);
//			candidate.setUpdatedAt(null);
//		}
//		return candidate;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#delete(long)
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
//		String query = "DELETE FROM candidate WHERE id_kuser = ?";
//
//		try {
//			conn = getConnection();
//			if (conn == null) {
//				return false;
//			}
//
//			conn.setAutoCommit(false);
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
//			if (!UserDAO.getInstance().delete(id)) {
//				conn.rollback();
//				conn.setAutoCommit(true);
//				close(conn, prepare);
//				return false;
//			}
//
//			conn.commit();
//			conn.setAutoCommit(true);
//
//			value = true;
//
//		} catch (SQLException e) {
//			value = false;
//			try {
//				conn.rollback();
//				conn.setAutoCommit(true);
//			} catch (SQLException e1) {
//				throw new RuntimeException(e1);
//			}
//			throw new RuntimeException(e);
//		} finally {
//			close(conn, prepare);
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
//	public Candidate update(Candidate candidate) {
//		if (!checkExists(candidate) || !validFields(candidate)) {
//			return null;
//		}
//		PreparedStatement prepare = null;
//		Connection conn = null;
//
//		String query = "UPDATE candidate SET firstname = ?, SET lastname = ?, SET birthdate = ?, SET transport = ?, SET link1 = ?, SET link2 = ?, SET certificate1 = ?, SET certificate2 = ?, SET cv = ? WHERE id_kuser = ?";
//
//		try {
//			conn = getConnection();
//			if (conn == null) {
//				return null;
//			}
//
//			conn.setAutoCommit(false);
//
//			Date oldDate = candidate.getUpdatedAt();
//			UserDAO.getInstance().update(candidate);
//
//			if (oldDate.equals(candidate.getUpdatedAt())) {
//				conn.rollback();
//				conn.setAutoCommit(false);
//				conn.close();
//				return null;
//			}
//
//			prepare = prepareCandidate(conn, query, candidate);
//			int row = prepare.executeUpdate();
//
//			if (row == 0) {
//				throw new SQLException("update error");
//			}
//
//			conn.commit();
//			conn.setAutoCommit(true);
//
//		} catch (SQLException e) {
//			try {
//				conn.rollback();
//				conn.setAutoCommit(true);
//			} catch (SQLException e1) {
//				throw new RuntimeException(e1);
//			}
//			throw new RuntimeException(e);
//		} finally {
//			close(conn, prepare);
//		}
//		return candidate;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#findAll()
//	 */
//	@Override
//	public List<Candidate> findAll() {
//		List<Candidate> candidates = new ArrayList<>();
//
//		String query = "SELECT * FROM candidate";
//
//		try {
//			Connection conn = getConnection();
//			if (conn == null) {
//				return candidates;
//			}
//			Statement state = conn.createStatement();
//			ResultSet result = state.executeQuery(query);
//			while (result.next()) {
//				candidates.add(new Candidate(result));
//			}
//			close(conn, state, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return candidates;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.redpanda.pander.database.IDAO#findBy(long)
//	 */
//	@Override
//	public Candidate findBy(long id) {
//		Candidate candidate = null;
//
//		String query = "SELECT * FROM candidate c INNER JOIN kuser u ON u.id = c.id_kuser LEFT JOIN candidate_skill cs ON cs.id_candidate = c.id_kuser LEFT JOIN skill s ON s.id = cs.id_skill WHERE c.id_kuser = ?";
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
//			while (result.next()) {
//				if (candidate == null) {
//					candidate = new Candidate(result);
//				}
//				candidate.getSkills().add(new Skill(result));
//			}
//			close(null, prepare, result);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return candidate;
//	}
//
//}
