package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) {

	}

	public void testAdd() {

		StudentBean bean = new StudentBean();
		bean.setFirstName("Aarav");
		bean.setLastName("Sharma");
		bean.setDob(new Date());
		bean.setGender("Male");
		bean.setMobileNo("9876543210");
		bean.setEmail("aarav.sharma@gmail.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();

		try {
			model.add(bean);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

}
