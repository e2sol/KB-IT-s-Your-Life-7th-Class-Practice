package edu.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 수업 JDBCUtil 참고하여 작성

    static Connection conn = null;

    static {
        try {
            // application.properties에서 정보를 읽어오기 위한 객체 생성
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));

            // 정보를 읽어와 변수에 저장
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String pw = properties.getProperty("password");

            // 드라이버 연결
            Class.forName(driver);

            // Connection 객체 초기화
            conn = DriverManager.getConnection(url, id, pw);

            // 오토커밋 끄기
            conn.setAutoCommit(false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 외부에서 conn 객체를 불러올 수 있는 getter 정의
    public static Connection getConnection() {
        return conn;
    }

    // 작업 완료 후 연결 객체를 닫기위한 close() 메서드 정의
    public static void close() {
        // conn 객체가 null이 아닌 경우 close 진행
        try {
            if (conn != null) {
                conn.close();
                conn = null; // null로 초기화
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
