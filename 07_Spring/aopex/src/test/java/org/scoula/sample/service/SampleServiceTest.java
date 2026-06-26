package org.scoula.sample.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// Spring 환경의 테스트를 하고 싶은 경우 꼭 추가
@ExtendWith(SpringExtension.class)      // JUnit 5에서 Spring 테스트 지원
@ContextConfiguration(classes = { RootConfig.class })  // Spring 설정 클래스 지정

@Log4j2 // 로그 확인용
class SampleServiceTest {

    @Autowired
    private SampleService service;  // 테스트 진행할 SampleService 객체

    @Test
    void doAdd() throws Exception{
        // 정상적인 덧셈 테스트
        log.info("덧셈 결과 : " + service.doAdd("123", "456"));
    }
}