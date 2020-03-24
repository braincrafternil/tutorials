/**
 * 
 */
package homework.neo4j.springframework.services;

import java.util.List;

import homework.neo4j.springframework.commands.EmployeeForm;
import homework.neo4j.springframework.domain.Employee;


/**
 * @author n0j00am
 *
 */
public interface EmployeeService {


    List<Employee> listAll();

    Employee getById(Long id);
    
   List<Employee> findByEmployeeName(String name);
    
    List<Employee> findbyNameAndId(String name,Long id);
    

    Employee saveOrUpdate(Employee employee);

    void delete(Long id);

    Employee saveOrUpdateEmployeeForm(EmployeeForm employeeForm);

}
