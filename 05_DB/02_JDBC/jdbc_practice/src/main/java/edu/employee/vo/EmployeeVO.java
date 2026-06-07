package edu.employee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeVO {
    // 사원 정보
    private String empId;           // 사원번호
    private String empName;         // 사원명
    private String empNo;           // 주민번호
    private String empEmail;        // 이메일주소
    private String phone;           // 휴대폰번호
    private int salary;             // 급여
    private String entYn;           // 재직여부
    private String managerId;       // 관리자 사번
    private String hireDate;        // 입사일

    // 부서 정보
    private String deptTitle;       // 부서명

    // 직급 정보
    private String jobName;         // 직급명

    // 추가 조회 정보
    private String bonus;           // 보너스율

    // 통계 조회용
    private int employeeCount;      // 사원수
    private double avgSalary;       // 평균급여
}
