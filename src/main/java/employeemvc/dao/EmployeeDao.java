package employeemvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employeemvc.dto.Employee;
@Component
public class EmployeeDao {
	
	 @Autowired
	   EntityManager em;
	   
	   
	   public Employee saveEmployee(Employee emp) {
		   em.getTransaction().begin();
		   em.persist(emp);
		   em.getTransaction().commit();
		   return emp;
	   }
	   
	   public Employee findById(int empId) {
		   return em.find(Employee.class, empId);
	   }
	   
	   public Employee deleteById(int empId) {
		   Employee emp=findById(empId);
		   if(emp!=null) {
			   em.getTransaction().begin();
			   em.remove(emp);
			   em.getTransaction().commit();
			   return emp;
		   }
		   return null;
	   }
	   
	   public Employee updateEmployee(Employee emp,int empId) {
		   Employee exemp=findById(empId);
		   if(exemp!=null) {
			   emp.setEmpId(empId);
			   em.getTransaction().begin();
			   Employee updated= em.merge(emp);
			   em.getTransaction().commit();
			   return updated;
		   }
		   return null;
	   }
	   
	   public List<Employee>getAllEmployee(){
		   Query query= em.createQuery("select e from Employee e");
		   List<Employee>allemp=query.getResultList();
		   return allemp;
	   }
	   
	   public Employee findByEmail(String empEmail) {
		    Query query= em.createQuery("select e from Employee e where e.empEmail=?1");
		   query.setParameter(1, empEmail);
		   Employee emp=(Employee) query.getSingleResult();
		   return emp;
	   }

}
