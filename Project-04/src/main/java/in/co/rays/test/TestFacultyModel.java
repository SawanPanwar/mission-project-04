package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.FacultyBean;
import in.co.rays.model.FacultyModel;

public class TestFacultyModel {

	public static void main(String[] args) throws Exception {
		testAdd();
	}

	public static void testAdd() throws Exception {

		FacultyBean bean = new FacultyBean();

		bean.setFirstName("Avnish");
		bean.setLastName("Gupta");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("1234567890");
		bean.setEmail("av@gmail.com");
		bean.setCollegeId(1);
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		FacultyModel model = new FacultyModel();
		model.add(bean);
	}
}
