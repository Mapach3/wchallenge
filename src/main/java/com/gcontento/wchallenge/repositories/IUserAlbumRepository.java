package com.gcontento.wchallenge.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcontento.wchallenge.entities.PermissionType;
import com.gcontento.wchallenge.entities.UserAlbum;

@Repository("userAlbumRepository")
public interface IUserAlbumRepository extends JpaRepository<UserAlbum, Serializable>{
	
	public UserAlbum findById(long id);
	
	public UserAlbum findByUser_idUserApiAndAlbum_idAlbumApiAndPermissionType(long idUserApi, long idAlbumApi, PermissionType permissionType);
	
	public List<UserAlbum> findAll();
	
	
	
	

}
