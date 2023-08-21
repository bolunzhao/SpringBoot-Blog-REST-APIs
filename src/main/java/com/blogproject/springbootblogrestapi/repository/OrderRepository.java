package com.blogproject.springbootblogrestapi.repository;

import com.blogproject.springbootblogrestapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
