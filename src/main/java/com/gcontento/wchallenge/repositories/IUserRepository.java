package com.gcontento.wchallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcontento.wchallenge.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>{
	
	public User findById(long id);
	
	public User findByIdUserApi(long idUserApi);

}
