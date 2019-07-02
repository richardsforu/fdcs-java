package com.cts.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "gq", query = "from Employee")
@NamedNativeQuery(name="sqlQuery1",query="select e.empId,e.empName,e.salary from cts.employee e")

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Id
	private int empId;
	private String empName;
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
