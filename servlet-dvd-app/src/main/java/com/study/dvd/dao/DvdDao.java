package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Dvd;
import com.study.dvd.util.DBConnectionMgr;

public class DvdDao {
	// 전역으로 DB커넥션 매니저 선언
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	// 객체 찾기 메소드 선언 
	public static List<Dvd> searchDvdByTitle(String searchText){
		
		List<Dvd> dvds = new ArrayList<Dvd>();
		// db접근 변수 선언 필수요소 (Conection ,PreparedStatement,ResultSet) 
		Connection con = null;
		//db 쿼리문 접근 변수
		PreparedStatement pstmt = null;
		// Select 때 주로사용
		ResultSet rs = null;
		
		try {
			// 커넥션 객체 만들어줌
			con = pool.getConnection();
			
			// Query문 작성 builder
			StringBuilder sql = new StringBuilder();
			sql.append("select * from dvd_view ");
			sql.append("where title like ? limit 0,50");
			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,"%" + searchText + "%");
			
			rs = pstmt.executeQuery(); // resultSet 형태로 결과물 가지고옴
			
			while(rs.next()) { // 행(row)이동 next
				Dvd dvd = Dvd.builder()
						.dvdId(rs.getInt(1))
						.registrationNumber(rs.getString(2))
						.title(rs.getString(3))
						.producerId(rs.getInt(4))
						.producerName(rs.getString(5))
						.publisherId(rs.getInt(6))
						.publisherName(rs.getString(7))
						.publicationYear(rs.getInt(8))
						.databaseDate(rs.getDate(9).toLocalDate())
						.build();
				
				dvds.add(dvd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 초기화
			pool.freeConnection(con,pstmt,rs);			
		}
		// htmml ,jsp에 결과물 보내줌 (views) / jsp파일을 열어주려면 servlet에서 설정해줘야함
		return dvds;
	}
}
