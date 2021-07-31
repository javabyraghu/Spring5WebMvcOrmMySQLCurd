package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping("/all")
	public String displayAll(Model model) {
		//fetching data from SL
		List<Employee> emps =  service.getAllEmployees();
		//send data to UI
		model.addAttribute("list", emps);
		//Goto UI Page
		return "EmployeeData";
	}


	//4. delete record
	@GetMapping("/delete")
	public String deleteEmp( //read input
			@RequestParam("id") Integer id,
			Model model
			) 
	{
		//call service
		service.deleteEmployee(id);
		//create message
		String message = "Employee '"+id+"' Deleted!";
		//send message to UI
		model.addAttribute("message", message);
		//goto UI Page
		return "EmployeeMessage";
	}


	//5. show data in edit page
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam("id") Integer id,
			Model model
			) 
	{
		//call service with id input returns employee object
		Employee employee = service.getOneEmployee(id);

		//send object to UI(FORM FILLING)
		model.addAttribute("employee", employee);

		//goto UI PAGE
		return "EmployeeEdit";
	}


	//6. do Update on submit
	@PostMapping("/update")	
	public String doUpdate(
			@ModelAttribute("employee") Employee emp, //Read Form Data
			Model model //send data to UI
			) 
	{
		service.updateEmployee(emp);
		String message = "Employee '"+emp.getEmpId()+"' Updated!";
		//send message to UI
		model.addAttribute("message", message);
		//goto UI Page
		return "EmployeeMessage";
	}

	//7. AJAX validation
	@GetMapping("/validate")
	@ResponseBody
	public String validateName(
			@RequestParam("name") String empName
			) 
	{
		String message = "";
		if(service.getEmpnameCount(empName)>0) {
			message = "Employee Name " + empName + " already exist!";
		} 
		return message; //return type is not page name
	}

	//8. Export data to excel
	@GetMapping("/excel")
	public ModelAndView showExcelData() {
		ModelAndView m = new ModelAndView();
		m.setViewName("empExcelView");
		
		List<Employee> list =  service.getAllEmployees();
		m.addObject("list", list);
		
		return m;
	}
	
	//9. export data to PDF
	@GetMapping("/pdf")
	public ModelAndView showPdfData() {
		ModelAndView m = new ModelAndView();
		m.setViewName("empPdfView");

		//fetch data from DB and send to Document
		List<Employee> list =  service.getAllEmployees();
		m.addObject("list", list);
		
		return m;
	}
	
}
