package com.rays.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.rays.Authenticatee.ModelAuthenticate;
import com.rays.mavenpro.UserRegistrationBean;
import com.rays.mavenpro.UserRegistrationModel;

public class UserRegistrationTest {

	static Logger log = Logger.getLogger(UserRegistrationTest.class);

	static UserRegistrationModel model = new UserRegistrationModel();

	public static void main(String[] args) throws Exception {

		// testadd();

		testauthenticate();
	}

	public static void testauthenticate() {

		//BasicConfigurator.configure();
		log.debug("testauthenticate start");
		UserRegistrationBean bean = new UserRegistrationBean();

		ModelAuthenticate modelauth = new ModelAuthenticate();

		try {
			bean = modelauth.authenticate("akash123@gmail.com", "12345");

			if (bean != null) {
				System.out.println("valid");

			} else {
				System.out.println("invalid");

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		log.debug("testauthenticate end");
	}

	public static void testadd() throws Exception {

		UserRegistrationBean bean = new UserRegistrationBean();
		bean.setFname("abhishek");
		bean.setLname("verma");
		bean.setGender("male");
		bean.setEmail("abhishek123@gmail.com");
		bean.setPwd("123");
		bean.setCpwd("1234");

		model.add(bean);
		System.out.println("inserted");

	}
}
