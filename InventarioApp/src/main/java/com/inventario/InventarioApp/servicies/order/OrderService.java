package com.inventario.InventarioApp.servicies.order;

import com.inventario.InventarioApp.entities.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    List<Order> getOrdersProvider(int customerId);
}
