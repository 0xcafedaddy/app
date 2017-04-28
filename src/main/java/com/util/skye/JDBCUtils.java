package com.util.skye;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
	
	/**
	 * 原始的获取数据库连接的方法
	 */
	public static String driverClass;
	public static String url;
	public static String username;
	public static String password;
	
	static{
		driverClass = ResourceBundle.getBundle("config").getString("jdbc.driver");
		url = ResourceBundle.getBundle("config").getString("jdbc.url");
		username = ResourceBundle.getBundle("config").getString("jdbc.username");
		password = ResourceBundle.getBundle("config").getString("jdbc.password");
	}
	public static Connection getConnection(){
		loadDriver();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void loadDriver(){
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 */
	public static void release(Statement stmt,Connection conn){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt,conn);
	}
}
