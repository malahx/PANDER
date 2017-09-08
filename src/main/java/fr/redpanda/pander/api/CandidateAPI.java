/**
 * 
 */
package fr.redpanda.pander.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.constant.RouterAPI;

/**
 * @author Gwénolé LE HENAFF
 *
 */
@RestController
@RequestMapping(path = RouterAPI.CANDIDATE)
public class CandidateAPI {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAll() {
		List<Candidate> candidates = new ArrayList<>();
		for (BaseEntity entity : CandidateDAO.getInstance().get()) {
			candidates.add((Candidate) entity);
		}
		return candidates;

	}

}