package edu.employee.dao;

import edu.common.JDBCUtil;
import edu.employee.vo.EmployeeVO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                "where employee.ENT_YN = 'N' " +
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

    // 특정 부서 직급 10% 인상
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

    // 부서명 리스트 받기
    @Override
    public Map<String, String> getDeptTitles() throws SQLException {
        String sql = "select DEPT_ID, DEPT_TITLE from department";
        Map<String, String> map = new HashMap<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                map.put(rs.getString("DEPT_ID"), rs.getString("DEPT_TITLE"));
            }
        }

        return map;
    }

    @Override
    public Map<String, String> getJobNames() throws SQLException {
        String sql = "select * from job";
        Map<String, String> map = new HashMap<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                map.put(rs.getString("JOB_CODE"), rs.getString("JOB_NAME"));
            }
        }
        return map;
    }

    // 직급 명을 통해 직급 코드를 반환받는 메서드
    private String getJobCode(String jobName) throws SQLException {
        Map<String, String> jobMap = getJobNames();
        for (String jobCode : jobMap.keySet()) {
            if (jobMap.get(jobCode).equals(jobName)) {
                return jobCode;
            }
        }
        return null;
    }

    // 기존 직원 사번 확인 (관리자사번 확인용)
    @Override
    public List<String> getManagerIds() throws SQLException {
        String sql = "select EMP_ID from employee where ENT_YN = 'N'";
        List<String> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(rs.getString("EMP_ID"));
            }
        }
        return list;
    }

    // 기존 직원 사번 확인 (사번 중복 확인용)
    @Override
    public List<String> getEmployeeIds() throws SQLException {
        String sql = "select EMP_ID from employee";
        List<String> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                list.add(rs.getString("EMP_ID"));
            }
        }
        return list;
    }

    // 급여 금액 별 레벨 map 생성
    private Map<String, int[]> getSalaryMap() throws SQLException{
        String sql = "select * from sal_grade";
        Map<String, int[]> salGrade = new HashMap<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                int[] temp = new int[2];

                String level = rs.getString("SAL_LEVEL");
                temp[0] = rs.getInt("MIN_SAL");
                temp[1] = rs.getInt("MAX_SAL");

                salGrade.put(level, temp);
            }
        }
        return salGrade;
    }

    // 급여를 기반으로 급여 레벨 반환
    private String getSalaryLevel(int salary) throws SQLException{
        Map<String, int[]> salMap = getSalaryMap();
        for (String level : salMap.keySet()) {
            int[] temp = salMap.get(level);
            int min = temp[0];
            int max = temp[1];

            if (salary >= min && salary <= max) {
                return level;
            }
        }
        return null;
    }

    // 입력받은 정보를 기반으로 새로운 직원 정보 등록
    @Override
    public int insertEmployee(EmployeeVO empl) throws SQLException {
        String sql = "insert into employee " +
                "(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, MANAGER_ID, HIRE_DATE) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, empl.getEmpId()); // EMP_ID
            pstmt.setString(2, empl.getEmpName()); // EMP_NAME
            pstmt.setString(3, empl.getEmpNo()); // EMP_NO

            // EMAIL
            String email = empl.getEmpEmail();
            if (email.isEmpty()) pstmt.setString(4, null);
            else pstmt.setString(4, email);

            // PHONE
            String phone = empl.getPhone();
            if (phone.isEmpty()) pstmt.setString(5, null);
            else pstmt.setString(5, phone);

            // DEPT_CODE
            String dept = empl.getDeptTitle();
            if (dept == null || dept.isEmpty()) pstmt.setString(6, null);
            else {
                Map<String, String> deptMap = getDeptTitles();
                for (String code : deptMap.keySet()) {
                    if (deptMap.get(code).equals(dept)) {
                        pstmt.setString(6, code);
                        break;
                    }
                }
            }

            // JOB_CODE
            String jobCode = getJobCode(empl.getJobName());
            pstmt.setString(7, jobCode);

            // SAL_LEVEL
            int salary = empl.getSalary();
            pstmt.setString(8, getSalaryLevel(salary));

            pstmt.setInt(9, salary); // SALARY
            pstmt.setString(10, empl.getManagerId()); // MANAGER_ID

            // HIRE_DATE
            String hire = empl.getHireDate();
            if (hire == null || hire.isEmpty()) pstmt.setDate(11, Date.valueOf(LocalDate.now()));
            else pstmt.setDate(11, Date.valueOf(hire));

            int count =  pstmt.executeUpdate();

            if (count == 1) conn.commit();
            return count;
        }
    }

    @Override
    public int insertEmployeeSimple(EmployeeVO employee) throws SQLException {
        String sql = "insert into employee values " +
                "(?, ?, ?, null, null, null, ?, ?, ?, null, null, null, null, default)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            // EMP_ID
            pstmt.setString(1, employee.getEmpId());

            // EMP_NAME
            pstmt.setString(2, employee.getEmpName());

            // EMP_NO
            pstmt.setString(3, employee.getEmpNo());

            // JOB_CODE
            pstmt.setString(4, getJobCode(employee.getJobName()));

            // SAL_LEVEL
            pstmt.setString(5, getSalaryLevel(employee.getSalary()));

            // SALARY
            pstmt.setInt(6, employee.getSalary());

            int count = pstmt.executeUpdate();
            if (count == 1) conn.commit();
            return count;
        }
    }

    @Override
    public EmployeeVO getEmployeeInfo(String id) throws SQLException {
        String sql = "select EMP_NAME, DEPT_TITLE, JOB_NAME " +
                "from employee e join department d on e.DEPT_CODE = d.DEPT_ID " +
                "join job on e.JOB_CODE = job.JOB_CODE " +
                "where e.EMP_ID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    EmployeeVO employee = new EmployeeVO();
                    employee.setEmpName(rs.getString("EMP_NAME"));
                    employee.setDeptTitle(rs.getString("DEPT_TITLE"));
                    employee.setJobName(rs.getString("JOB_NAME"));

                    return employee;
                }
            }
        }
        return null;
    }

    // 입력받은 id의 직원 정보 삭제
    @Override
    public int deleteEmployee(String id) throws SQLException {
        String sql = "delete from employee where EMP_ID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, id);

            int count = pstmt.executeUpdate();

            if (count == 1) conn.commit();
            return count;
        }
    }
}
