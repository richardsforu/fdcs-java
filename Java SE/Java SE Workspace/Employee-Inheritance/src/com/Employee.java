package com;

public abstract  class Employee {

	private int empId;
	private String empName;

	private double salary;

	public void acceptData() {
		System.out.println("--- Employee class accept Data");
	}

	public abstract void processSalary();

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
		System.out.println("Id: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Salary: " + salary);
		System.out.println("--------------------------");
	}

}