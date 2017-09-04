/**
 * 
 */
package fr.redpanda.pander.views.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.redpanda.pander.businesscode.Matching;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7656754488588885879L;

	private final String[] title;
	private final List<Matching> matchings;
	private final TableRowSorter<TableModel> sorter;
	private final boolean isCandidate;

	/**
	 * @return the matchings
	 */
	public List<Matching> getMatchings() {
		return matchings;
	}

	/**
	 * @return the sorter
	 */
	public TableRowSorter<TableModel> getSorter() {
		return sorter;
	}

	public void add(Matching matching) {
		matchings.add(matching);
		fireTableDataChanged();
	}

	/**
	 * @param title
	 * @param matchings
	 */
	public MatchingTableModel(List<Matching> matchings, boolean isCandidate) {
		super();
		this.title = isCandidate ? new String[] { "Match", "Nom", "Email", "Poste" }
				: new String[] { "Match", "Prénom", "Nom", "Email" };
		this.matchings = matchings;
		this.isCandidate = isCandidate;
		this.sorter = new TableRowSorter<TableModel>(this);
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		for (int i = 0; i < title.length; i++) {
			sortKeys.add(new RowSorter.SortKey(i, SortOrder.DESCENDING));
		}
		sorter.setSortKeys(sortKeys);
		sorter.setSortsOnUpdates(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return matchings.size();
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
