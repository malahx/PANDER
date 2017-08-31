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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet resultSet) {

		Skill skill = new Skill();
		try {
			skill.setId(resultSet.getDouble(ID));
			skill.setName(resultSet.getString(NAME));
			skill.setType(StringManager.getTypeSkillFrom(resultSet.getString(TYPE)));
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
	 * @see fr.redpanda.pander.database.IDAOBase#fields()
	 */
	@Override
	public String fields() {
		return "(" + NAME + "," + TYPE + ")";
	}

}
