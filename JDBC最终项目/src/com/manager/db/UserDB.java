package com.manager.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
	public static boolean login(String userName,String userPwd) {
		PreparedStatement preparedStatement = null;
		ResultSet rSet =null;
		int count = 0;
		boolean flag = false;
		Connection connection = DBhelper.getCon();
		String sqlString= "select count(*) from user where userName=? and userPwd=?";
		try {
			preparedStatement = connection.prepareStatement(sqlString);
			//设置参数,执行sql语句
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userPwd);
		    rSet = preparedStatement.executeQuery();
		    
		    //遍历ResultSet
		    while (rSet.next()) {
		    	count = rSet.getInt(1);
			}
		    
		    if (count>0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBhelper.close(rSet, preparedStatement, connection);
		}
		return flag;
	}
}
