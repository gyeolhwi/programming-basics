package com.study.dvd.dao;

import com.study.dvd.db.DBConnectionMgr;
import com.study.dvd.entity.DVD;
import com.study.dvd.entity.Producer;
import com.study.dvd.entity.Publisher;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DVDDao {

    public static int addDvd(DVD dvd) {
        DBConnectionMgr pool = DBConnectionMgr.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int successCount = 0;
        try {
            connection = pool.getConnection(); // 데이터베이스 연결

            String sql = "insert into dvd_tb values(0, ?, ?, ?, ?, ?, now())";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dvd.getRegistrationNumber());
            preparedStatement.setString(2, dvd.getTitle());
            preparedStatement.setInt(3, dvd.getProducer().getProducerId());
            preparedStatement.setInt(4, dvd.getPublisher().getPublisherId());
            preparedStatement.setInt(5, dvd.getPublicationYear());
            successCount = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return successCount;
    }

    public static int addProducer(Producer producer) {
        DBConnectionMgr pool = DBConnectionMgr.getInstance();

        // DB서버 연결 객체
        Connection connection = null;
        // 쿼리 실행 , 동작 객체
        PreparedStatement preparedStatement = null;
        //
        ResultSet generatedKeys = null;
        int successCount = 0;

        try {
            connection = pool.getConnection();// 데이터베이스 연결


            String sql = "insert into producer_tb values(0,?)";
            //
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);   // 미완성된 쿼리 실행시킬 준비

            preparedStatement.setString(1, producer.getProducerName()); // ? 자리에 데이터 채우기


            successCount = preparedStatement.executeUpdate(); // 쿼리실행하기
            generatedKeys = preparedStatement.getGeneratedKeys(); // get하고오면 자료형이 ResultSet으로 바뀜 // 전체 키값을 가지고오는 거임
            generatedKeys.next();
            producer.setProducerId(generatedKeys.getInt(1)); // 첫번쨰 컬럼을 가져와라
        } catch (Exception e) {
        } finally {
            // END 커넥션
            pool.freeConnection(connection, preparedStatement, generatedKeys);
        }

        return successCount;
    }

    public static int addPublisher(Publisher publisher) {
        DBConnectionMgr pool = DBConnectionMgr.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null; // 담는곳
        int successCount = 0;

        try {
            connection = pool.getConnection(); // 데이터베이스 연결
            String sql = "insert into publisher_tb values(0,?)";
            // 오토인크리먼트 된 키값을 가져옴 이유는
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);   // 미완성된 쿼리 실행시킬 준비

            preparedStatement.setString(1, publisher.getPublisherName()); // ? 자리에 데이터 채우기

            successCount = preparedStatement.executeUpdate(); // 쿼리실행
            // insert update delete -> executeUpadate 몇건인지 반환 int

            generatedKeys = preparedStatement.getGeneratedKeys(); // 담았음

            generatedKeys.next();
            publisher.setPublisherId(generatedKeys.getInt(1));
        } catch (Exception e) {
        } finally {
            pool.freeConnection(connection, preparedStatement, generatedKeys);
        }
        return successCount;
    }

    public static List<DVD> findAll(int count) {
        DBConnectionMgr pool = DBConnectionMgr.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DVD> dvdList = new ArrayList<>();

        try {
            connection = pool.getConnection();
            String sql = "select * from dvd_view limit 0, ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { // 행 반복이동
                Producer producer = Producer.builder()
                        .producerId(resultSet.getInt(4))
                        .producerName(resultSet.getString(5))
                        .build();
                Publisher publisher = Publisher.builder()
                        .publisherId(resultSet.getInt(6))
                        .publisherName(resultSet.getString(7))
                        .build();

                DVD dvd = DVD.builder()
                        .dvdId(resultSet.getInt(1))
                        .registrationNumber(resultSet.getString(2))
                        .title(resultSet.getString(3))
                        .producerId(producer.getProducerId())
                        .producer(producer)
                        .publisherId(publisher.getPublisherId())
                        .publisher(publisher)
                        .publicationYear(resultSet.getInt(8))
                        .databaseDate(resultSet.getDate(9).toLocalDate())
                        .build();
                dvdList.add(dvd);
                System.out.println(dvd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(connection);
        }
        return dvdList;
    }


}
