package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Customer;
import com.example.demo.pojos.Distributor;
import com.example.demo.pojos.Login;
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

	@Query("select d from Distributor d where  login_tbl= :l")
	Optional<Distributor> finddistributor(Login l);

	
	@Query("select s from Distributor s where d_id = ?1")
	public List<Distributor> getByD_id(int d_id);
	
	

	

	@Modifying
	@Query(value="delete distributor_tbl from distributor_tbl where d_id=?1",nativeQuery=true)
	public void delete(int d_id);
	

}
