package com.rays.mavenpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.mavenpro.UserRegistrationBean;

public class UserRegistrationModel {

	public static int nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from mavenpro");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public static void add(UserRegistrationBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into mavenpro values(?,?,?,?,?,?,?)");
		conn.setAutoCommit(false);

		ps.setInt(1, nextPK());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getGender());
		ps.setString(5, bean.getEmail());
		ps.setString(6, bean.getPwd());
		ps.setString(7, bean.getCpwd());
		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public UserRegistrationBean authenticate(String email, String pwd) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		UserRegistrationBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from mavenpro where email=? and pwd=?");
		ps.setString(1, email);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// System.out.println(bean.setEmail(rs.getString(5)));
			bean = new UserRegistrationBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setPwd(rs.getString(6));
			bean.setCpwd(rs.getString(7));

		}
		//conn.close();
		return bean;
	}
	public UserRegistrationBean Forget(String email) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		UserRegistrationBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from mavenpro where email=? ");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// System.out.println(bean.setEmail(rs.getString(5)));
			bean = new UserRegistrationBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setPwd(rs.getString(6));
			bean.setCpwd(rs.getString(7));
			
		}
		//conn.close();
		return bean;
	}
	
}
