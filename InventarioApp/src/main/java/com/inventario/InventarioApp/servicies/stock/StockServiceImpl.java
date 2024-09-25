package com.inventario.InventarioApp.servicies.stock;

import com.inventario.InventarioApp.entities.Stock;
import com.inventario.InventarioApp.repositories.inventary.ProductRepository;
import com.inventario.InventarioApp.repositories.inventary.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public StockServiceImpl(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Stock getStockById(int id) {
        return null;
    }

    @Override
    public Stock addStock(Stock stock) {
        return null;
    }

    @Override
    public Stock updateStock(Stock stock) {
        return null;
    }

    @Override
    public void deleteStock(int id) {

    }

    @Override
    public List<Stock> getAllStocks() {
        return List.of();
    }

    @Override
    public List<Stock> getTotalStocks() {
        return List.of();
    }

    @Override
    public List<Stock> getStocksProduct(int id) {
        return List.of();
    }
}
