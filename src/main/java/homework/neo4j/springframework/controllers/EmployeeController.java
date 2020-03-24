/**
 * 
 */
package homework.neo4j.springframework.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import homework.neo4j.springframework.commands.EmployeeForm;
import homework.neo4j.springframework.converters.EmployeeToEmployeeForm;
import homework.neo4j.springframework.domain.Employee;
import homework.neo4j.springframework.services.EmployeeService;


/**
 * @author n0j00am
 *
 */
@Controller
public class EmployeeController {

	private EmployeeService employeeService;

    private EmployeeToEmployeeForm employeeToEmployeeForm;

    @Autowired
    public void setEmployeeToEmployeeForm(EmployeeToEmployeeForm employeeToEmployeeForm) {
        this.employeeToEmployeeForm = employeeToEmployeeForm;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String redirectToList(){
        return "redirect:/employee/list";
    }

    @RequestMapping({"/employee/list", "/employee"})
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.listAll());
        return "employee/list";
    }

    @RequestMapping("/employee/show/{id}")
    public String getEmployee(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.getById(Long.valueOf(id)));
        return "employee/show";
    
    }
   
    @RequestMapping("/employee/view/{name}")
    public String getlistEmployeesByName(@PathVariable String name,Model model){
        model.addAttribute("employees", employeeService.findByEmployeeName(name) );
       // return "employee/display";
        return "employee/list";
    }
    
    
    
    @RequestMapping("/employee/view/{name}/{id}")
    public String getlistEmployeesByNameAndId(@PathVariable String name,@PathVariable String id,Model model){
        model.addAttribute("employees", employeeService.findbyNameAndId(name, Long.valueOf(id)) );
        return "employee/list";
    
    }
    
    
 @RequestMapping("employee/edit/{id}")
    
    public String edit(@PathVariable String id, Model model){
        Employee employee = employeeService.getById(Long.valueOf(id));
        EmployeeForm employeeForm = employeeToEmployeeForm.convert(employee);

        model.addAttribute("employeeForm", employeeForm);
        return "employee/employeeform";
 }
	
		 @RequestMapping("/employee/new")
		 public String newEmployee(Model model){
		     model.addAttribute("employeeForm", new EmployeeForm());
		     return "employee/employeeform";
		   
		 }
 
 
		 @RequestMapping(value = "/employee", method = RequestMethod.POST)
		    public String saveOrUpdateProduct(@Valid EmployeeForm employeeForm, BindingResult bindingResult){

		        if(bindingResult.hasErrors()){
		        	  return "employee/employeeform";
		        }

		        Employee savedEmployee = employeeService.saveOrUpdateEmployeeForm(employeeForm);

		        return "redirect:/employee/show/" + savedEmployee.getId();
		    }

 
		 @RequestMapping("/employee/delete/{emp_id}")
		    public String delete(@PathVariable String emp_id){
		        employeeService.delete(Long.valueOf(emp_id));
		        return "redirect:/employee/list";
		    }
 
 
	
}
