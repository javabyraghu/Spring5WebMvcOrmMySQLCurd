package in.nareshit.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	//1. show register page
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	
	//2. On submit read Form data and save
	//Link URL : save + POST
	@PostMapping("/save")
	public String createEmployee(
			@ModelAttribute("employee") Employee emp, //Read Form Data
			Model model //send data to UI
			)
	{
		//call service
		Integer id = service.saveEmployee(emp);
		//create message
		String msg = "Employee '"+id+"' Created";
		//send message to UI
		model.addAttribute("message", msg);
		//goto UI page
		return "EmployeeRegister";
	}
	
	
	//3. display all Records
	
	
	//4. delete record
	
	
	//5. show data in edit page
	
	
	//6. do Update on submit
}
