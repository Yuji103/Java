package com.manager.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.manager.pojo.Company;


public class CompanyDB {
	/**
	 * 添加员工信息
	 * @param company
	 * @return 是否添加成功flag
	 */
	public static boolean add(Company company) {
		Connection connection =DBhelper.getCon();
		PreparedStatement preparedStatement=null;
		boolean flag=false;
		int count=0;
		if (connection!=null) {
			try {
				String sqlString ="insert into Company values(?,?,?,?,?)";
				preparedStatement=connection.prepareStatement(sqlString);
				preparedStatement.setInt(1, company.getId());
				preparedStatement.setString(2,company.getName());
				preparedStatement.setInt(3, company.getAge());
				preparedStatement.setString(4,company.getAddress());
				preparedStatement.setDouble(5, company.getSalary());
				count=  preparedStatement.executeUpdate();
				
				if (count>0) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				DBhelper.close(null,preparedStatement,connection);
			}
		}
		return flag;	 
}
	
	public static ArrayList<Company> getAllCompany(){
		ArrayList<Company> coms = new ArrayList<Company>();
		PreparedStatement preparedStatement = null;
		ResultSet rSet =null;
		boolean flag = false;
		Connection connection = DBhelper.getCon();
		String sqlString= "select * from company";
		if (connection!=null) {
		try {
			preparedStatement = connection.prepareStatement(sqlString);
		    rSet = preparedStatement.executeQuery();
		    //遍历ResultSet
		    while (rSet.next()) {
		    	int id = rSet.getInt(1);
		    	String name = rSet.getString(2);
		    	int age = rSet.getInt(3);
		    	String address = rSet.getString(4);
		    	double salary = rSet.getDouble(5);
		    	Company company = new Company(id,name,age,address,salary);
		    	coms.add(company);
		    }
		    
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBhelper.close(rSet, preparedStatement, connection);
		}
		}
		return coms;
	}
	
	/**
	 * 根据姓名查找员工信息
	 * @param companyName
	 * @return
	 */
	public static  ArrayList<Company> getCompanyByName(String companyName) {
		ArrayList<Company> coms =new ArrayList<Company>();
		Connection connection = DBhelper.getCon();
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		boolean flag = false;
		int count= 0;
		if (connection!=null) {
		try {
			String sqlString = "select * from company where name like?";
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1,"%"+ companyName+"%");
		    rs = preparedStatement.executeQuery();
		    //遍历ResultSet
		    while (rs.next()) {
		    	int id = rs.getInt(1);
		    	String name = rs.getString(2);
		    	int age = rs.getInt(3);
		    	String address = rs.getString(4);
		    	double salary = rs.getDouble(5);
		    	Company company = new Company(id,name,age,address,salary);
		    	coms.add(company);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBhelper.close(rs, preparedStatement, connection);
		}
		}
		return coms;
	}	
	
	public static boolean deleteById(int id) {
		Connection connection =DBhelper.getCon();
		PreparedStatement preparedStatement=null;
		boolean flag=false;
		int count=0;
		if (connection!=null) {
			try {
				String sqlString ="delete from company where id =?";
				preparedStatement=connection.prepareStatement(sqlString);
				preparedStatement.setInt(1, id);
				count=  preparedStatement.executeUpdate();
				
				if (count>0) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				DBhelper.close(null,preparedStatement,connection);
			}
		}
		return flag;	 
	}
	 public static boolean update(Company company) {
	        Connection connection = DBhelper.getCon();
	        PreparedStatement preparedStatement = null;
	        int count = 0;
	        boolean flag = false;
	        if (connection != null) {
	            try {
	                String sqlString = "update company set name=?, age=?, address=?, salary=? where id=?";
	                preparedStatement = connection.prepareStatement(sqlString);
	                preparedStatement.setString(1, company.getName());
	                preparedStatement.setInt(2, company.getAge());
	                preparedStatement.setString(3, company.getAddress());
	                preparedStatement.setDouble(4, company.getSalary());
	                preparedStatement.setInt(5, company.getId());
	                count = preparedStatement.executeUpdate();

	                if (count > 0) {
	                    flag = true;
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	            	DBhelper.close(null,preparedStatement,connection);
	            }
	        }
	        return flag;
	    }
}

