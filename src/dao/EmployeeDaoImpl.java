package dao;

import com.rakib.DBConnection;
import com.rakib.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    Connection con;
    PreparedStatement pstam;
    Statement stam;
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = new ArrayList<>();
        try{
            con = DBConnection.getConnection();
            String q = "select * from employee";
            stam = con.createStatement();
            ResultSet rs = stam.executeQuery(q);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String birthday = rs.getString("birthday");

                Employee em = new Employee(id,name, city, birthday);
                allEmployees.add(em);

            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return allEmployees;
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            String q = "insert into employee(id,name,city,birthday) values(?,?,?,?)";
            con =  DBConnection.getConnection();
            pstam = con.prepareStatement(q);
            pstam.setInt(1, employee.getId());
            pstam.setString(2, employee.getName());
            pstam.setString(3, employee.getCity());
            pstam.setString(4, employee.getBirthday());
            int row = pstam.executeUpdate();
            if(row == 1){
                System.out.println("employee created");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    @Override
    public void updateEmployeeNameById(String name,int employeeId) {
        try {
            con =DBConnection.getConnection();
            String query = "update employee set name=? where id=?";
            pstam = con.prepareStatement(query);
            pstam.setString(1,name);
            pstam.setInt(2, employeeId);
            pstam.executeUpdate();
            System.out.println("update employee name successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            con = DBConnection.getConnection();
            String q = "delete from employee where id=?";
            pstam = con.prepareStatement(q);
            pstam.setInt(1 , employeeId);
            pstam.executeUpdate();
            System.out.println("delete student");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> sortEmployeeByCityAndName() {
        List<Employee> allEmployees = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            String query = "SELECT city, name, birthday FROM employee ORDER BY city, name";
            stam = con.createStatement();
            ResultSet rs = stam.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                String city = rs.getString("city");
                String birthday = rs.getString("birthday");
                Employee em = new Employee(name, city, birthday);
                allEmployees.add(em);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return allEmployees;
    }
}
