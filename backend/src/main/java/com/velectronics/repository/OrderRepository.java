package com.velectronics.repository;
import com.velectronics.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {}
