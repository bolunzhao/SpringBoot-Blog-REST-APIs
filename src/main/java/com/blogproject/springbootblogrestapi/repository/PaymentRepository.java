package com.blogproject.springbootblogrestapi.repository;

import com.blogproject.springbootblogrestapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
