package com.gcontento.wchallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcontento.wchallenge.entities.PermissionType;
import com.gcontento.wchallenge.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>{
	
	public User findById(long id);
	
	public User findByIdUserApi(long idUserApi);
	
	/*tfl gus pagina 69 and https://spring.io/guides/gs/accessing-data-jpa/*/
	@Query("SELECT ua.user from UserAlbum ua where ua.album.id = (:albumId) AND ua.permissionType = (:permissionType)")
	public User[] findByAlbumIdAndPermissionType(@Param("albumId") long albumId, @Param("permissionType") PermissionType permissionType);
	

}
