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

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class SorterTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -6462455074540030580L;
	
	protected String[] title;
	private TableRowSorter<TableModel> sorter;

	/**
	 * @return the sorter
	 */
	public TableRowSorter<TableModel> getSorter() {
		return sorter;
	}

	public void initSorter() {

		this.sorter = new TableRowSorter<TableModel>(this);
		List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		for (int i = 0; i < title.length; i++) {
			sortKeys.add(new RowSorter.SortKey(i, SortOrder.DESCENDING));
		}
		sorter.setSortKeys(sortKeys);
		sorter.setSortsOnUpdates(true);
	}


}
