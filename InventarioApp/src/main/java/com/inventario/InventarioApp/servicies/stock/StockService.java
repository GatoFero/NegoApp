package com.inventario.InventarioApp.servicies.stock;

import com.inventario.InventarioApp.entities.Stock;

import java.util.List;

public interface StockService {

    Stock getStockById(int id);
    Stock addStock(Stock stock);
    Stock updateStock(Stock stock);
    void deleteStock(int id);
    List<Stock> getAllStocks();
    List<Stock> getTotalStocks();
    List<Stock> getStocksProduct(int id);
}
