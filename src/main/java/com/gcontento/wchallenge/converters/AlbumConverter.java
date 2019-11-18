package com.gcontento.wchallenge.converters;

import org.springframework.stereotype.Component;

import com.gcontento.wchallenge.entities.Album;
import com.gcontento.wchallenge.models.AlbumExternalModel;

@Component("albumConverter")
public class AlbumConverter {
	
//	public AlbumExternalModel entityToModel(Album album) {
//		return new AlbumExternalModel(album.getIdAlbumApi(), album.getOwnerId(), album.getTitle());
//	}
	
	public Album modelToEntity(AlbumExternalModel albumExternal) {
		return new Album(albumExternal.getOwnerId(), albumExternal.getId(), albumExternal.getTitle());
	}

}
