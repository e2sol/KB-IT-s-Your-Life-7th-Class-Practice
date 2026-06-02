package org.edu.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO(Value Object) : 값 자체를 표현하고 의미를 갖는 객체
@Data @NoArgsConstructor @AllArgsConstructor
public class Member {
    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberRole;
    private char deletedYn;
}
