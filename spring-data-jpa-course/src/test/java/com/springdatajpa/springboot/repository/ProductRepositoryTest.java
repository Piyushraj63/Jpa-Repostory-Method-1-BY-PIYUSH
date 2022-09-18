package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//JPA REPOSITORY METHOD\\

@SuppressWarnings("unused")
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);

        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    
    
    @Test  
    void updateUsingSaveMethod(){

        // find or retrieve an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 2 MenNAme");
        product.setDescription("updated product 2 descMen");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Product product = productRepository.findById(id).get();
        System.out.println(product.getName());
    }
    
    
    @Test
    void saveAllMethod(){
        // create product
        Product product = new Product();
        product.setName("Java");
        product.setDescription("Java  description");
        product.setSku("100Java");
        product.setPrice(new BigDecimal(2200));
        product.setActive(true);
        product.setImageUrl("Java.png");

        // create product
        Product product3 = new Product();
        product3.setName("C++");
        product3.setDescription("C++ description");
        product3.setSku("100C++");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("C++.png");

        Product product4 = new Product();
        product4.setName("JavaScript");
        product4.setDescription("JavaScript  description");
        product4.setSku("JavaScript1012");
        product4.setPrice(new BigDecimal(2200));
        product4.setActive(true);
        product4.setImageUrl("JavaScript.png");

        // create product
        Product product5 = new Product();
        product5.setName("C#");
        product5.setDescription("C# description");
        product5.setSku("C#121");
        product5.setPrice(new BigDecimal(300));
        product5.setActive(true);
        product5.setImageUrl("C#.png");
        
        Product product6 = new Product();
        product6.setName("ObjectiveC");
        product6.setDescription("ObjectiveC  description");
        product6.setSku("ObjectiveC23");
        product6.setPrice(new BigDecimal(2200));
        product6.setActive(true);
        product6.setImageUrl("ObjectiveC.png");
       
        Product product7 = new Product();
        product7.setName("Python");
        product7.setDescription("Python  description");
        product7.setSku("Python12");
        product7.setPrice(new BigDecimal(2200));
        product7.setActive(true);
        product7.setImageUrl("Python.png");
       
        Product product8 = new Product();
        product8.setName("Angular");
        product8.setDescription("Angular  description");
        product8.setSku("Angular181");
        product8.setPrice(new BigDecimal(2200));
        product8.setActive(true);
        product8.setImageUrl("Angular.png");
        
        Product product9 = new Product();
        product9.setName("React");
        product9.setDescription("React  description");
        product9.setSku("React1819");
        product9.setPrice(new BigDecimal(2200));
        product9.setActive(true);
        product9.setImageUrl("React.png");

        Product product10 = new Product();
        product10.setName("ExpressJs");
        product10.setDescription("ExpressJs  description");
        product10.setSku("ExpressJs132");
        product10.setPrice(new BigDecimal(2200));
        product10.setActive(true);
        product10.setImageUrl("ExpressJs.png");
        
        Product product101 = new Product();
        product101.setName("VueJs");
        product101.setDescription("VueJs  description");
        product101.setSku("VueJs34");
        product101.setPrice(new BigDecimal(22050));
        product101.setActive(true);
        product101.setImageUrl("VueJs.png");

        
        
        productRepository.saveAll(List.of(product, product3,product4,product5,product6,product7,product8,product9,product10,product101));

    }

    @Test
    void findAllMethod(){

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod(){

        // productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();

        Product product1 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product, product1));

    }

    @Test
    void existsByIdMethod(){
        Long id = 7L;

        boolean result = productRepository.existsById(id);

        System.out.println(result);
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }
}