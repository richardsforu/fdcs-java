package com;

public class Employee {

	private int empId;
	private String empName;
	private double salary;

	private Department dept;

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

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

	public void display() {
		System.out.println("EmpId: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Salary: " + salary);

		System.out.println("Dept Id: " + dept.getDeptId());
		System.out.println("Dept Name: " + dept.getDeptName());

		System.out.println("LOcation Id: " + dept.getLoc().getLocationId());
		System.out.println("Location Name: " + dept.getLoc().getLocationName());

		System.out.println("-------------------------------------");

	}

}
