package springBootEmployeeSystem.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootEmployeeSystem.Entity.Employee;
import springBootEmployeeSystem.Repository.EmployeeRepository;
import springBootEmployeeSystem.Service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired	
	private EmployeeRepository employeerepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeerepository.findAll();
	}
	
	
	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> result = employeerepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Employee();
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeerepository.save(employee);
	}


	
	@Override
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> result = employeerepository.findById(employee.getId());
		Employee existing = result.get();
		existing.setFirstname(employee.getFirstname());
		existing.setLastname(employee.getLastname());
		existing.setEmail(employee.getEmail());

		return employeerepository.save(existing);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.employeerepository.deleteById(id);
		
	}

	

}
