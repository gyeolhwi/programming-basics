package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import util.DBConnectionMgr;

public class UserDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();

	public static int save(User user) {
		int successCount = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = pool.getConnection();
			
			String sql = "insert into user_tb values( 0, ?, ?, ?, ?, NOW())";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			successCount = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(connection,preparedStatement);
		}
		return successCount;
	}
	
	// ID 중복검사 단건조회 
	public static User findUserByUsername(String username) {
		User findUser = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from user_tb where username = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				findUser = User.builder()
						.userId(resultSet.getInt(1))
						.username(resultSet.getString(2))
						.password(resultSet.getString(3))
						.name(resultSet.getString(4))
						.email(resultSet.getString(5))
						.registerDate(resultSet.getTimestamp(6).toLocalDateTime())
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,statement,resultSet);
		}
		return findUser;
		
	}
	public static int updateUserInfo(User user) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = pool.getConnection();
			String sql = "update user_tb set name = ?, email = ? where user_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,user.getName());
			psmt.setString(2,user.getEmail());
			psmt.setInt(3,user.getUserId());

			successCount = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, psmt);
		}
		return successCount;
	}
	
	public static int updatePassword(User user) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = pool.getConnection();
			String sql = "update user_tb set password = ? where user_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getPassword());
			psmt.setInt(2, user.getUserId());
			successCount = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, psmt);
		}
		return successCount;
	}
}
