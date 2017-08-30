/**
 * 
 */
package fr.redpanda.pander.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.utils.file.FileManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class DBManager {

	private static final String DBCONFIG = "dbconfig";
	private static final String CONFIG = "config";

	protected DBManager() {
	}

	protected static DBManager instance = null;

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private Connection connection = null;
	private String dbName = "mydb";

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @return the dbName
	 */
	public String getdbName() {
		return dbName;
	}

	public void connect() {
		connect(CONFIG, DBCONFIG);
	}

	public void connect(String path, String fileName) {
		FileManager fileManager = new FileManager(path, fileName);

		Map<String, Object> datas = fileManager.extractFromPattern();

		connect(datas.get(TypeData.SERVER_ADDRESS).toString(), datas.get(TypeData.PORT).toString(),
				datas.get(TypeData.DB_NAME).toString(), datas.get(TypeData.LOGIN).toString(),
				datas.get(TypeData.PASSWORD).toString());

	}

	public void connect(String serverAddress, String port, String dbName, String login, String password) {
		this.dbName = dbName;
		try {
			if (connection == null || connection.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				connection = DriverManager.getConnection(
						"jdbc:mysql://" + serverAddress + ":" + port + "/" + dbName + "?noAccessToProcedureBodies=true",
						login, password);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
