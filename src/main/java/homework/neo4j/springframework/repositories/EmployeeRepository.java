/**
 * 
 */
package homework.neo4j.springframework.repositories;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import homework.neo4j.springframework.domain.Employee;


/**
 * @author n0j00am
 *
 */
@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {

	public List<Employee>  findByname(@Param("name") String name);
	 
  
}
