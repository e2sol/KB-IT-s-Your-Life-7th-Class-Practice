package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // AOP 관련 파일이라고 설정
@Log4j2
@Component // Spring에 Bean으로 등록
public class LogAdvice {

    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("==========================================");
    }

    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1: " + str1);  // 첫 번째 파라미터 로깅
        log.info("str2: " + str2);  // 두 번째 파라미터 로깅
    }
}
