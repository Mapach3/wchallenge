package com.gcontento.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.CommentModel;
import com.gcontento.wchallenge.models.PostModel;
import com.gcontento.wchallenge.models.UserModel;

@RestController
@RequestMapping("/v1")
public class CommentController {

	
	/**GET request to the external service to fetch all Comments */
	@GetMapping("/comments")
	public CommentModel[] getAllComments() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CommentModel[]> response = restTemplate.getForEntity(ConstantHelper.COMMENTS_API_URL,
				CommentModel[].class);
		CommentModel[] comments = response.getBody();
		return comments;
	}
	
	/**GET request to the external service to fetch a specific Comment */	
	@GetMapping("/comments/{id}")
	public CommentModel getCommentById(@PathVariable("id") long id) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		CommentModel comment = restTemplate.getForObject(ConstantHelper.COMMENTS_API_URL + id, CommentModel.class);
		return comment;
	}
	

	/*GET Request to the external service to get a comment based on the userId or the name of the user sent as parameter */
	@GetMapping("/commentsFiltered")
	public List<CommentModel[]> getCommentsFiltered(@PathParam("name") String name, @PathParam("userId") Long userId) {
		RestTemplate restTemplate = new RestTemplate();
		PostModel[] posts;
		List<CommentModel[]> comments = new ArrayList<CommentModel[]>();

		if (name != null) {
			UserModel user = restTemplate.getForObject(ConstantHelper.USERS_API_URL+"?name="+name.toString(), UserModel.class);
			ResponseEntity<PostModel[]> responsePosts = restTemplate
					.getForEntity(ConstantHelper.POSTS_API_URL + "?userId=" + user.getId(), PostModel[].class);
			posts = responsePosts.getBody();
			for (PostModel post : posts) {
				ResponseEntity<CommentModel[]> responseComments = restTemplate.getForEntity(
						ConstantHelper.COMMENTS_API_URL + "?postId=" + post.getId(), CommentModel[].class);
				comments.add(responseComments.getBody());
			}
			return comments;
		} else if (userId != null) {
			ResponseEntity<PostModel[]> response = restTemplate
				.getForEntity(ConstantHelper.POSTS_API_URL + "?userId=" + userId.longValue(), PostModel[].class);
			 posts = response.getBody();
			for (PostModel post : posts) {
				ResponseEntity<CommentModel[]> responseComments = restTemplate.getForEntity(
						ConstantHelper.COMMENTS_API_URL + "?postId=" + post.getId(), CommentModel[].class);
				comments.add(responseComments.getBody());
			}
			return comments;
		}
		return comments; //emtpy array in case of no name or userId given.
	}
	
	/*First implementation of commentsFiltered. Not what was asked.*/
//	@GetMapping("/commentsFiltered")
//	public List<CommentModel[]> getCommentsFilteredFirst(@PathParam("name") String name,
//			@PathParam("userId") Long userId) {
//		RestTemplate restTemplate = new RestTemplate();
//		List<CommentModel[]> comments = new ArrayList<CommentModel[]>();
//		if (name != null) {
//			ResponseEntity<CommentModel[]> response = restTemplate
//					.getForEntity(ConstantHelper.COMMENTS_API_URL + "?name=" + name, CommentModel[].class);
//			comments.add(response.getBody());
//			return comments;
//		} else {
//			if (userId != null) {
//				ResponseEntity<PostModel[]> response = restTemplate
//						.getForEntity(ConstantHelper.POSTS_API_URL + "?userId=" + userId.longValue(), PostModel[].class);
//				PostModel[] posts = response.getBody();
//				for (PostModel post : posts) {
//					ResponseEntity<CommentModel[]> responseComments = restTemplate.getForEntity(
//							ConstantHelper.COMMENTS_API_URL + "?postId=" + post.getId(), CommentModel[].class);
//					comments.add(responseComments.getBody());
//				}
//				return comments;
//			}
//
//		}
//		return comments; // Empty array in case of no name or no user given.
//	}
	

}
	
	