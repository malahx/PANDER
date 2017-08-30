/**
 * 
 */
package fr.redpanda.pander;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.redpanda.pander.database.SkillDAO;
import fr.redpanda.pander.managers.ViewsManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//ViewsManager.getInstance().start();
		
		SkillDAO dao = new SkillDAO();
		ResultSet resultSet = dao.executeRequest("SHOW TABLES;");
		try {
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
