package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {

    UserDao dao = new UserDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("user 등록")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO("ssamz3", "ssamz123", "쌤즈", "ADMIN");
        int count = dao.create(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("UserDao user 목록 추출")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> list = dao.getList();
        for (UserVO user : list) {
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("특정 user 정보 조회")
    @Order(3)
    void get() throws SQLException {
        // orElseThrow() : Optional 내부에 값이 있으면 그 값을 반환, 없는 경우 예외 발생
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("특정 user 정보 수정")
    @Order(4)
    void update() throws SQLException {
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        user.setName("쌤즈3");
        int count = dao.update(user);
        Assertions.assertEquals(1,  count); // 수정된 행이 1개인지 확인
    }

    @Test
    @DisplayName("특정 user 정보 삭제")
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("ssamz3");
        Assertions.assertEquals(1, count);
    }
}