package org.scoula.config;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j2
class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("DataSource 연결 확인")
    void dataSource() throws SQLException {
        try(Connection con = dataSource.getConnection()){
            // DataSource Bean이 생성된 경우 객체값이 null이 아님 -> 생성여부 확인 가능
            log.info("DataSource 준비 완료");
            log.info(con);
        }
    }
}