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

import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CompanyDAO extends DAOManager implements IDAO<Company> {
	
	public static CompanyDAO getInstance() {
		if (instance == null) {
			instance = new CompanyDAO();
		}
		return (CompanyDAO) instance;
	}

	private PreparedStatement prepareCandidate(Connection conn, String query, Company company) throws SQLException {
		PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		prepare.setString(0, company.getName());
		prepare.setString(1, company.getSiret());
		prepare.setString(2, company.getContact());
		prepare.setString(3, company.getLink());
		prepare.setLong(4, company.getId());
		return prepare;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#create(java.lang.Object)
	 */
	public Company create(Company company) {

		PreparedStatement prepare = null;
		Connection conn = null;

		String query = "INSERT INTO company (name, siret, contact, link, id_kuser) VALUES (?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			if (conn == null) {
				return company;
			}

			conn.setAutoCommit(false);

			User user = UserDAO.getInstance().create(company);
			
			if (user.getId() == null) {
				conn.rollback();
				conn.setAutoCommit(true);
				close(conn, prepare);
				return company;
			}

			prepare = prepareCandidate(conn, query, company);
			int row = prepare.executeUpdate();

			if (row == 0) {
				throw new SQLException("insert error");
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			company.setId(null);
			company.setCreatedAt(null);
			company.setUpdatedAt(null);
			throw new RuntimeException(e);
		} finally {
			close(conn, prepare);
		}
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#delete(java.lang.Object)
	 */
	@Override
	public Company delete(Company company) {
		delete(company.getId());
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#delete(long)
	 */
	@Override
	public boolean delete(long id) {
		PreparedStatement prepare = null;
		Connection conn = null;
		Boolean value;

		String query = "DELETE FROM company WHERE id_kuser = ?";

		try {
			conn = getConnection();
			if (conn == null) {
				return false;
			}

			conn.setAutoCommit(false);

			prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(0, id);

			int row = prepare.executeUpdate();

			if (row == 0) {
				throw new SQLException("deletion error");
			}

			if (!UserDAO.getInstance().delete(id)) {
				conn.rollback();
				conn.setAutoCommit(true);
				close(conn, prepare);
				return false;
			}

			conn.commit();
			conn.setAutoCommit(true);

			value = true;

		} catch (SQLException e) {
			value = false;
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
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
	public Company update(Company company) {
		PreparedStatement prepare = null;
		Connection conn = null;

		String query = "UPDATE company SET name = ?, SET siret = ?, SET contact = ?, SET link = ? WHERE id_kuser = ?";

		try {
			conn = getConnection();
			if (conn == null) {
				return company;
			}

			conn.setAutoCommit(false);

			Date oldDate = company.getUpdatedAt();
			UserDAO.getInstance().update(company);
			
			if (oldDate.equals(company.getUpdatedAt())) {
				conn.rollback();
				conn.setAutoCommit(false);
				conn.close();
				return company;
			}
			
			prepare = prepareCandidate(conn, query, company);
			int row = prepare.executeUpdate();

			if (row == 0) {
				throw new SQLException("update error");
			}
			
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			close(conn, prepare);
		}
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#findAll()
	 */
	@Override
	public List<Company> findAll() {
		List<Company> companies = new ArrayList<>();
		
		String query = "SELECT * FROM company";
		
		try {
			Connection conn = getConnection();
			if (conn == null) {
				return companies;
			}
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);
			while (result.next()) {
				companies.add(new Company(result));
			}
			close(conn, state, result);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return companies;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAO#findBy(long)
	 */
	@Override
	public Company findBy(long id) {
		Company company = null;
		
		String query = "SELECT * FROM company c INNER JOIN kuser u ON u.id = c.id_kuser INNER JOIN company_skill cs ON cs.id_company = c.id_kuser INNER JOIN skill s ON s.id = cs.id_skill WHERE c.id_kuser = ?";
		
		try {
			Connection conn = getConnection();
			if (conn == null) {
				return null;
			}

			PreparedStatement prepare = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(0, id);
			
			ResultSet result = prepare.executeQuery();
			
			while (result.next()) {
				if (company == null) {
					company = new Company(result);
				}
				company.getJobs().add(new Job(result));
			}
			close(conn, prepare, result);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return company;
	}
	
}
