package dao;

import com.rakib.Employee;

import java.util.List;

public interface EmployeeDao {
    public  List<Employee> getAllEmployee();
    public  void  addEmployee(Employee employee);
    public  void updateEmployeeNameById(String name, int employeeId);
    public  void deleteEmployee(int employeeId);
    public List<Employee> sortEmployeeByCityAndName();

}
