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

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -4831274774359919486L;

	private final String[] title = { "Activer", "Compétence" };
	private final List<BaseEntity> skills;
	private final IBaseSkillEntity entity;
	private final TableRowSorter<TableModel> sorter;

	/**
	 * @return the skills
	 */
	public List<BaseEntity> getSkills() {
		return skills;
	}

	/**
	 * @return the sorter
	 */
	public TableRowSorter<TableModel> getSorter() {
		return sorter;
	}

	/**
	 * @param entity
	 * @param skills
	 * @param title
	 * @param type
	 * 
	 */
	public SkillTableModel(List<BaseEntity> skills, IBaseSkillEntity entity) {
		super();
		this.skills = skills;
		this.entity = entity;
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
		return skills.size();
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
		return getValueAt(skills.get(rowIndex), columnIndex);
	}

	/**
	 * 
	 * @param skill
	 *            the object to draw
	 * @param columnIndex
	 *            the index column to show
	 * @return the value of the object
	 */
	public Object getValueAt(BaseEntity skill, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return entity.getSkills().contains(skill);
		case 1:
			return ((Skill) skill).getName();
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		boolean value = (boolean) aValue;
		Skill skill = (Skill) skills.get(rowIndex);
		if (columnIndex == 0) {
			if (value) {
				entity.getSkills().add(skill);
			} else {
				entity.getSkills().remove(skill);
			}
			fireTableDataChanged();
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0;
	}

}
