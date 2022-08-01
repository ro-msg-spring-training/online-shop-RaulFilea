package ro.msg.learning.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.repositories.ProductRepository;

import java.math.BigDecimal;

@Configuration
public class PopulateDatabase {

    private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository) {
        return args -> {
            productCategoryRepository.save(new ProductCategory("Laptops", "Laptops, Notebooks, 2in1s"));
            productCategoryRepository.save(new ProductCategory("TV", "TVs, SmartTV, Monitors"));

            productCategoryRepository.findAll().forEach(productCategory -> log.info(String.format("Preloaded %s", productCategory)));

            //productRepository.save(new Product("Lenovo Y700", "Gaming Laptop", new BigDecimal(1000), 3.0, 0, 0, null));

            //productRepository.findAll().forEach(product -> log.info(String.format("Preloaded %s", product)));
        };
    }
}
