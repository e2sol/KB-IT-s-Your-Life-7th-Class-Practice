package org.scoula.security.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AuthVO implements GrantedAuthority {
    // 반드시 GrantedAuthority를 상속받아서 구현되어야 권한 이름을 시스템이 확인 할 수 있음

    private String username;        // 사용자 ID
    private String auth;           // 권한 문자열

    @Override
    public String getAuthority() {
        return auth;               // Spring Security가 권한 확인 시 호출
    }
}