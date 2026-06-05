package edu.employee.dao;

import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    List<EmployeeVO> getDeptEmpl(String deptName) throws SQLException;

    List<EmployeeVO> getDeptAvgSal() throws SQLException;

    List<EmployeeVO> getWorkingEmpl() throws SQLException;

    int increaseSalary(String deptCode) throws SQLException;

    List<EmployeeVO> getEmplWithoutPhone() throws SQLException;
}
