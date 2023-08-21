package com.blogproject.springbootblogrestapi.service;

import com.blogproject.springbootblogrestapi.payload.OrderRequest;
import com.blogproject.springbootblogrestapi.payload.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
