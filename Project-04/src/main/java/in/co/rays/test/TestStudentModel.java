package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

		testAdd();
	}

	public static void testAdd() throws Exception {

		StudentBean bean = new StudentBean();

		bean.setFirstName("Avnish");
		bean.setLastName("Upadhyay");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("7648880017");
		bean.setEmail("avnish@gmail.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();

		model.add(bean);
	}
}
