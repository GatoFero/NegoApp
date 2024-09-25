package com.inventario.InventarioApp.servicies.orderItem;

import com.inventario.InventarioApp.entities.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(OrderItem orderItem);
    List<OrderItem> getOrderItems();
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
}
