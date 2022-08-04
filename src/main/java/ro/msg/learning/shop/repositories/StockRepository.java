package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findStockById(Stock.StockId stockId);
    Optional<Stock> deleteStockById(Stock.StockId stockId);
}
