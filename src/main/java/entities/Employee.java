package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "idEmployee", nullable = false)
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phoneNumber", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "Salary", nullable = false)
    private Double salary;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCompany", nullable = false)
    private Company idCompany;

    @OneToMany(mappedBy = "idEmployee")
    private Set<Institution> institutions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEmployee")
    private Set<Child> children = new LinkedHashSet<>();

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Set<Institution> institutions) {
        this.institutions = institutions;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}