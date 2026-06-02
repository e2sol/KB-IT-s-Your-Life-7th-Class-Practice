package org.edu.member.dao;

import org.edu.member.vo.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// DAO(Data Access Object) : 데이터 접근 객체
// DB와 연결되어 SQL을 수행하고 결과를 반환받는 역할
public interface MemberDao {

    int create(Member member) throws SQLException;

    List<Member> getList() throws SQLException;

    Optional<Member> get(int memberNo) throws SQLException;

    int update(Member member) throws SQLException;

    int delete(Member member) throws SQLException;
}
