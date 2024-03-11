package hibernate_Employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import hibernate_Employee.dto.Employee;

public class Employee_dao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("rani").createEntityManager();		
	}
	
	public void addEmployee(Employee employee) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	
	public List<Employee> fetchAllEmployee() {
		EntityManager manager=getEntityManager();
		
		return manager.createQuery("SELECT e FROM Employee e").getResultList();
	}
	
	public Employee getById(int id) {
		EntityManager manager=getEntityManager();
		return manager.find(Employee.class, id);
	}
	
	public List<Employee> getByName(String name) {
		EntityManager manager=getEntityManager();
		String jpql="Select e FROM Employee e WHERE e.name=:name";
		return manager.createQuery(jpql).setParameter("name", name.toLowerCase()).getResultList();
	}
	
	public List<Employee> getBySalary(double salary) {
		EntityManager manager=getEntityManager();
		String jpql="Select e FROM Employee e WHERE e.salary=:salary";
		return manager.createQuery(jpql).setParameter("salary",salary).getResultList();
	}
	
	public List<Employee> getByDesignation(String designation) {
		EntityManager manager=getEntityManager();
		String jpql="Select e FROM Employee e WHERE e.designation=:designation";
		return manager.createQuery(jpql).setParameter("designation",designation).getResultList();
	}
	
	public Employee getByEmail(String email) {
		EntityManager manager=getEntityManager();
		String jpql="Select e FROM Employee e WHERE e.email=:email";
		return (Employee) manager.createQuery(jpql).setParameter("email", email).getSingleResult();
	}
	
	public Employee getByPhone(long phone) {
		EntityManager manager=getEntityManager();
		String jpql="Select e FROM Employee e WHERE e.phone=:phone";
		return (Employee) manager.createQuery(jpql).setParameter("phone", phone).getSingleResult();
	}
	
	public void deleteEmployee(int id) {
		EntityManager manager=getEntityManager();
		Employee employee=manager.find(Employee.class, id);
		EntityTransaction transaction=manager.getTransaction();
		if (employee!=null) {
			transaction.begin();
			manager.remove(employee);
			transaction.commit();
			
		} else {
			System.out.println("Employee with given id not found");
		}
	}
	
	public void updateName(int id,String name) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee employee=manager.find(Employee.class, id);
		if (employee!=null) {
			employee.setName(name);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		} else {
			System.out.println("Employee with given id "+id+" not found");

		}
		
	}
	
	public void updateDesignation(int id,String designation) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee employee=manager.find(Employee.class, id);
		if (employee!=null) {
			employee.setDesignation(designation);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		} else {
			System.out.println("Employee with given id "+id+" not found");

		}
		
	}
	
	public void updateEmail(int id,String email) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee employee=manager.find(Employee.class, id);
		if (employee!=null) {
			employee.setEmail(email);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		} else {
			System.out.println("Employee with given id "+id+" not found");

		}
		
	}
	
	public void updatePhone(int id,long phone) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee employee=manager.find(Employee.class, id);
		if (employee!=null) {
			employee.setPhone(phone);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		} else {
			System.out.println("Employee with given id "+id+" not found");

		}
	}
	
	public void editEmployee(int id,Employee employee) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee dbemployee=manager.find(Employee.class, id);
		if (dbemployee!=null) {			
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		} else {
			System.out.println("Student with given id not found");

		}
	}
	
}
