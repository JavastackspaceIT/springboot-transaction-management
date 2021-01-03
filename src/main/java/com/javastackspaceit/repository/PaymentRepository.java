package com.javastackspaceit.repository;

import org.springframework.data.repository.CrudRepository;

import com.javastackspaceit.model.PaymentInfo;

public interface PaymentRepository extends CrudRepository<PaymentInfo, Integer>{


}
