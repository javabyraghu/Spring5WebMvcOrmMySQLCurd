package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.raghu.dao.IEmployeeDao;
import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao; //HSA-S

	@Transactional
	public Integer saveEmployee(Employee emp) {
		//calculations
		double sal = emp.getEmpSal();

		emp.setEmpHra(sal * 25/100.0);
		emp.setEmpTa(sal * 12/100.0);

		/*int id = dao.saveEmployee(emp);
		return id;*/
		return dao.saveEmployee(emp);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		List<Employee> list = dao.getAllEmployees();
		/*Collections.sort(
				list, 
				(e1,e2)->e1.getEmpName().compareTo(e2.getEmpName())
				);*/

		return list;
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		//calculations
		double sal = emp.getEmpSal();

		emp.setEmpHra(sal * 25/100.0);
		emp.setEmpTa(sal * 12/100.0);
		dao.updateEmployee(emp);
	}
	
	@Transactional(readOnly = true)
	public long getEmpnameCount(String empName) {
		return dao.getEmpnameCount(empName);
	}
}
