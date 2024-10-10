package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {
		testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByName();
		// testSearch();
	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setName("kiosk");
		bean.setDescription("kiosk");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setId(2);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

	}

	public static void testFindByPk() throws Exception {

	}

	public static void testFindByName() throws Exception {

	}

	public static void testSearch() throws Exception {

	}

}
