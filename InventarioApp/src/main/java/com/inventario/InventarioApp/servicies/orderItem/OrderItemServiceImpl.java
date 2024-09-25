package com.inventario.InventarioApp.servicies.orderItem;

import com.inventario.InventarioApp.entities.OrderItem;
import com.inventario.InventarioApp.repositories.logistics.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return null;
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem) {

    }

    @Override
    public List<OrderItem> getOrderItems() {
        return List.of();
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return List.of();
    }
}
