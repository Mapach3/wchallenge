package com.gcontento.wchallenge.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gcontento.wchallenge.converters.AlbumConverter;
import com.gcontento.wchallenge.converters.UserConverter;
import com.gcontento.wchallenge.entities.Album;
import com.gcontento.wchallenge.entities.PermissionType;
import com.gcontento.wchallenge.entities.User;
import com.gcontento.wchallenge.entities.UserAlbum;
import com.gcontento.wchallenge.models.AlbumExternalModel;
import com.gcontento.wchallenge.models.UserModel;
import com.gcontento.wchallenge.repositories.IAlbumRepository;
import com.gcontento.wchallenge.repositories.IUserAlbumRepository;
import com.gcontento.wchallenge.repositories.IUserRepository;
import com.gcontento.wchallenge.services.IUserAlbumService;

@Service("userAlbumService")
public class UserAlbumService implements IUserAlbumService {

	@Autowired
	@Qualifier("userAlbumRepository")
	private IUserAlbumRepository userAlbumRepository;

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;

	@Autowired
	@Qualifier("albumRepository")
	private IAlbumRepository albumRepository;

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;

	@Autowired
	@Qualifier("albumConverter")
	private AlbumConverter albumConverter;

	@Override
	public List<UserAlbum> getAll() {
		return userAlbumRepository.findAll();
	}
	
	/*Creates an AlbumUser, which associates an User (with the exception of the owner) with a permission on the Album*/
	@Override
	public boolean insertAlbumUser(AlbumExternalModel album, UserModel user, long permissionTypeId) {

		// creating AlbumUser will only be allowed if the album isnt owned by the user AND
		// if the album isnt already shared with a specific permisison.
		if (album.getOwnerId() != user.getId() && !this.userAlbumExists(user.getId(),album.getId())) {

			User savedUser = new User();
			Album savedAlbum = new Album();

			// check if album and user have already been inserted, to avoid inserting them
			// again.
			if (!userExists(user.getId())) {
				savedUser = userRepository.save(userConverter.modelToEntity(user));
			}else {
				savedUser = userRepository.findByIdUserApi(user.getId());
			}

			if (!albumExists(album.getId())) {
				savedAlbum = albumRepository.save(albumConverter.modelToEntity(album));
			}else {
				savedAlbum = albumRepository.findByIdAlbumApi(album.getId());
			}

			UserAlbum userAlbum = new UserAlbum(savedUser, savedAlbum, PermissionType.getId(permissionTypeId));
			userAlbumRepository.save(userAlbum);
			return true;
		}
		return false;
	}
	
	/*Updates the permission for an user in a respective AlbumUser*/
	@Override
	public boolean updateUserPermission(AlbumExternalModel album, UserModel user, long permissionTypeId) {
		// AlbumUser will only be updated if it is present on database.
		if (this.userAlbumExists(user.getId(), album.getId())) {
			// If the permission type IS DIFFERENT from the one the user already has, I update the AlbumUser.
			//otherwise i dont do anything.
			UserAlbum userAlbumToUpdate = userAlbumRepository.findByUser_idUserApiAndAlbum_idAlbumApi(user.getId(), album.getId());
			if (!userAlbumToUpdate.getPermissionType().equals(PermissionType.getId(permissionTypeId)) ) {
				userAlbumToUpdate.setPermissionType(PermissionType.getId(permissionTypeId));
				userAlbumRepository.save(userAlbumToUpdate);
				return true;
			}

		}
		return false;
	}
	
	@Override
	/*Find all users that have a specific permission in an album*/
	public User[] getUsersByAlbumAndPermissionType(long albumId, long permissionTypeId) {
		PermissionType permissionType = PermissionType.getId(permissionTypeId);
		return userRepository.findByAlbumIdAndPermissionType(albumId, permissionType);
		
	}
	
	
	/*Determines if an User is already present on database, to avoid repeating registers.*/
	@Override
	public boolean userExists(long userIdApi) {
		boolean found = false;
		if (userRepository.findByIdUserApi(userIdApi) != null) {
			found = true;
		}
		return found;
	}

	/*Determines if an Album is already present on database, to avoid repeating registers.*/
	@Override
	public boolean albumExists(long albumApiId) {
		boolean found = false;
		if (albumRepository.findByIdAlbumApi(albumApiId) != null) {
			found = true;
		}
		return found;
	}

	/*Determines if there is already an album shared with an user. */
	@Override
	public boolean userAlbumExists(long userId, long albumId) {
		boolean found = false;
		if (userAlbumRepository.findByUser_idUserApiAndAlbum_idAlbumApi(userId, albumId) != null) {
			found = true;
		}
		return found;
	}

	

}
