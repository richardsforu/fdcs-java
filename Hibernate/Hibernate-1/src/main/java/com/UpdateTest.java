package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cts.db.config.HibernateUtil;
import com.cts.employee.entity.Department;
import com.cts.employee.entity.Employee;

public class UpdateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session ses=sf.openSession();
		
	
		Employee emp=new Employee();
		emp.setEmpId(10);
		emp.setEmpName("Rose Mella3");
		emp.setSalary(3476);
		
		
		
		ses.update(emp);
		
		ses.beginTransaction().commit();
		
		System.out.println(" --- Done ---");
		
		
		
		
		
		

	}

}
