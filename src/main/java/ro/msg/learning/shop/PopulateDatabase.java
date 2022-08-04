package ro.msg.learning.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.*;

import java.math.BigDecimal;

@Configuration
public class PopulateDatabase {

    private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);
    private final String string = "Preloaded %s";

    @Bean
    CommandLineRunner initDatabase(LocationRepository locationRepository, ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository, ProductRepository productRepository, StockRepository stockRepository) {
        return args -> {
            ProductCategory pc1 =  new ProductCategory("Laptops", "Laptops, Notebooks, 2in1s");
            ProductCategory pc2 =  new ProductCategory("TV", "TVs, SmartTV, Monitors");
            productCategoryRepository.save(pc1);
            productCategoryRepository.save(pc2);
            productCategoryRepository.findAll().forEach(productCategory -> log.info(String.format(string, productCategory)));


            Supplier s1 = new Supplier("Lenovo Products");
            Supplier s2 = new Supplier("Apple Inc.");
            supplierRepository.save(s1);
            supplierRepository.save(s2);
            supplierRepository.findAll().forEach(supplier -> log.info(String.format(string, supplier)));

            Product p1 = new Product("Lenovo Y700", "Best price/quality rate", BigDecimal.valueOf(1000), 3.0, null, null, null);
            Product p2 = new Product("LG TV 9", "Better than the others", BigDecimal.valueOf(700), 10.2, null, null, null);
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.findAll().forEach(product -> log.info(String.format(string, product)));

            Location l1 = new Location("Timisoara Dept", "Romania", "Timisoara", "Timis", "Str. Garii 12");
            Location l2 = new Location("Cluj-Napoca Dept", "Romania", "Cluj-Napoca", "Cluj", "Str. Garii 25");
            locationRepository.save(l1);
            locationRepository.save(l2);
            locationRepository.findAll().forEach(location -> log.info(String.format(string, location)));

            Stock st1 = new Stock(new Stock.StockId(p1, l1), 1);
            Stock st2 = new Stock(new Stock.StockId(p2, l2), 2);
            Stock st3 = new Stock(new Stock.StockId(p1, l2), 3);
            stockRepository.save(st1);
            stockRepository.save(st2);
            stockRepository.save(st3);
            stockRepository.findAll().forEach(stock -> log.info(String.format(string, stock)));
        };
    }
}
