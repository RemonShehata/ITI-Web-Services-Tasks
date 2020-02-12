/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author remon
 */
@XmlRootElement(name = "employee")
public class Employee {

    private String id;
    private String name;
    private String phone;
    private float salary;
    private String position;

    public Employee() {
    }

    public Employee(String id, String name, String phone, float salary, String position) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
