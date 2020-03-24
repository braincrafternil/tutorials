package homework.neo4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration("homework.neo4j.repositories")
@SpringBootConfiguration
public class SpringBootNeo4jApplicationTests {

	@Test
	public void contextLoads() {
	}

}
