package springBootEmployeeSystem.Service;

import java.util.List;

import springBootEmployeeSystem.Entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	Employee addEmployee(Employee employee);

}
