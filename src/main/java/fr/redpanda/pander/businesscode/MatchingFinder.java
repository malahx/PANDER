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

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingFinder {

	private final List<Matching> matchingsDone;
	// Map<double, int> skillCount;
	private final boolean isCandidate;
	private final User user;

	/**
	 * @return the matchingsDone
	 */
	public List<Matching> getMatchingsDone() {
		return matchingsDone;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	public MatchingFinder(User user) {
		super();
		this.matchingsDone = new ArrayList<>();
		this.isCandidate = user instanceof Candidate;
		this.user = user;
	}

	public List<Matching> findBestResult() {

		List<Matching> matchings = new ArrayList<>();
		Company company = null;
		Candidate candidate = null;
		String query = null;
		if (isCandidate) {
			candidate = (Candidate) user;
			query = "SELECT * FROM " + UserDAO.TABLE + " INNER JOIN " + CompanyDAO.TABLE + " ON " + CompanyDAO.ID
					+ " = " + UserDAO.ID + " INNER JOIN " + JobDAO.TABLE + " ON " + JobDAO.ID_COMPANY + " = "
					+ CompanyDAO.ID + " WHERE " + JobDAO.ID_JOB + " NOT IN (" + matchingDone() + ") GROUP BY "
					+ UserDAO.ID + " ORDER BY count(" + UserDAO.ID + ") DESC LIMIT 10";
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
					candidate = (Candidate) user;
					company = (Company) CompanyDAO.getInstance().parse(rs);
					JobDAO.getInstance().get(company);
					for (Job job : company.getJobs()) {
						JobDAO.getInstance().getSkills(job);
					}
				} else {
					company = (Company) user;
					candidate = (Candidate) CandidateDAO.getInstance().parse(rs);
					CandidateDAO.getInstance().getSkills(candidate);
				}
				for (Job job : company.getJobs()) {
					Matching matching = new Matching(candidate, company, job);
					matchings.add(matching);
					matchingsDone.add(matching);
				}
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
		String result = "0";
		for (Matching matching : matchingsDone) {
			double id = isCandidate ? matching.getJob().getId() : matching.getCandidate().getId();
			result += "," + String.valueOf(id);
		}
		System.out.println(result);
		return result;
	}

}
