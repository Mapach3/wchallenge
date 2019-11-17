package com.gcontento.wchallenge.controllers;

import javax.websocket.server.PathParam;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.CommentModel;
import com.gcontento.wchallenge.models.PostModel;

@RestController
@RequestMapping("/v1")
public class CommentController {

	@GetMapping("/comments")
	public CommentModel[] getAllComments() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CommentModel[]> response = restTemplate.getForEntity(ConstantHelper.COMMENTS_API_URL,
				CommentModel[].class);
		CommentModel[] comments = response.getBody();
		return comments;
	}

	@GetMapping("/comments/{id}")
	public CommentModel getCommentById(@PathVariable("id") long id) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		CommentModel comment = restTemplate.getForObject(ConstantHelper.COMMENTS_API_URL + id, CommentModel.class);
		return comment;
	}
	
	@GetMapping("/commentsFiltered")
	public CommentModel[] getCommentsFiltered(@PathParam("name") String name, @PathParam("userId") long userId) {
		RestTemplate restTemplate = new RestTemplate();
		CommentModel[] comments = {};
		if (name != null) {
			ResponseEntity<CommentModel[]> response = restTemplate
					.getForEntity(ConstantHelper.COMMENTS_API_URL + "?name=" + name, CommentModel[].class);
			comments = response.getBody();
			return comments;
//		} else {
//			ResponseEntity<PostModel[]> response = restTemplate
//					.getForEntity(ConstantHelper.POSTS_API_URL + "?userId=" + userId, PostModel[].class);
//			PostModel[] posts = response.getBody();
//			for (PostModel post : posts) {				
//			}
		}
		return comments; //Empty array in case of no name or no user given.
	}


}
