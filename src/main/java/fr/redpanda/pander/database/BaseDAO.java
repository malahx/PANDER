/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import com.sun.glass.ui.Window.Level;
import com.sun.xml.internal.bind.v2.runtime.Name;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseDAO implements IDAOBase {
	
	private String table;
	private String id;
	

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#insert(fr.redpanda.pander.entities.base.BaseEntity)
	 */
	@Override
	public void insert(BaseEntity item) {
		executeRequest("INSERT INTO "+ table +" VALUES "+ "(" + parseObjectToString(item) + " )");

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

		public BaseDAO (String table, String id) {
			this.table = table;
			this.id = id;
			}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#executeRequest(java.lang.String)
	 */
	@Override
	public ResultSet executeRequest(String request) {

		ResultSet result = null;

		try {
			Statement statement = DBManager.getInstance().getConnection().createStatement();
			result = statement.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#delete(fr.redpanda.pander.entities.base.BaseEntity)
	 */
	@Override
	public void delete(BaseEntity item) {
		// TODO Auto-generated method stub
		executeRequest("DELETE FROM "+ table +" WHERE "+ id + " = "+ item.getId());
	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#delete()
	 */
	@Override
	public void delete() {
		executeRequest("DELETE FROM " + table);
		
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		ResultSet rs = executeRequest("SELECT * FROM " + table + " = " + " WHERE " +  this.id + " = " + id);
		BaseEntity entity = null;
		try {
			rs.next();
			entity = parseResultSetToObject(rs);
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#get()
	 */
	@Override
	public List<BaseEntity> get() {
		List<BaseEntity> entities = new ArrayList<BaseEntity>();
		ResultSet rs = executeRequest ("SELECT * FROM " + table);
				
				try {
					while(rs.next()){
						entities.add(parseResultSetToObject(rs));
					}
				} catch (SQLException e) {
					e.printStackTrace();
					}
				
		return entities;
	}

	

}
