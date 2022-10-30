package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			if (conn == null) {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				conn = DriverManager.getConnection(url, properties);
			}
		} catch (SQLException ex) {
			throw new DbException(ex.getMessage());
		}

		return conn;
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException ex) {
			throw new DbException(ex.getMessage());
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new DbException(ex.getMessage());
			}
		}

	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException ex) {
				throw new DbException(ex.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rt) {
		if (rt != null) {
			try {
				rt.close();
			} catch (SQLException ex) {
				throw new DbException(ex.getMessage());
			}
		}
	}

}
