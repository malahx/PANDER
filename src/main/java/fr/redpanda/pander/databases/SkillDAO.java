/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.entities.Skill;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.entities.base.IBaseSkillEntity;
import fr.redpanda.pander.utils.StringManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class SkillDAO extends BaseDAO {

	/** the table */
	public static final String TABLE = "skill";

	/** the id */
	public static final String ID = "id";

	/** the name field */
	public static final String NAME = "name";

	/** the type field */
	public static final String TYPE = "type";

	/** The Constructor */
	protected SkillDAO() {
		super(TABLE, ID);
	}

	private static SkillDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static SkillDAO getInstance() {
		if (instance == null) {
			instance = new SkillDAO();
		}
		return instance;
	}

	/**
	 * get a {@link BaseEntity} by name
	 * 
	 * @param name
	 *            the name to search
	 * @return a {@link BaseEntity}
	 */
	public BaseEntity get(String name) {
		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " WHERE " + NAME + " = '" + name + "'");
		BaseEntity entity = null;
		try {
			if (rs.next()) {
				entity = parse(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * Get and add all skills of an entity
	 * 
	 * @param table
	 * @param skillId
	 * @param otherId
	 * @param entity
	 * @return
	 */
	public IBaseSkillEntity getSkills(String table, String skillId, String otherId, IBaseSkillEntity entity) {

		ResultSet rs = executeQuery(
				"SELECT " + skillId + " FROM " + table + " WHERE " + otherId + " = " + entity.getId());
		try {
			while (rs.next()) {
				entity.getSkills().add((Skill) get(rs.getDouble(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;

	}

	/**
	 * Insert all skills of an entity to the database
	 * 
	 * @param table
	 * @param skillId
	 * @param otherId
	 * @param entity
	 * @return
	 */
	public int insertSkills(String table, String skillId, String otherId, IBaseSkillEntity entity) {
		int result = 0;
		deleteSkills(table, otherId, entity);
		for (Skill skill : entity.getSkills()) {
			result += execute("INSERT INTO " + table + " (" + otherId + "," + skillId + ") VALUES (" + entity.getId()
					+ "," + skill.getId() + ")");
		}
		return result;
	}

	/**
	 * Delete all skills of an entity to the database
	 * 
	 * @param table
	 * @param otherId
	 * @param entity
	 * @return
	 */
	public int deleteSkills(String table, String otherId, IBaseSkillEntity entity) {
		return execute("DELETE FROM " + table + " WHERE " + otherId + " = " + entity.getId());
	}

	/**
	 * Delete all linked skills of the table
	 * 
	 * @param table
	 * @return
	 */
	public int deleteSkills(String table) {
		return execute("DELETE FROM " + table);
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
		return "'" + skill.getName() + "','" + skill.getType().toString() + "'";
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
		// TODO à revoir en stringbuilder
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
		return NAME + "," + TYPE;
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
		if (skill == null || skill.getName() == null) {
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
		return get(((Skill) entity).getName()) != null;
	}

}
