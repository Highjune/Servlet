package com.example.dao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() { //new쓰기 싫어서 static
		//2. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Not Found");
		}
		//3. DB Connection
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.1:1521:ORCL", "scott", "tiger"); //url은 항상 jdbc로 시작
		} catch (SQLException e) {
			System.out.println("DB Connection Failure");
		}
		return conn; //연결되지 않으면 null (위에서 null 줬으니까)
	}
}
