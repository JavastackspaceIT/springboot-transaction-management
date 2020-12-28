package com.javastackspaceit.repository;

import org.springframework.data.repository.CrudRepository;

import com.javastackspaceit.model.PassangerInfo;

public interface PassangerRepository extends CrudRepository<PassangerInfo, Integer> {

}
