package com.blogproject.springbootblogrestapi.service.impl;

import com.blogproject.springbootblogrestapi.entity.Order;
import com.blogproject.springbootblogrestapi.entity.Payment;
import com.blogproject.springbootblogrestapi.exception.PaymentException;
import com.blogproject.springbootblogrestapi.payload.OrderRequest;
import com.blogproject.springbootblogrestapi.payload.OrderResponse;
import com.blogproject.springbootblogrestapi.repository.OrderRepository;
import com.blogproject.springbootblogrestapi.repository.PaymentRepository;
import com.blogproject.springbootblogrestapi.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus(("In Progress"));
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        // Assume we only support the debit card for payment now
        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Do not support this card type!");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
