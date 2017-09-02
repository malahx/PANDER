/**
 * 
 */
package fr.redpanda.pander.views.models;

import javax.swing.AbstractListModel;

import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;

/**
 * @author Gwénolé LE HENAFF
 * @param <E>
 *
 */
public class JobListModel extends AbstractListModel<Job> {

	private static final long serialVersionUID = 594951988845602480L;

	private final Company company;

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	public void add(Job job) {
		company.getJobs().add(job);
		refresh();
	}

	public void remove(Job job) {
		company.getJobs().remove(job);
		refresh();
	}

	public void refresh() {
		this.fireContentsChanged(this, getSize() - 1, getSize() - 1);
	}

	/**
	 * @param company
	 */
	public JobListModel(Company company) {
		super();
		this.company = company;
	}

	@Override
	public int getSize() {
		return company.getJobs().size();
	}

	@Override
	public Job getElementAt(int index) {
		return company.getJobs().get(index);
	}

}
