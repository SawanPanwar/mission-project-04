package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollgeModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	public static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setName("Medicaps");
		bean.setAddress("indore");
		bean.setState("MP");
		bean.setCity("indore");
		bean.setPhoneNo("9898989898");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();

		model.add(bean);

	}

}
