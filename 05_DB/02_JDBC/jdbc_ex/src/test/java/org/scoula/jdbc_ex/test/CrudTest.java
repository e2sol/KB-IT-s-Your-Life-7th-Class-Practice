package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

// 순서는 어노테이션을 통해 지정
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    // JDBCUtil을 이용하여 Connection 객체 정의
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        // 하나의 단위 테스트가 끝날때마다  Connection을 닫는 tearDown() 메서드 정의
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user 등록")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into users(id, password, name, role) values (?, ?, ?, ?)";
        // ? 자리에는 추후 다른 문자열이 들어와 채워지는 것
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");   // id
            pstmt.setString(2, "scoula3");  // pw
            pstmt.setString(3, "스콜라");    // name
            pstmt.setString(4, "USER");     // role

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 목록 추출")
    @Order(2)
    public void selectUser() throws SQLException{
        String sql = "select * from users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "select * from users where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userid);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정")
    @Order(4)
    public void updateUser() throws SQLException{
        String userid = "scoula";
        String sql = "update users set name = ? where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("지정한 사용자 삭제")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "delete from users where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
