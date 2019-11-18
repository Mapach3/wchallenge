package com.gcontento.wchallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcontento.wchallenge.entities.Album;

@Repository("albumRepository")
public interface IAlbumRepository extends JpaRepository<Album,Serializable>{
	
	public Album findById(long id);
	
	public Album findByIdAlbumApi(long idAlbumApi);

}
