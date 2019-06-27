package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cts.db.config.HibernateUtil;
import com.cts.employee.entity.Department;
import com.cts.employee.entity.Employee;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session ses=sf.openSession();
		
		Employee emp=new Employee();
		emp.setEmpId(3);
		emp.setEmpName("Ozvitha");
		emp.setSalary(74678);

		
		ses.saveOrUpdate(emp);
		
		ses.beginTransaction().commit();
		
		System.out.println(" --- Done ---");
		
		
		
		

	}

}
