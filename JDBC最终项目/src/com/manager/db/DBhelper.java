package com.manager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class DBhelper {
	static String URL="jdbc:mysql://localhost:3306/haha?useSSL=false&&serverTimezone=UTC";
	static String USER="root";
	static String PWD="123456";
	private static Connection connection = null;
	
	/**
	 * 数据库连接
	 * @return
	 */
	public static Connection getCon() {
    	Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(URL,USER,PWD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 关闭资源
	 * @param rs ResultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public static void close(ResultSet rs,PreparedStatement preparedStatement,Connection connection) {
		//关闭ResultSet
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		//关闭PrepareStatement
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		//关闭数据库连接
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = null;
		}
	}
}
