package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.bean.RoleBean;
import in.co.rays.util.JDBCDataSource;

public class RoleModel {

	public void add(RoleBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_role values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setLong(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedBy());
		pstmt.setString(5, bean.getModifiedBy());
		pstmt.setTimestamp(6, bean.getCreatedDatetime());
		pstmt.setTimestamp(7, bean.getModifiedDatetime());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data inserted => " + i);

	}

}
