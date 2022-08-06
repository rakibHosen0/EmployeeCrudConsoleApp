package com.rakib;

import dao.EmployeeDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        EmployeeDaoImpl employee = new EmployeeDaoImpl();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter your Name : ");
        String name = input.readLine();
        System.out.println("Hello Dear " + name + " , Welcome to CRUD Console Application");
        System.out.println("--------------------------------------------------------");
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("PRESS 1 to SHOW ALL EMPLOYEES");
            System.out.println("PRESS 2 to ADD EMPLOYEE");
            System.out.println("PRESS 3 to DELETE EMPLOYEE");
            System.out.println("PRESS 4 to UPDATE EMPLOYEE NAME");
            System.out.println("PRESS 5 to SORTING  EMPLOYEE TABLE BY CITY, NAME");
            System.out.println("PRESS 6 to EXIT App");
            System.out.println("--------------------------------------------------------");
            int button = Integer.parseInt(input.readLine());

            if(button == 1){
                //get all employees
                List<Employee> employees = employee.getAllEmployee();
                for (Employee employee1 : employees){
                    System.out.println(employee1);
                }
            }else if(button == 2){
                //add a new employee
                System.out.println("Add a new Employee");
                System.out.println("Enter a id, Name, City, and Birthday :");
                int id = Integer.parseInt(input.readLine());
                String  eName = input.readLine();
                String city = input.readLine();
                String birthday = input.readLine();
                Employee e = new Employee(id, eName, city,birthday);
                employee.addEmployee(e);
            }else if(button == 3){
                //delete a employeeById
                System.out.println("Delete a employee by Id Enter Id");
                int employeeId = Integer.parseInt(input.readLine());
                employee.deleteEmployee(employeeId);
            }else if(button == 4){
                //update name using  employeeId
                System.out.println("Update employee name using Id : Enter Id");
                int employeeId = Integer.parseInt(input.readLine());
                System.out.println("Enter Name :");
                String  newName = input.readLine();
                 employee.updateEmployeeNameById(newName,employeeId);
            }
            else if(button == 5){
                //sort employee by id
                List<Employee> em = employee.sortEmployeeByCityAndName();
//                em.sort((Employee em1, Employee em2 ) -> em1.getName().compareTo(em2.getName()));
                for (Employee empl : em){
                    System.out.println(empl.getCity()+" "+empl.getName()+" "+ empl.getBirthday());
                }

            }
            else if(button==6){
                System.out.println("Thank  you "+name+ " for using my  console app");
                break;
            }
        }

    }
}
