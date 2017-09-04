/**
 * 
 */
package fr.redpanda.pander.views.models;

import java.util.List;

import fr.redpanda.pander.businesscode.Matching;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingTableModel extends SorterTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656754488588885879L;

	private final List<Matching> matchings;
	private final boolean isCandidate;

	/**
	 * @return the matchings
	 */
	public List<Matching> getMatchings() {
		return matchings;
	}

	public void add(Matching matching) {
		matchings.add(matching);
		fireTableDataChanged();
	}

	/**
	 * @param title
	 * @param matchings
	 */
	public MatchingTableModel(String[] title, List<Matching> matchings, boolean isCandidate) {
		this.title = title;
		this.matchings = matchings;
		this.isCandidate = isCandidate;
		initSorter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return matchings != null ? matchings.size() : 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return title.length;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnName(int, int)
	 */
	@Override
	public String getColumnName(int column) {
		return title[column];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return matchings.size() > 0 ? getValueAt(matchings.get(rowIndex), columnIndex) : new Object();
	}

	/**
	 * 
	 * @param matching
	 *            the object to draw
	 * @param columnIndex
	 *            the index column to show
	 * @return the value of the object
	 */
	public Object getValueAt(Matching matching, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.valueOf(matching.getMatchingCalculation()) + "%";
		case 1:
			return isCandidate ? matching.getCompany().getName() : matching.getCandidate().getFirstname();
		case 2:
			return isCandidate ? matching.getCompany().getEmail() : matching.getCandidate().getLastname();
		case 3:
			return isCandidate ? matching.getJob().getName() : matching.getCandidate().getEmail();
		default:
			throw new IllegalArgumentException();
		}
	}

}
