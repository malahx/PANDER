/**
 * 
 */
package fr.redpanda.pander.views.models;

import javax.swing.AbstractListModel;

import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;

/**
 * @author Gwénolé LE HENAFF
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

	/**
	 * Add a job to the list
	 * 
	 * @param job
	 */
	public void add(Job job) {
		company.getJobs().add(job);
		refresh();
	}

	/**
	 * Remove a job from a list
	 * 
	 * @param job
	 */
	public void remove(Job job) {
		company.getJobs().remove(job);
		refresh();
	}

	/**
	 * Refresh datas
	 */
	public void refresh() {
		this.fireContentsChanged(this, getSize() - 1, getSize() - 1);
	}

	/**
	 * The constructor
	 * 
	 * @param company
	 */
	public JobListModel(Company company) {
		super();
		this.company = company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return company.getJobs().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Job getElementAt(int index) {
		return company.getJobs().get(index);
	}

}
