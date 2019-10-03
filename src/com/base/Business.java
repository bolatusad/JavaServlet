package com.base;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;



public class Business {
	
	
	private static Connection conn = null;
	private static List<Connection> conns = new ArrayList<Connection>();
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn(){
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = Business.getConn();
		System.out.println(conn);
		 
	}




	public static String getPassword(String username){
		Statement st;
		String sql = "select * from user where username='"+username+"'";     // 查询数据的sql语句  
		String password = "";
		try {
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
	        while (rs.next()) { // 判断是否还有下一个数据  
	            // 根据字段名获取相应的值  
	            password = rs.getString("password");  
	        }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    //创建用于执行静态sql语句的Statement对象，st属局部变量  
		return password;
	}

}

