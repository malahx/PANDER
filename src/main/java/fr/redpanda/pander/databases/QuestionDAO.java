/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.entities.Question;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class QuestionDAO extends BaseDAO {

	/** the table */
	public static final String TABLE = "question";

	/** the id */
	public static final String ID = "id";

	/** the title field */
	public static final String TITLE = "title";

	/** The Constructor */
	protected QuestionDAO() {
		super(TABLE, ID);
	}

	private static QuestionDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static QuestionDAO getInstance() {
		if (instance == null) {
			instance = new QuestionDAO();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseDAO#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {
		Question question = new Question();
		try {
			question.setId(rs.getDouble(ID));
			question.setTitle(rs.getString(TITLE));
		} catch (SQLException e) {
			e.printStackTrace();
			question = null;
		}
		return question;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#parse(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public String parse(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#parseUpdate(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdate(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseDAO#fields()
	 */
	@Override
	public String fields() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.IBaseDAO#checkFields(fr.redpanda.pander.
	 * entities.base.BaseEntity)
	 */
	@Override
	public boolean checkFields(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
