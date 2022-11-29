package main;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name")
    public String first_name;
    @Column(name = "last_name")
    public String last_name;
    @Column(name = "years")
    public int years;
    @Column(name = "address")
    public String address;
    @Column(name = "salary")
    public int salary;

    public Employee() { }

    public Employee(int id, String first_name, String last_name, int years, String address, int salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.years = years;
        this.address = address;
        this.salary = salary;
    }

    public Employee(String first_name, String last_name, int years, String address, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.years = years;
        this.address = address;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getFirstName() {
        return first_name;
    }
    public String getLastName() {
        return last_name;
    }
    public int getYears() {
        return years;
    }
    public String getAddress() {
        return address;
    }
    public int getSalary() {
        return salary;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + first_name + " " + last_name + " " + years + " " + address + " " + salary;
    }
}
