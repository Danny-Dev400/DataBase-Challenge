package mainTest;

import database.CompanyQuery;
import entities.Employee;
import helper.CrudCompany;
import helper.CrudEmployee;

import java.time.LocalDate;

public class Principal {

    protected static CrudCompany crudCompany = new CrudCompany();
    protected static CompanyQuery companyQuery = new CompanyQuery();
    protected static CrudEmployee crudEmployee = new CrudEmployee();

    public static void main(String[] args)
    {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Daniel");
        employee.setLastName("Salazar");
        employee.setEmail("dsalazar@gmail.com");
        employee.setPhoneNumber("3006779188");
        employee.setAddress("cra 20");
        employee.setSalary(2500.0);
        employee.setBirthDate(LocalDate.now());
        employee.setIdCompany(companyQuery.getCompanybyId(1));

        crudEmployee.getAllEmployees();
        crudEmployee.findEmployeesByLastName("Gonzalez");
        crudEmployee.insertEmployee(employee);

        employee.setPhoneNumber("3006111111");
        employee.setSalary(3500.0);

        crudEmployee.updateEmployee(employee);
        crudEmployee.deleteEmployee(1);
    }
}
