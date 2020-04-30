package com.example.dao;
  
import java.sql.Connection;
import java.sql.SQLException;

public class DBClose {
	//간단하게 connection만 close하는 걸로.
	public static void close(Connection conn) {
		try {
			if(conn != null) conn.close();
		}catch(SQLException ex) {}
	}
}
