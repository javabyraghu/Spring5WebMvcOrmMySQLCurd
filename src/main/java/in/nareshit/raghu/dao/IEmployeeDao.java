package in.nareshit.raghu.dao;

import java.util.List;

import in.nareshit.raghu.model.Employee;

public interface IEmployeeDao {

   Integer saveEmployee(Employee emp);
   List<Employee> getAllEmployees();
   void deleteEmployee(Integer id);
}
