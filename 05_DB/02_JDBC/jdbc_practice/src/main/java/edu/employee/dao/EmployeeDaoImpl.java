package edu.employee.dao;

import edu.common.JDBCUtil;
import edu.employee.vo.EmployeeVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    Connection conn = JDBCUtil.getConnection();

    @Override
    public List<EmployeeVO> getDeptEmpl(String deptName) throws SQLException {
        // 입력받은 부서 이름에 근무하는 직원 정보 조회
        // 조회 컬럼 : 사원명(EMP_NAME), 부서명(DEPT_TITLE), 직급명(JOB_NAME), 보너스율(BONUS), 퇴직여부(ENT_YN)
        String sql = "select EMP_NAME 사원명, DEPT_TITLE 부서명, JOB_NAME 직급명, BONUS 보너스율, ENT_YN 퇴직여부 " +
                "from department join employee on department.DEPT_ID = employee.DEPT_CODE " +
                "join job on employee.JOB_CODE = job.JOB_CODE " +
                "where DEPT_TITLE = ? order by 보너스율 desc ";

        // 결과를 담을 List 객체 생성
        List<EmployeeVO> list = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, deptName);

            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    EmployeeVO employee = new EmployeeVO();

                    employee.setEmpName(rs.getString("사원명"));
                    employee.setDeptTitle(rs.getString("부서명"));
                    employee.setJobName(rs.getString("직급명"));

                    // 보너스율에 null값이 들어있는지 확인하기 위해서 Float 객체를 이용하는 것이 좋다.
                    // 값 == 0 으로 비교 시 null과 0.0 모두 true를 반환
                    if (rs.getObject("보너스율", Float.class) == null) employee.setBonus("보너스 없음");
                    else employee.setBonus(String.valueOf(rs.getFloat("보너스율")));

                    // 퇴직 여부에 따른 각각의 값 저장
                    if (rs.getString("퇴직여부").equals("Y")) employee.setEntYn("퇴사");
                    else employee.setEntYn("재직");

                    // 저장한 employee 객체를 list에 저장
                    list.add(employee);
                }
            }
        }
        return list;
    }

    // 부서, 직급 별 평균 급여가 300만원 이상인 경우 조회
    // 조회 컬럼 : 부서명, 직급명, 사원수, 평균급여
    // 평균급여 반올림, 평균급여 기준 내림차순 정렬
    @Override
    public List<EmployeeVO> getDeptAvgSal() throws SQLException {
        String sql = "select DEPT_TITLE, JOB_NAME, count(*) 사원수, round(avg(SALARY)) 평균급여 " +
                "from employee join department on employee.DEPT_CODE = department.DEPT_ID " +
                "join job on employee.JOB_CODE = job.JOB_CODE " +
                "group by DEPT_TITLE, JOB_NAME " +
                "having avg(SALARY) >= 3000000 " +
                "order by 평균급여 desc ";

        List<EmployeeVO> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                EmployeeVO empl = new EmployeeVO();
                empl.setDeptTitle(rs.getString("DEPT_TITLE"));
                empl.setJobName(rs.getString("JOB_NAME"));
                empl.setEmployeeCount(rs.getInt("사원수"));
                empl.setAvgSalary(rs.getDouble("평균급여"));

                list.add(empl);
            }
        }

        return list;
    }

    // 현재 재직중인 직원 조회
    // 조회 컬럼 : 부서명, 직급명, 사원명, 급여
    // 부서가 없어도 조회, 직급명 오름차순 정렬, 상위 10개만 조회
    @Override
    public List<EmployeeVO> getWorkingEmpl() throws SQLException {
        String sql = "select DEPT_TITLE, JOB_NAME, EMP_NAME, SALARY " +
                "from employee left join department on employee.DEPT_CODE = department.DEPT_ID " +
                "join job on employee.JOB_CODE = job.JOB_CODE " +
                "order by JOB_NAME limit 10";

        List<EmployeeVO> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                EmployeeVO empl = new EmployeeVO();

                empl.setDeptTitle(rs.getString("DEPT_TITLE"));
                empl.setJobName(rs.getString("JOB_NAME"));
                empl.setEmpName(rs.getString("EMP_NAME"));
                empl.setSalary(rs.getInt("SALARY"));

                list.add(empl);
            }
        }

        return list;
    }

    @Override
    public int increaseSalary(String deptCode) throws SQLException {
        String sql = "update employee set SALARY = SALARY * 1.1 where DEPT_CODE = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, deptCode);

            int count = pstmt.executeUpdate();

            if (count != 0) conn.commit();

            return count;
        }
    }

    // 휴대폰 번호가 없는 직원 목록 조회
    // 조회 컬럼 : 사원명, 휴대폰번호, 부서명
    // 휴대폰 번호가 null인 경우 "없음"으로 표시
    // 사원명기준 내림차순 정렬
    @Override
    public List<EmployeeVO> getEmplWithoutPhone() throws SQLException {
        String sql = "select EMP_NAME, ifnull(PHONE, '없음') 휴대폰번호, DEPT_TITLE " +
                "from employee left join department on employee.DEPT_CODE = department.DEPT_ID " +
                "where PHONE is null order by EMP_NAME desc ";

        List<EmployeeVO> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                EmployeeVO empl = new EmployeeVO();

                empl.setEmpName(rs.getString("EMP_NAME"));
                empl.setPhone(rs.getString("휴대폰번호"));
                empl.setDeptTitle(rs.getString("DEPT_TITLE"));

                list.add(empl);
            }
        }
        return list;
    }

}
