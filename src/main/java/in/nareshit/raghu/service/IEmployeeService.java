package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee emp);
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee emp);
}
