/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.redpanda.pander.databases.base.BaseDAO;
import fr.redpanda.pander.entities.Answer;
import fr.redpanda.pander.entities.Mind;
import fr.redpanda.pander.entities.Question;
import fr.redpanda.pander.entities.base.BaseEntity;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AnswerDAO extends BaseDAO {

	/** the table */
	public static final String TABLE = "answer";

	/** the id */
	public static final String ID = "id";

	/** the title field */
	public static final String TITLE = "title";

	/** the id_mind field */
	public static final String ID_MIND = "id_mind";

	/** the id_question field */
	public static final String ID_QUESTION = "id_question";

	/** The Constructor */
	protected AnswerDAO() {
		super(TABLE, ID);
	}

	private static AnswerDAO instance = null;

	/**
	 * get and instance the singleton
	 * 
	 * @return the singleton
	 */
	public static AnswerDAO getInstance() {
		if (instance == null) {
			instance = new AnswerDAO();
		}
		return instance;
	}

	public Question get(Question question) {
		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " WHERE " + ID_QUESTION + " = " + question.getId());
		try {
			while (rs.next()) {
				Answer answer = (Answer) parse(rs);

				question.getAnswers().add(answer);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return question;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.IBaseDAO#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parse(ResultSet rs) {

		Answer answer = new Answer();
		try {
			answer.setId(rs.getDouble(ID));
			answer.setTitle(rs.getString(TITLE));
			answer.setMind((Mind) MindDAO.getInstance().get(rs.getDouble(ID_MIND)));
		} catch (SQLException e) {
			e.printStackTrace();
			answer = null;
		}
		return answer;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#insert(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public BaseEntity insert(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#update(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public int update(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.databases.base.BaseDAO#delete(fr.redpanda.pander.entities.
	 * base.BaseEntity)
	 */
	@Override
	public int delete(BaseEntity entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#delete()
	 */
	@Override
	public int delete() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#get(double)
	 */
	@Override
	public BaseEntity get(double id) {
		ResultSet rs = executeQuery("SELECT * FROM " + TABLE + " WHERE " + ID + " = " + id);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.databases.base.BaseDAO#get()
	 */
	@Override
	public List<BaseEntity> get() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
