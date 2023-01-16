package com.rays.Authenticatee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.mavenpro.UserRegistrationBean;

public class ModelAuthenticate {

	public UserRegistrationBean authenticate(String email, String pwd) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		UserRegistrationBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from mavenpro where email=? and pwd=?");
		ps.setString(1, email);
		ps.setString(2, pwd);
  

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			//System.out.println(bean.setEmail(rs.getString(5)));
			bean= new UserRegistrationBean();

			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setPwd(rs.getString(6));
			bean.setCpwd(rs.getString(7));

		}
		conn.close();
		return bean;
	}

}
