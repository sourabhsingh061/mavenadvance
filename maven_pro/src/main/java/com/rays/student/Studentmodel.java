package com.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.marksheet.MarksheetBean;

public class Studentmodel {
	
	
	
	
	
	
	public static int nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		int pk =0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from student");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	pk =rs.getInt(1);
        }
        ps.close();
        rs.close();
        conn.close();
		return pk+1;
	}

	
   public void add(Studentbean bean) throws Exception {
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	   
	//Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
	PreparedStatement ps = conn.prepareStatement("insert into  student values(?,?,?,?,?)");
	conn.setAutoCommit(false);
	
	
	ps.setInt(1, nextPK());
	ps.setString(2, bean.getRollno());
	ps.setString(3,bean.getFname());
	ps.setString(4,bean.getLname());
    ps.setString(5, bean.getSession());
    
    
    ps.executeUpdate();
    conn.commit();
    ps.close();
    
}
   public void update(Studentbean bean) throws Exception {
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	   
	   
   // Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
	conn.setAutoCommit(false);
	PreparedStatement ps = conn.prepareStatement("update student set rollno =?, fname=?, lname=?,session=? where id = ?");
	
	ps.setString(1, bean.getRollno());
	ps.setString(2, bean.getFname());
	ps.setString(3, bean.getLname());
	ps.setString(4,bean.getSession());
	ps.setInt(5, bean.getId());
 
    ps.executeUpdate();
    conn.commit();
    conn.close();
    ps.close();
   }   
   
   public static void delete(Studentbean bean) throws Exception {
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	   
	   // Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from student where rollno = ?");
		ps.setString(1, bean.getRollno());
		int i = ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
		}
   
   public Studentbean getbyrollno(String rollno) throws Exception {
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	   
		//C/lass.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		Studentbean bean=null;
		PreparedStatement ps = conn.prepareStatement("select * from student where rollno=?");
		//System.out.println(bean.getRollno());
		
		ps.setString(1, rollno);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
		    bean = new Studentbean();
		    bean.setId(rs.getInt(1));
		    bean.setRollno(rs.getString(2));
		    bean.setFname(rs.getString(3));
		    bean.setLname(rs.getString(4));
		    bean.setSession(rs.getString(5));
		   
		}
		ps.close();
		rs.close();
		conn.close();
		return bean;

	}		
   public List getMeritList( MarksheetBean bean) throws Exception  {

	  Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark","root","root");
		ArrayList list = new ArrayList();
		PreparedStatement ps = conn.prepareStatement("SELECT *,  PHYSICS+CHEMISTRY+MATHS AS TOTAL,(PHYSICS+CHEMISTRY+MATHS)*100/300  PERCENTAGE  FROM student  ORDER BY PERCENTAGE DESC LIMIT 0,10" ); 
				
		
	   ResultSet rs = ps.executeQuery();
	   while (rs.next()) {
		   bean= new MarksheetBean();
		   bean.setId(rs.getInt(1));
		   bean.setRollno(rs.getString(2));
		   bean.setRollno(rs.getString(3));
		   bean.setRollno(rs.getString(4));
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
   public List searchStudent(Studentbean bean) throws Exception {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			ArrayList list = new ArrayList();
			StringBuffer sql = new StringBuffer("select * from student where 1=1");
			
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
				bean = new Studentbean();
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getString(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setSession(rs.getString(5));

				list.add(bean);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
			
		}
   public List GetStudentList() throws Exception {
	   
	   List list = new ArrayList();
	   Studentbean bean = null;
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			bean= new Studentbean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));

			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setSession(rs.getString(5));

			list.add(bean);
			
		}
		
		return list;      
		
   
   }
   
}
