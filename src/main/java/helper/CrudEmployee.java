package helper;

import database.EmployeeQuery;
import entities.Company;
import entities.Employee;

import java.time.LocalDate;
import java.util.List;

public class CrudEmployee {

    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsEmployee;

    public CrudEmployee() { }

    public void getAllEmployees() {
        resultsEmployee = employeeQuery.getAllEmployees();
        for (Employee emp : resultsEmployee) {
            System.out.print(emp.getIdCompany() + "  -  ");
            System.out.print(emp.getFirstName() + "  -  ");
            System.out.print(emp.getLastName() + "  -  ");
            System.out.print(emp.getEmail() + "  -  ");
            System.out.print(emp.getPhoneNumber()+ "  -  ");
            System.out.print(emp.getAddress() + "  -  ");
            System.out.print(emp.getSalary() + "  -  ");
            System.out.print(emp.getBirthDate() + "  -  ");
            System.out.println(emp.getIdCompany());
        }
    }

    public void findEmployeesByLastName(String lastName){
        resultsEmployee = employeeQuery.getEmployeesByLastname(lastName);
        for (Employee emp : resultsEmployee) {
            System.out.print(emp.getIdCompany() + "  -  ");
            System.out.print(emp.getFirstName() + "  -  ");
            System.out.print(emp.getLastName() + "  -  ");
            System.out.print(emp.getEmail() + "  -  ");
            System.out.print(emp.getPhoneNumber()+ "  -  ");
            System.out.print(emp.getAddress() + "  -  ");
            System.out.print(emp.getSalary() + "  -  ");
            System.out.print(emp.getBirthDate() + "  -  ");
            System.out.println(emp.getIdCompany());
        }
    }

    public void insertEmployee(Employee employee){
        Boolean result = employeeQuery.addEmployee(employee);
        if ( result == true )
            System.out.println(" Employee Added ");
        else
            System.out.println(" Employee NOT Added ");
    }

    public void deleteEmployee(int idEmployee){
        if(employeeQuery.deleteCompany(idEmployee) == 1){
            System.out.println("Employee deleted");
        }else{
            System.out.println("Employee NOT deleted");
        }
    }

    public void updateEmployee(Employee employeeMod) {
        Boolean result = employeeQuery.updateEmployee(employeeMod);
        if ( result == true )
            System.out.println(" Employee Updated ");
        else
            System.out.println(" Employee NOT Updated ");
    }

}
