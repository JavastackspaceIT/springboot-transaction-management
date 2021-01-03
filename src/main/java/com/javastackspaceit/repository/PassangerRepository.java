package com.javastackspaceit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javastackspaceit.model.PassangerInfo;
import com.javastackspaceit.model.PaymentInfo;

public interface PassangerRepository extends CrudRepository<PassangerInfo, Integer> {

	@Query(value="select passangerInfo.firstName,passangerInfo.lastName,passangerInfo.mobileNo,passangerInfo.emaliId,js.accountName,js.amount,js.bankName from PaymentInfo js inner join js.passangerInfo passangerInfo group by passangerInfo.id")
	List<Object[]> listOfPassangerInf();
	
	
	@Query(value="select passangerInfo.firstName,passangerInfo.lastName,passangerInfo.mobileNo,passangerInfo.emaliId,js.accountName,js.amount,js.bankName from PaymentInfo js inner join js.passangerInfo passangerInfo  where passangerInfo.emaliId=:emaliId")
	List<Object[]> findPassangerByEmailId(@Param("emaliId")String emaliId);
	
}