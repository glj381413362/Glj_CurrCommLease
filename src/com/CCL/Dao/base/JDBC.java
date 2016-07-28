package com.CCL.Dao.base;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//用来加载数据库驱动程序，并且提供创建和关闭数据库的方法
public class JDBC {
	// 数据库驱动
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// 数据库地址
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:YMDB";
	// 用户名
	private static String DBUSER = "YM";
	// 密码
	private static String PASSWORD = "admin";

	private static Connection conn = null;

	// 从配置文件中加载配置
	static {
		Properties profile = new Properties();
		FileReader fileReader = null;
		;
		try {
			// fileReader = new FileReader("config/db.properties");
			// profile.load(fileReader);
			// DRIVER = profile.getProperty("database.driverClassName");
			// URL = profile.getProperty("database.url");
			// DBUSER = profile.getProperty("database.username");
			// PASSWORD = profile.getProperty("database.password");
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static Connection openCon() {
		// Connection conn = null;
		if (conn == null) {

			try {
				conn = DriverManager.getConnection(URL, DBUSER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}

	public static void closeCon() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		Connection openCon = openCon();

		System.out.println(openCon);
		System.out.println(URL);
		System.out.println(DBUSER);
		System.out.println(PASSWORD);

		closeCon();

	}
}
