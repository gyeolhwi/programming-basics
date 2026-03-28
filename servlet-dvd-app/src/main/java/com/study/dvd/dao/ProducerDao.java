package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Producer;
import com.study.dvd.util.DBConnectionMgr;

public class ProducerDao {
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Producer> searchProdcuerByProducerName(String searchProducerName) {
		List<Producer> producers = new ArrayList<Producer>();
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			con = pool.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select producer_id,producer_name from dvd_view ");
			sql.append("where producer_name like ? order by producer_id limit 0,50");
			
			statement = con.prepareStatement(sql.toString());
			
			statement.setString(1,"%" + searchProducerName + "%");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Producer producer = Producer.builder()
						.producerId(resultSet.getInt(1))
						.producerName(resultSet.getString(2))
						.build();
				producers.add(producer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,statement,resultSet);
		}
		
		return producers;
	}
	public static int save(Producer producer) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = pool.getConnection();
			String sql = "insert into producer_tb values(0,?)";
			statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, producer.getProducerName());
			successCount = statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while(resultSet.next()) {
				producer.setProducerId(resultSet.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,statement,resultSet);
		}

		return successCount;
	}
}
