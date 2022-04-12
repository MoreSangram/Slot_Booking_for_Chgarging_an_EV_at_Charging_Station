
package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Login;
@Repository
@Transactional
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	@Query("select  l from Login l where user= :user and password= :password")
	public List<Login>checkLogin(String user,String password);
	
	@Modifying 
	@Query(value="update login_tbl set password = ?1 where user = ?2",nativeQuery = true)
	public void forgetPassword(String password,String user);

	
	/*@Query("select l.role,l.login_id from Login l where user=:user and password=:password")
	public List<Object[]>checkLogin(String user,String password);
*/
}

