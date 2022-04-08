package database;

import entities.Company;
import entities.Employee;
import org.hibernate.internal.ExceptionMapperStandardImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeQuery {

    EntityManager entityManager;  // Variable para obtener la conexion.
    Employee employee;
    List<Employee> listEmployees = null;

    public EmployeeQuery(){
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager(); // abre la conexion con la BD.
        listEmployees = new ArrayList<Employee>();
    }

    public List<Employee> getAllEmployees(){
        Query query=entityManager.createQuery("From Employee");
        listEmployees = (List<Employee>) query.getResultList();
        return listEmployees;
    }

    public List<Employee> getEmployeesByLastname(String lastName)
    {
        Query query=entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :lastName");
        query.setParameter("lastName", lastName);
        listEmployees = query.getResultList();
        return listEmployees;
    }

    public Boolean addEmployee(Employee employee)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return entityManager.contains(employee);
    }

    public int deleteCompany(int idEmployee)
    {
        int result = 0;
        employee = new Employee();

        employee = entityManager.find(Employee.class, idEmployee);
        if(employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            result=1;
        }
        return result;
    }

    public Boolean updateEmployee(Employee employeeMod)
    {
        boolean result = false;
        employee = new Employee();

        employee = entityManager.find(Employee.class, employeeMod.getId());
        if(employee != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(employeeMod);
            entityManager.getTransaction().commit();
            result = entityManager.contains(employeeMod);
        }
        return result;
    }
}
