/**
 * 
 */
package homework.neo4j.repositories;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import homework.neo4j.springframework.domain.Employee;
import homework.neo4j.springframework.repositories.EmployeeRepository;
import homework.neo4j.springframework.services.EmployeeService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;

//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//
//@SpringBootTest(classes = 
/**
 * @author n0j00am
 *
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootNeo4jApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DataJpaTest
@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*@MockBean
	EmployeeRepository employeeRepository;*/
	
	@Autowired
	EmployeeService employeeServiceImpl;
	List<Employee> emplst=new ArrayList<Employee>();
	List<Employee> emplst1=new ArrayList<Employee>();
	

	@Before
	public void setUp() {
		
		Employee empnil=new Employee(234L, "Nilesh", BigDecimal.valueOf(50000.00), "http://picture_server_url.com/nilesh.jpg");
		Employee empsan=new Employee(400L, "Sanjay", BigDecimal.valueOf(10000.00), "http://picture_server_url.com/sanjay.jpg");
		Employee emp3=new Employee(500L, "Sanjay", BigDecimal.valueOf(10000.00), "http://picture_server_url.com/sanjay1.jpg");
		
		
		emplst.add(empnil);
		emplst.add(empsan);
		emplst.add(emp3);
		
		
		emplst1.add(empsan);
		emplst1.add(emp3);
		
		//employeeRepository.save(empnil);
	}
	
	
	@Test
	//listAll
	public void testListAll() {
	
	when(employeeRepository.findAll()).thenReturn(emplst);
	assertEquals(emplst, employeeServiceImpl.listAll());
	
	List<Employee> emplst2=(List<Employee>) employeeRepository.findAll();
	
	assertNotNull(emplst2);
	assertEquals(2, emplst2.size());
	assertEquals(234L,emplst2.get(0));
	assertEquals(400L,emplst2.get(1));
	
	
	}
	
@Test
//getById
//findById

public void TestGetById() {
	
	Employee emp4=new Employee(500L, "emp4", BigDecimal.valueOf(50000.00), "http://picture_server_url.com/emp4.jpg");
	
	/*when(employeeRepository.findById(234L)).thenReturn(emp4);
	assertEquals(emp4, employeeServiceImpl.getById(500L));
	
	*/
	
	Optional<Employee> emp=employeeRepository.findById(234L);
	
	assertEquals(true, emp.isPresent());
	assertEquals((emp.get()).getId(), new Long(234L));
	assertNotNull(emp);
}
	

@Test
//employeeRepository.save(employee);

public void TestSave() {

	Employee john=new Employee(600L, "John", BigDecimal.valueOf(70000.00), "http://picture_server_url.com/john.jpg");
	
	Employee johnsave =employeeRepository.save(john);
	assertEquals(john, johnsave);
	assertEquals(john.getId(), johnsave.getId());

}

@SuppressWarnings("deprecation")
@Test
public  void TestfindByEmployeeName() {
	String name="Sanjay";
	
	when(employeeRepository.findByname(name)).thenReturn(emplst1);
	assertEquals(emplst1.size(),(employeeServiceImpl.findByEmployeeName(name)).size());
	assertEquals(2, emplst1.size() );
	assertEquals(400L, (emplst1.get(0).getId()).doubleValue() );
}
	
	
	
}
