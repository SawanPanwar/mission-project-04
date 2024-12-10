package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {
		
		RoleBean bean = new RoleBean();
		bean.setId(5);
		bean.setName("sales");
		bean.setDescription("sales");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.add(bean);

	}
}
