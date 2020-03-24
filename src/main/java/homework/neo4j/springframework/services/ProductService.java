package homework.neo4j.springframework.services;

import java.util.List;

import homework.neo4j.springframework.commands.ProductForm;
import homework.neo4j.springframework.domain.Product;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
