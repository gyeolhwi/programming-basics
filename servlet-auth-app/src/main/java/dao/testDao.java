package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.test;
import util.DBConnectionMgr;

public class testDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<test> findUser(String searchText) {

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<test> list = new ArrayList<test>();
		try {
			
			con = pool.getConnection();
			
			
			String sql = "select dvd_id,title from dvd_view where title LIKE ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+searchText+"%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
//				test t = test.builder()
//						.dvdId(rs.getInt(1))
//						.title(rs.getString(2))
//						.build(); 
//				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,psmt);
		}
		return list;
	}
	
	
	public static test findUserNameByUserId(String username) {
		test user = null;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection();
			String sql = "select * from user_tb where username = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,username);
			
			rs = psmt.executeQuery();
			while(rs.next()) {				
			user = test.builder()
					.userId(rs.getInt(1))
					.userName(rs.getString(2))
					.password(rs.getString(3))
					.email(rs.getString(4))
					.name(rs.getString(5))
					.registerDate(rs.getTimestamp(6).toLocalDateTime())
					.build();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, psmt);
		}
		return user;
	}
	
	
	
	public static int save(test test) {
		Connection con = null;
		PreparedStatement psmt = null;
		int successCount = 0;
		
		try {
			con = pool.getConnection();
			String sql = "insert into user_tb values (0 ,?, ?, ?, ? ,NOW())";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,test.getUserName());
			psmt.setString(2,test.getPassword());
			psmt.setString(3,test.getName());
			psmt.setString(4,test.getEmail());
			
			successCount = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,psmt);
		}
		return successCount;
	}
	
}
