package homework.neo4j.springframework.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import homework.neo4j.springframework.domain.Product;

/**
 * Created by jt on 1/10/17.
 */
@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long> {
}
