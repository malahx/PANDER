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

import fr.redpanda.pander.databases.base.DAO;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.utils.file.FileManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class DAOManager extends DAO {

	private static final String DB_SQL = "pander.sql";
	private static final String DATA_SQL = "data.sql";
	private static final String FILE_CONFIG = "dbconfig";
	private static final String PATH_CONFIG = "config";

	protected DAOManager() {
		super();
		connectCrea();
		if (canConnect()) {
			connect();
		} else {
			createDB();
			initDB(PATH_CONFIG, DB_SQL);
			initDB(PATH_CONFIG, DATA_SQL);
		}
	}

	private static DAOManager instance = null;

	public static DAOManager getInstance() {
		if (instance == null) {
			instance = new DAOManager();
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
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = createConnection.createStatement();
			rs = statement.executeQuery("SHOW DATABASES;");
			while (rs.next()) {
				if (rs.getString(1).equals(dbName)) {
					close(statement, rs);
					return true;
				}
			}
			close(statement, rs);
		} catch (SQLException e) {
			e.printStackTrace();
			close(statement, rs);
		}
		return false;
	}

	private void createDB() {
		Statement statement = null;
		try {
			statement = createConnection.createStatement();
			statement.execute("CREATE DATABASE IF NOT EXISTS " + dbName + ";");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			close(statement);
		}

	}

	// private void deleteDB() {
	//
	// try {
	// Statement statement = createConnection.createStatement();
	// statement.execute("DROP DATABSE " + dbName + ";");
	// statement.close();
	// connection.close();
	// connection = null;
	// createConnection.close();
	// createConnection = null;
	// instance = null;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }

	private void initDB(String path, String fileName) {
		connect();

		String queries = readSql(path, fileName);
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			for (String s : queries.split(";")) {
				if (s.equals("") || s.equals("\n")) {
					continue;
				}
				statement.execute(s);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			close(statement);
		}
	}

	private String readSql(String path, String fileName) {
		FileManager fileManager = new FileManager(path, fileName);
		StringBuilder queries = new StringBuilder();

		for (String s : fileManager.loadFromFile()) {
			if (s.startsWith("#") || s.startsWith("USE ") || s.startsWith("CREATE DATABASE")
					|| s.startsWith("DROP DATABASE") || s.equals("")) {
				continue;
			}
			queries.append(s).append('\n');
		}
		return queries.toString();
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
