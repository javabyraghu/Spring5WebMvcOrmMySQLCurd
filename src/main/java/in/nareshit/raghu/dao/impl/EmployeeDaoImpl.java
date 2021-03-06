package in.nareshit.raghu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.dao.IEmployeeDao;
import in.nareshit.raghu.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private HibernateTemplate ht; //HAS-A
	
	public Integer saveEmployee(Employee emp) {
		return (Integer) ht.save(emp);
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = ht.loadAll(Employee.class);
		return list;
	}
	
	public void deleteEmployee(Integer id) {
		Employee emp = new Employee();
		emp.setEmpId(id);
		ht.delete(emp);
	}
	
	public Employee getOneEmployee(Integer id) {
		return ht.get(Employee.class, id);
	}
	
	public void updateEmployee(Employee emp) {
		ht.update(emp);
	}
	
	public long getEmpnameCount(String empName) {
		String hql = "SELECT COUNT(empName) FROM " + Employee.class.getName() +" WHERE empName=?0";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> countList =  (List<Long>) ht.find(hql, empName);
		return countList.get(0);
	}
}
