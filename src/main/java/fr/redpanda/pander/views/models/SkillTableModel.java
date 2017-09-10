/**
 * 
 */
package fr.redpanda.pander.views.models;

import java.util.List;

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillTableModel extends SorterTableModel {

	private static final long serialVersionUID = -4831274774359919486L;

	private final List<BaseEntity> skills;
	private final boolean editable;
	private IBaseSkillEntity entity;

	/**
	 * @return the skills
	 */
	public List<BaseEntity> getSkills() {
		return skills;
	}

	/**
	 * @return the entity
	 */
	public IBaseSkillEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(IBaseSkillEntity entity) {
		this.entity = entity;
		fireTableDataChanged();
	}

	/**
	 * @param entity
	 * @param skills
	 * @param TITLE
	 * @param type
	 * 
	 */
	public SkillTableModel(List<BaseEntity> skills, IBaseSkillEntity entity) {
		this.title = new String[] { "Activer", "Compétence" };
		this.skills = skills;
		this.entity = entity;
		this.editable = true;
		initSorter();
	}

	public SkillTableModel(List<BaseEntity> skills, IBaseSkillEntity entity, boolean editable) {
		this.title = new String[] { "Activer", "Compétence" };
		this.skills = skills;
		this.entity = entity;
		this.editable = editable;
		initSorter();
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
		return skills.size() > 0 ? getValueAt(skills.get(rowIndex), columnIndex) : new Object();
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
		return editable == true && columnIndex == 0;
	}

}
