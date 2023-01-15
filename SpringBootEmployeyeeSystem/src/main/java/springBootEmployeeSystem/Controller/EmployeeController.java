package springBootEmployeeSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springBootEmployeeSystem.Entity.Employee;
import springBootEmployeeSystem.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	//display all employees
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		
		model.addAttribute("Listemployees", service.getAllEmployees());
		return "index";
	}
	
	//CREATE a new employee
	@GetMapping("/add")
	public String createNewEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add-employee";
	}
	
	@PostMapping("/addEmployee")
	public String createEmployee( Employee employee) {
		service.addEmployee(employee);
		return "redirect:/";	
	}
	
	@GetMapping("/edit/{id}")
	public String employeeUpdatePage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", service.getEmployeeById(id));
		return "update";

	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		service.updateEmployee(employee);
		return "redirect:/";
	}
	

	//DELETE an employee
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}

}
