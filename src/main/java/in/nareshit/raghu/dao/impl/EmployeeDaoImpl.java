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
}
