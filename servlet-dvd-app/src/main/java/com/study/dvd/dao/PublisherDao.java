package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.study.dvd.entity.Publisher;
import com.study.dvd.util.DBConnectionMgr;

public class PublisherDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();

	public static boolean save(Publisher publisher) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int successCount = 0;

		try {
			connection = pool.getConnection();
			String sql = "insert into publisher_tb values(0,?)";
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, publisher.getPublisherName());

			successCount = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			
			while(resultSet.next()) {
				publisher.setPublisherId(resultSet.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(connection, preparedStatement, resultSet);
		}

		return successCount > 0;
	}

}
