package com.blogproject.springbootblogrestapi.payload;

import com.blogproject.springbootblogrestapi.entity.Order;
import com.blogproject.springbootblogrestapi.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
