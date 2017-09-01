/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.util.List;

import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public interface IDAOBase {
	public ResultSet executeRequest(String request);
	public BaseEntity parseResultSetToObject(ResultSet rs);
	public String parseObjectToString(BaseEntity item);
	public void insert(BaseEntity item);
	public void update(BaseEntity item);
	public void delete(BaseEntity item);
	public void delete();
	public BaseEntity get(double id);
	public List<BaseEntity> get();
}
