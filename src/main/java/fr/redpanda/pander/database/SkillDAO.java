/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillDAO extends BaseDAO {

	public static final String TABLE = "skill";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String TYPE = "type";

	public SkillDAO() {
		super(TABLE, ID);
	}

	public BaseEntity getByName(String name) {
		ResultSet rs = query("SELECT * FROM " + TABLE + " WHERE " + NAME + " = " + name);
		BaseEntity entity = null;
		try {
			rs.next();
			entity = parse(rs);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Skill skill = new Skill();
		try {
			skill.setId(rs.getDouble(ID));
			skill.setName(rs.getString(NAME));
			skill.setType(StringManager.getTypeSkillFrom(rs.getString(TYPE)));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			skill = null;
		}
		return skill;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#parse(fr.redpanda.pander.entities.base.
	 * BaseEntity)
	 */
	@Override
	public String parse(BaseEntity entity) {
		Skill skill = (Skill) entity;
		return "('" + skill.getName() + "','" + skill.getType().toString() + "')";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#parseUpdate(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public String parseUpdate(BaseEntity entity) {

		String result = "";
		Skill skill = (Skill) entity;

		result += NAME + " = '" + skill.getName() + "',";
		result += TYPE + " = '" + skill.getType() + "'";
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#fields()
	 */
	@Override
	public String fields() {
		return "(" + NAME + "," + TYPE + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkFields(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public boolean checkFields(BaseEntity entity) {

		Skill skill = (Skill) entity;
		if (skill.getName() == null) {
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.database.IDAOBase#checkUniqueFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkUniqueFields(BaseEntity entity) {
		return getByName(((Skill) entity).getName()) != null;
	}

}
