package homework.neo4j.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan("homework.neo4j.springframework.domain.*") 
public class SpringBootNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNeo4jApplication.class, args);
	}
}
