package ro.msg.learning.shop.populator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.repositories.SupplierRepository;

@Configuration
public class PopulateDatabase {

    private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository) {
        return args -> {
            productCategoryRepository.save(new ProductCategory("Laptops", "Laptops, Notebooks, 2in1s"));
            productCategoryRepository.save(new ProductCategory("TV", "TVs, SmartTV, Monitors"));

            productCategoryRepository.findAll().forEach(productCategory -> log.info(String.format("Preloaded %s", productCategory)));

            supplierRepository.save(new Supplier("Lenovo Products"));
            supplierRepository.save(new Supplier("Apple Inc."));

            supplierRepository.findAll().forEach(supplier -> log.info(String.format("Preloaded %s", supplier)));
        };
    }
}
