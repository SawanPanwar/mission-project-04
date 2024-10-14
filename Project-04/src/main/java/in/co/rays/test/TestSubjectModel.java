package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.SubjectBean;
import in.co.rays.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByName();
		testSearch();
	}

	public static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();

		bean.setName("Mechanical");
		bean.setCourseId(3);
		bean.setDescription("Mechanical");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		SubjectModel model = new SubjectModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findByPk(4);

		bean.setName("Physics");
		bean.setCourseId(4);
		bean.setDescription("Mechanical");

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		SubjectModel model = new SubjectModel();
		model.delete(4);
	}

	public static void testFindByPk() throws Exception {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findByPk(2);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found");
		}
	}

	public static void testFindByName() throws Exception {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findByName("physics");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("subject name not found");
		}
	}

	public static void testSearch() throws Exception {

		SubjectBean bean = new SubjectBean();
		bean.setName("m");

		SubjectModel model = new SubjectModel();

		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (SubjectBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}
	}
}
