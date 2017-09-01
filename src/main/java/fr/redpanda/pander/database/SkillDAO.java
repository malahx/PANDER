/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillDAO extends BaseDAO {

	public static final String TABLE = "Skill";
	public static final String ID = "id";
	public static final String LEVEL = "level";	
	public static final String NAME = "name";
	private static final String Object = null;
	private static final String IdObject = null;
	
	
	public SkillDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#insert(fr.redpanda.pander.entities.base.BaseEntity)
	 */
	@Override
	public void insert(BaseEntity item) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#update(fr.redpanda.pander.entities.base.BaseEntity)
	 */
	@Override
	public void update(BaseEntity item) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#delete(fr.redpanda.pander.entities.base.BaseEntity)
	 */
	@Override
	public void delete(BaseEntity item) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.database.IDAOBase#get()
	 */
	@Override
	public List<BaseEntity> get() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public BaseEntity parseResultSetToObject(ResultSet rs) {
		Skill skill = new Skill();
		
		try {
			skill.setId(rs.getDouble(ID));
			skill.setLevel(rs.getInt(LEVEL));
			skill.setName(rs.getString(NAME));
		} catch (SQLException e) {
			e.printStackTrace();
			skill = null;
		}
		
		return skill;
	}

	@Override
	public String parseObjectToString(BaseEntity item) {

        	Skill skill = (Skill) item;
        	String result = "";
        	result += "null,";
        	result += skill.getName();
        	
		return result;
	}

}














