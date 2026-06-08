package edu.employee.dao;

import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    List<EmployeeVO> getDeptEmpl(String deptName) throws SQLException;

    List<EmployeeVO> getDeptAvgSal() throws SQLException;

    List<EmployeeVO> getWorkingEmpl() throws SQLException;

    int increaseSalary(String deptCode) throws SQLException;

    List<EmployeeVO> getEmplWithoutPhone() throws SQLException;

    Map<String, String> getDeptTitles() throws SQLException;

    Map<String, String> getJobNames() throws SQLException;

    List<String> getManagerIds() throws SQLException;

    List<String> getEmployeeIds() throws SQLException;

    int insertEmployee(EmployeeVO empl) throws SQLException;

    EmployeeVO getEmployeeInfo(String id) throws SQLException;

    int deleteEmployee(String id) throws SQLException;

    int insertEmployeeSimple(EmployeeVO employee) throws SQLException;
}
