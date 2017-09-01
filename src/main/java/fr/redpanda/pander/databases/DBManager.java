/**
 * 
 */
package fr.redpanda.pander.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.utils.file.FileManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class DBManager {

	private static final String DB_SQL = "pander.sql";
	private static final String FILE_CONFIG = "dbconfig";
	private static final String PATH_CONFIG = "config";

	protected DBManager() {
		connectCrea();
		if (canConnect()) {
			connect();
		} else {
			createDB();
			initDB(PATH_CONFIG, DB_SQL);
		}
	}

	protected static DBManager instance = null;

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private Connection createConnection = null;
	private Connection connection = null;
	private String dbName = "mydb";

	/**
	 * @return the createConnection
	 */
	public Connection getCreateConnection() {
		return createConnection;
	}

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

	private boolean canConnect() {
		try {
			Statement statement = createConnection.createStatement();
			ResultSet rSet = statement.executeQuery("SHOW DATABASES;");
			while (rSet.next()) {
				if (rSet.getString(1).equals(dbName)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void createDB() {

		try {
			Statement statement = createConnection.createStatement();
			statement.execute("CREATE DATABASE IF NOT EXISTS " + dbName + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	private void deleteDB() {
//
//		try {
//			Statement statement = createConnection.createStatement();
//			statement.execute("DROP DATABSE " + dbName + ";");
//			statement.close();
//			connection.close();
//			connection = null;
//			createConnection.close();
//			createConnection = null;
//			instance = null;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

	private void initDB(String path, String fileName) {
		connect();

		FileManager fileManager = new FileManager(path, fileName);
		String queries = "";

		for (String s : fileManager.loadFromFile()) {
			if (s.startsWith("#") || s.startsWith("USE ") || s.startsWith("CREATE DATABASE")
					|| s.startsWith("DROP DATABASE") || s.equals("")) {
				continue;
			}
			queries += s + "\n";
		}

		try {
			Statement statement = connection.createStatement();
			for (String s : queries.split(";")) {
				if (s.equals("") || s.equals("\n")) {
					continue;
				}
				statement.execute(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		connect(PATH_CONFIG, FILE_CONFIG);
	}

	public void connect(String path, String fileName) {
		FileManager fileManager = new FileManager(path, fileName);

		Map<String, Object> datas = fileManager.extractFromPattern();
		String password = datas.containsKey(TypeData.PASSWORD) ? datas.get(TypeData.PASSWORD).toString() : "";

		connect(datas.get(TypeData.SERVER_ADDRESS).toString(), datas.get(TypeData.PORT).toString(),
				datas.get(TypeData.DB_NAME).toString(), datas.get(TypeData.LOGIN).toString(), password);

	}

	public void connect(String serverAddress, String port, String dbName, String login, String password) {
		this.dbName = dbName;
		try {
			if (connection == null) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				connection = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/" + dbName,
						login, password);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void connectCrea() {
		connectCrea(PATH_CONFIG, FILE_CONFIG);
	}

	public void connectCrea(String path, String fileName) {
		FileManager fileManager = new FileManager(path, fileName);

		Map<String, Object> datas = fileManager.extractFromPattern();
		String password = datas.containsKey(TypeData.PASSWORD) ? datas.get(TypeData.PASSWORD).toString() : "";

		dbName = datas.get(TypeData.DB_NAME).toString();

		connectCrea(datas.get(TypeData.SERVER_ADDRESS).toString(), datas.get(TypeData.PORT).toString(),
				datas.get(TypeData.LOGIN).toString(), password);

	}

	public void connectCrea(String serverAddress, String port, String login, String password) {
		try {
			if (createConnection == null) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				createConnection = DriverManager.getConnection("jdbc:mysql://" + serverAddress + ":" + port + "/",
						login, password);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
