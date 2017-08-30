/**
 * 
 */
package fr.redpanda.pander.views.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AdminTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 208988814142622942L;
	
	private String[] title;
	private List<Object> objects;

	/**
	 * @return the users
	 */
	public List<Object> getObjects() {
		return objects;
	}
	
	/**
	 * @param objects the objects to set
	 */
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}

	/**
	 * @return the title
	 */
	public String[] getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String[] title) {
		this.title = title;
	}

	/**
	 * 
	 */
	public AdminTableModel() {
		objects = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return objects.size();
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
		Object object = objects.get(rowIndex);
		if (object instanceof User) {
			return getValueAt((User) object, columnIndex);
		}
		if (object instanceof Skill) {
			return getValueAt((Skill) object, columnIndex);
		}
		return object;
	}
	
	/**
	 * 
	 * @param user the object to draw
	 * @param columnIndex the index column to show
	 * @return the value of the object
	 */
	public Object getValueAt(User user, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return user.isDisabled();
		case 1:
			return user.getEmail();

		case 2:
			Date createdAt = user.getCreatedAt();
			Date updateAt = user.getUpdatedAt();
			return updateAt != null ? updateAt : (createdAt != null ? createdAt : new Date());
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * 
	 * @param user the object to draw
	 * @param columnIndex the index column to show
	 * @return the value of the object
	 */
	public Object getValueAt(Skill skill, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return skill.getName();
		case 1:
			return skill.getType().toString();
		default:
			throw new IllegalArgumentException();
		}
	}

}
