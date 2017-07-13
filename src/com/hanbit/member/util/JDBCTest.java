package com.hanbit.member.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.hanbit.member.constants.Database;
public class JDBCTest {
	public static void main(String[] args) {
		String findName="";		
		Connection conn = null;
		try {
			Class.forName(Database.DRIVER);
			conn = DriverManager.getConnection(Database.URL, Database.USERID, Database.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql="SELECT * FROM Member WHERE id='hong'";
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()){
				findName=rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}/*finally {
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		System.out.println("###결과: "+findName);
	}
}
