package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	public static int nextPK() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
		
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		int pk =0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	pk =rs.getInt(1);
        }
        ps.close();
        rs.close();
        conn.close();
		return pk+1;
	}

	
   public void add( MarksheetBean bean) throws Exception {
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
		
	   
	//Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
	PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
	conn.setAutoCommit(false);
	
	
	ps.setInt(1, nextPK());
	ps.setString(2, bean.getRollno());
	ps.setString(3,bean.getFname());
	ps.setString(4,bean.getFname());
    ps.setInt(5, bean.getPhy());
    ps.setInt(6, bean.getChem());
    ps.setInt(7, bean.getMaths());
    
    
    ps.executeUpdate();
    conn.commit();
    ps.close();
    
}
   public void update(MarksheetBean bean) throws Exception {
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
		
	   
   // Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
	conn.setAutoCommit(false);
	PreparedStatement ps = conn.prepareStatement("update marksheet set rollno =?, FNAME=?, LNAME=?,PHYSICS = ?, CHEMISTRY = ?, MATHS=? where ID = ?");
	
	ps.setString(1, bean.getRollno());
	ps.setString(2, bean.getFname());
	ps.setString(3, bean.getLname());
	ps.setInt(4, bean.getPhy());
	ps.setInt(5, bean.getChem());
	ps.setInt(6, bean.getMaths());
	ps.setInt(7, bean.getId());
 
    ps.executeUpdate();
    conn.commit();
    conn.close();
    ps.close();
   }   
   
   public static void delete(MarksheetBean bean) throws Exception {
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
	   
	   // Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where rollno = ?");
		ps.setString(1, bean.getRollno());
		int i = ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
		}
   
   public MarksheetBean getbyrollno(String rollno) throws Exception {
	    ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
	   
		//C/lass.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		MarksheetBean bean=null;
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where rollno=?");
		//System.out.println(bean.getRollno());
		ps.setString(1, rollno);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
		    bean = new MarksheetBean();
		    bean.setId(rs.getInt(1));
		    bean.setRollno(rs.getString(2));
		    bean.setFname(rs.getString(3));
		    bean.setLname(rs.getString(4));
		    bean.setPhy(rs.getInt(5));
		    bean.setChem(rs.getInt(6));
		    bean.setMaths(rs.getInt(7));

		}
		ps.close();
		rs.close();
		conn.close();
		return bean;

	}		
   public List getMeritList( MarksheetBean bean) throws Exception  {
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
	   
	 //  Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		ArrayList list = new ArrayList();
		PreparedStatement ps = conn.prepareStatement("SELECT *,  PHYSICS+CHEMISTRY+MATHS AS TOTAL,(PHYSICS+CHEMISTRY+MATHS)*100/300  PERCENTAGE  FROM MARKSHEET  ORDER BY PERCENTAGE DESC LIMIT 0,10" ); 
				
		
	   ResultSet rs = ps.executeQuery();
	   while (rs.next()) {
		   bean= new MarksheetBean();
		   bean.setId(rs.getInt(1));
		   bean.setRollno(rs.getString(2));
		   bean.setFname(rs.getString(3));
		   bean.setLname(rs.getString(4));
		   bean.setPhy(rs.getInt(5));
		   bean.setChem(rs.getInt(6));
		   bean.setMaths(rs.getInt(7));
		   list.add(bean);

	   }
	   ps.close();
	   conn.close();
	   rs.close();
	   return list;
   }
   public List searchMarksheet(MarksheetBean bean) throws Exception {
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));   
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st_student", "root", "root");

			ArrayList list = new ArrayList();
			StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
			
			if(bean!=null){
			if(bean.getId()>0){
				sql.append(" AND id ="+bean.getId());
			}
			if(bean.getFname()!=null && bean.getFname().length()>0){
				sql.append(" AND FNAME like '"+bean.getFname()+"%'");
			}
			if(bean.getLname()!=null && bean.getLname().length()>0){
				sql.append(" AND LNAME like '"+bean.getLname()+"%'");
			}
			if(bean.getRollno()!=null && bean.getRollno().length()>0){
				sql.append(" AND rollno like '"+bean.getRollno()+"%'");
			}
			}
			//System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getString(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setPhy(rs.getInt(5));
				bean.setChem(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				list.add(bean);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
			
		}
   public List GetMarksheetList() throws Exception {
	   
	   List list = new ArrayList();
	   MarksheetBean bean = null;
	   ResourceBundle rb = ResourceBundle.getBundle("com.rays.rb.app");
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),rb.getString("pwd"));
	
		PreparedStatement ps = conn.prepareStatement("select * from marksheet ");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			bean= new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));

			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMaths(rs.getInt(7));

			list.add(bean);
			
		}
		
		return list;      
		
   
   }
   

   }

