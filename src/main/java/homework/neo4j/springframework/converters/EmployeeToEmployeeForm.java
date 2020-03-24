package homework.neo4j.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import homework.neo4j.springframework.commands.EmployeeForm;
import homework.neo4j.springframework.domain.Employee;

@Component
public class EmployeeToEmployeeForm implements Converter<Employee, EmployeeForm>{
	@Override
    public EmployeeForm convert(Employee employee) {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.setId(employee.getId());
        employeeForm.setName(employee.getName());
        employeeForm.setSalary(employee.getSalary());
        employeeForm.setImageUrl(employee.getImageUrl());
        return employeeForm;
    }
}
