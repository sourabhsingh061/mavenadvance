package com.rays.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.marksheet.MarksheetBean;
import com.rays.marksheet.MarksheetModel;

public class Teststudent {
	static Studentbean bean = new Studentbean();
	static Studentmodel model = new Studentmodel();

	public static void main(String[] args) throws Exception {
		//testadd();
		// testupdate();
		//testdelete();
		//testgetroll();
		//testsearch();
		testlist();

	}

	public static void testlist() throws Exception {
	

			Studentbean bean = new Studentbean();
			Studentmodel model = new Studentmodel();
			List list = new ArrayList();

			list = model.GetStudentList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (Studentbean) it.next();
				System.out.print(bean.getId());
				System.out.print("\t" + bean.getRollno());
				System.out.print("\t" + bean.getFname());
				System.out.print("\t" + bean.getLname());
				System.out.print("\t" + bean.getSession());
			}

	}

	public static void testsearch() throws Exception {

		List list = new ArrayList();
	bean.setFname("ada");
	list=model.searchStudent(bean);
	Iterator it =list.iterator();
	
	while(it.hasNext()) {
		bean  = (Studentbean)it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getRollno());
		System.out.println(bean.getFname());
		System.out.println(bean.getLname());
		System.out.println(bean.getSession());

	}	
	}

	public static void testgetroll() throws Exception {
       Studentbean bean = model.getbyrollno("r102");
       
       System.out.println(bean.getId());
       System.out.println(bean.getRollno());

       System.out.println(bean.getFname());
       System.out.println(bean.getLname());
       System.out.println(bean.getSession());



	}

	public static void testdelete() throws Exception {
		bean.setRollno("r102");
		model.delete(bean);
		System.out.println("deleted");
	}

	private static void testupdate() throws Exception {
		bean.setRollno("r102");

		bean.setFname("harsh");
		bean.setLname("gupta");
		bean.setSession("2020-21");
		bean.setId(2);
		model.update(bean);
		System.out.println("updated");

	}

	public static void testadd() throws Exception {

		bean.setRollno("r102");
		bean.setFname("adarsh");
		bean.setLname("mukati");
		bean.setSession("2020-21");

		model.add(bean);
		System.out.println("inserted");

	}
}
