package com.hanbit.member.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hanbit.member.constants.Database;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insert(MemberBean bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberBean> selectAll() {

		return null;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		Connection conn = null;
		try {
			Class.forName(Database.DRIVER);
			conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Member WHERE id='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setSsn(rs.getString("ssn"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(MemberBean member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
