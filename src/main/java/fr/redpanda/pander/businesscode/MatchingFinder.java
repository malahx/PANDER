/**
 * 
 */
package fr.redpanda.pander.businesscode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingFinder {

	private List<BaseEntity> matchingDone;

	protected MatchingFinder() {
		super();
	}

	protected static MatchingFinder instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static MatchingFinder getInstance() {
		if (instance == null) {
			instance = new MatchingFinder();
		}
		return instance;
	}

	public List<Matching> findBestResult(User user) {

		boolean isCandidate = user instanceof Candidate;

		List<Matching> matchings = new ArrayList<>();
		Company company = null;
		Candidate candidate = null;
		String query = null;
		if (isCandidate) {
			candidate = (Candidate) user;
			query = "SELECT * FROM " + UserDAO.TABLE + " INNER JOIN " + CompanyDAO.TABLE + " ON " + CompanyDAO.ID
					+ " = " + UserDAO.ID + " INNER JOIN " + JobDAO.TABLE + " ON " + JobDAO.ID_COMPANY + " = "
					+ CompanyDAO.ID + " WHERE " + JobDAO.ID + " NOT IN (" + matchingDone() + ") GROUP BY " + UserDAO.ID
					+ " ORDER BY count(" + UserDAO.ID + ") DESC LIMIT 10";
		} else {
			company = (Company) user;
			query = "SELECT * FROM " + UserDAO.TABLE + " INNER JOIN " + CandidateDAO.TABLE + " ON " + CandidateDAO.ID
					+ " = " + UserDAO.ID + " INNER JOIN " + CandidateDAO.TABLE_SKILL + " ON "
					+ CandidateDAO.ID_CANDIDATE + " = " + CandidateDAO.ID + " WHERE " + UserDAO.ID + " NOT IN ("
					+ matchingDone() + ") GROUP BY " + UserDAO.ID + " ORDER BY count(" + UserDAO.ID + ") DESC LIMIT 10";
		}

		ResultSet rs = UserDAO.getInstance().executeQuery(query);
		try {
			while (rs.next()) {
				if (isCandidate) {
					candidate = (Candidate) CandidateDAO.getInstance().parse(rs);
				} else {
					company = (Company) user;
				}
				for (Job job : company.getJobs()) {
					matchings.add(new Matching(candidate, company, job));
				}
				matchingDone.add(isCandidate ? candidate : company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matchings;

	}

	/**
	 * @return
	 */
	private String matchingDone() {
		String result = null;
		for (BaseEntity entity : matchingDone) {
			if (result == null) {
				result = String.valueOf(entity.getId());
			} else {
				result += "," + entity.getId();
			}
		}
		return result;
	}

}
