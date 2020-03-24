package homework.neo4j.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import homework.neo4j.springframework.commands.EmployeeForm;
import homework.neo4j.springframework.domain.Employee;


@Component
public class EmployeeFormToEmployee implements Converter<EmployeeForm, Employee>{

	 @Override
	    public Employee convert(EmployeeForm employeeForm) {
	        
		 Employee employee = new Employee();
	   
	         if (employeeForm.getId() != null  && !StringUtils.isEmpty(employeeForm.getId())) {
	        	
	        	employee.setId(new Long (employeeForm.getId()));
	       
	        }
	        employee.setName(employeeForm.getName());
	        employee.setSalary(employeeForm.getSalary());
	        employee.setImageUrl(employeeForm.getImageUrl());
	        return employee;
	    }



}
