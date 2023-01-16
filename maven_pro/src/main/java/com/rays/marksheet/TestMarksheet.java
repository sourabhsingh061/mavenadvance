package com.rays.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class TestMarksheet {
	static MarksheetModel dao = new MarksheetModel();

	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		// testdelete();
		//testgetrollno();
		// testGetMeritList();
		searchbyMarksheet();
		// GetMarksheetList();
	}

	public static void GetMarksheetList() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		List list = new ArrayList();

		list = model.GetMarksheetList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println("\t" + bean.getMaths());
		}

	}

	private static void searchbyMarksheet() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		List list = new ArrayList();
		bean.setFname("ram");											

		list = dao.searchMarksheet(bean);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println("\t" + bean.getMaths());

		}

	}

	public static void testGetMeritList() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		List list = new ArrayList();
		list = dao.getMeritList(bean);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println(bean.getMaths());

		}

	}

	public static void testgetrollno() throws Exception {
		MarksheetBean bean = dao.getbyrollno("r101");

		System.out.print("\t" + bean.getId());
		System.out.print("\t" + bean.getRollno());
		System.out.print("\t" + bean.getFname());
		System.out.print("\t" + bean.getLname());
		System.out.print("\t" + bean.getPhy());
		System.out.print("\t" + bean.getChem());
		System.out.println("\t" + bean.getMaths());

	}

	public static void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(11);
		bean.setRollno("r113");
		bean.setFname("anshu");
		bean.setLname("somaniwal");
		bean.setPhy(98);
		bean.setChem(82);
		bean.setMaths(92);
		dao.update(bean);
		System.out.println("updated");

	}

	public static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRollno("r112");
		bean.setFname("atul");
		bean.setLname("somani");
		bean.setPhy(72);
		bean.setChem(82);
		bean.setMaths(92);
		dao.add(bean);
		System.out.println("added");

	}

	public static void testdelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("r111");
		dao.delete(bean);
		System.out.println("deleted");
	}

}
