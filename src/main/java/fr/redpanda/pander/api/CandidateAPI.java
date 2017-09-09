/**
 * 
 */
package fr.redpanda.pander.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(path = RouterAPI.PATH_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Candidate get(@PathVariable double id) {
		return (Candidate) CandidateDAO.getInstance().get(id);
	}

	//curl -H "Content-Type: application/json" -d "{\"email\":\"abc@abc.abc\",\"password\":\"abc\",\"firstname\":\"abc\",\"lastname\":\"abc\"}" http://localhost:8080/candidate -X POST
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Candidate create(@RequestBody Candidate candidate) {
		CandidateDAO.getInstance().insert(candidate);
		return candidate;
	}

	//curl -H "Content-Type: application/json" -d "{\"email\":\"abc@abc.abc\",\"password\":\"abc\",\"firstname\":\"abc\",\"lastname\":\"abc\"}" http://localhost:8080/candidate -X PUT
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Candidate update(@RequestBody Candidate candidate) {
		CandidateDAO.getInstance().update(candidate);
		return candidate;
	}
	
	@RequestMapping(path = RouterAPI.PATH_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean delete(@PathVariable double id) {
		return CandidateDAO.getInstance().delete(id) > 0 ? true : false;
	}

}