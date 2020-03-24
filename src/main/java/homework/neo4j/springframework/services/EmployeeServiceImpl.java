/**
 * 
 */
package homework.neo4j.springframework.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import homework.neo4j.springframework.commands.EmployeeForm;
import homework.neo4j.springframework.converters.EmployeeFormToEmployee;
import homework.neo4j.springframework.domain.Employee;
import homework.neo4j.springframework.repositories.EmployeeRepository;

/**
 * @author n0j00am
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
    private EmployeeFormToEmployee employeeFormToEmployee;

  /*  @Value("${Database.connectionUrl}")
    private String connectionUrl;*/
   /* @Value("${Database.sqlquery}")
    private String sqlquery;
    */
     
    
    
    
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeFormToEmployee employeeFormToEmployee) {
        this.employeeRepository = employeeRepository;
        this.employeeFormToEmployee = employeeFormToEmployee;
    }
	
	@Override
	public List<Employee> listAll() {
		 List<Employee> employees = new ArrayList<>();
	    
		 employeeRepository.findAll().forEach(employees::add); 
	     
		/* Iterable<Employee> emplst= 
		 Iterator<Employee> itr = emplst.iterator(); 
	        while (itr.hasNext()) {
	        	Employee e1 =new Employee();
	        	Employee e=	(Employee)itr.next();
	        	e1.setId(new Long(e.getId()));
	        	e1.setName(e.getName());
	        	e1.setSalary(e.getSalary());
	        	e1.setImageUrl(e.getImageUrl());
	        }*/
				 
				 return employees;
	}
	@Override
	public Employee getById(Long id) {
		   return employeeRepository.findById(id).orElse(null);
	}
	@Override
	public Employee saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	
	@Override
	public void delete(Long id) {
		  employeeRepository.deleteById(id);

	}


	@Override
	public Employee saveOrUpdateEmployeeForm(EmployeeForm employeeForm) {
		Employee savedEmployee = saveOrUpdate(employeeFormToEmployee.convert(employeeForm));

        System.out.println("Saved Employee Id: " + savedEmployee.getId());
        return savedEmployee;
        }

	@Override
	public List<Employee> findbyNameAndId(String name, Long id) {
		List<Employee> emplst=new ArrayList<Employee>();
		
		emplst= findByEmployeeName(name);
		emplst.add(getById(id));
		
		// TODO Auto-generated method stub
		return emplst;
	}

	@Override
	public List<Employee> findByEmployeeName(String name) {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findByname(name);
	}


	
	
	
	
	/*@Override
	public List<Employee> findByEmployeeName(String name) {
		// TODO Auto-generated method stub
	//https://www.baeldung.com/java-neo4j	
		//http://www.datanucleus.org/products/accessplatform_3_1/jpa/guides/tutorial_neo4j.html
		List<Employee> emplst=new ArrayList<Employee>();
		//String sqlquery="MATCH (e:Employee) WHERE employee.name ="+"'"+name+"'"+ " RETURN e.id,e.name,e.salary,e.imageUrl";
		String sqlquery="MATCH(employee:Employee) WHERE employee.name ={1} RETURN  id(employee), employee.name,employee.salary,employee.imageUrl";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			 conn = DriverManager.getConnection(connectionUrl);
			 stmt=	conn.prepareStatement(sqlquery);
			stmt.setString(1,name);
			ResultSet resultset=	stmt.executeQuery();
			ResultSetMetaData rsmd=resultset.getMetaData();  
			  
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			for (int i=1;i<=rsmd.getColumnCount();i++) {
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(i));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(i));  	
			}
			
			while (resultset.next()) {
				Employee empobj=new Employee();
			
				empobj.setId(new Long (resultset.getInt("id(employee)")));
				empobj.setName(resultset.getString("employee.name"));
				empobj.setSalary(new BigDecimal(resultset.getString("employee.salary")));
				empobj.setImageUrl(resultset.getString("employee.imageUrl"));
				emplst.add((empobj));
				
			}
			resultset.close();
			stmt.close();
			conn.close();
		
		} catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		return	emplst;
		
		
		
		
		
		MATCH (Employee)  
WHERE Employee.name = "Kumar Sangakkara" OR Employee.emp_id=1 
RETURN Employee
		
	//	String sqlquery="MATCH (employee:Employee) WHERE employee.name ="+"'"+name+"'"+ " RETURN employee.id,employee.name,employee.salary,employee.imageUrl";
//		List<Employee> emplst=new ArrayList<Employee>();
		ResultSet rs = stmt.executeQuery(
      "MATCH (company:Company)-[:owns]-> (car:Car)" +
      "WHERE car.make='tesla' and car.model='modelX'" +
      "RETURN company.name");
		
		
		java.sql.SQLException: org.neo4j.driver.v1.exceptions.ClientException: Variable `Sanjay` not defined (line 1, column 48 (offset: 47))
"MATCH (employee:Employee) WHERE employee.name =Sanjay RETURN employee:Employee"
         
		
		
//		String connectionUrl = "jdbc:neo4j:bolt://localhost/?user=neo4j,password=Nilesh123,scheme=basic";
		
			//		try {
				//		Class.forName("org.neo4j.jdbc.bolt.BoltDriver");
						//org.neo4j.jdbc.bolt.BoltDriver
						Connection con = DriverManager.getConnection(
								  "jdbc:neo4j:bolt://localhost/?user=neo4j,password=Nilesh123,scheme=basic");
					
						private Long id;
    private String name;
    private BigDecimal salary;
    private String imageUrl;
						
						
						
					Connection con = DriverManager.getConnection(connectionUrl);
					Statement stmt=	con.createStatement();
					ResultSet resultset=	stmt.executeQuery(sqlquery);
			
			while (resultset.next()) {
				
					

				
				System.out.println(resultset.getLong("employee.id"));
				System.out.println(resultset.getString(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				
				
				Employee empobj=new Employee();
				empobj.setId(resultset.getLong("employee.id"));
				empobj.setName(resultset.getString("employee.name"));
				empobj.setSalary(new BigDecimal(resultset.getString("employee.salary")));
				empobj.setImageUrl(resultset.getString("employee.imageUrl"));
				emplst.add(empobj);
	//		}
			
			
	//	}/* catch (ClassNotFoundException e) {
		//	e.printStackTrace();
	//	}*/
			//	catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		
	//	return emplst;}
		
	

}
