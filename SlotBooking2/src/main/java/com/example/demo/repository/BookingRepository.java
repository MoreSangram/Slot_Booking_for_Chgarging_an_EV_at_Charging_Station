package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojos.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Modifying
	@Query(value="delete book_tbl from book_tbl where cid=?1",nativeQuery=true)
	public void delete(int cid);

}
