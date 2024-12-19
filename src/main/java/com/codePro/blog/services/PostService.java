package com.codePro.blog.services;

import java.util.List;

import com.codePro.blog.entities.Post;
import com.codePro.blog.payloads.PostDto;

public interface PostService {
	
	//create
	
	Post createPost(PostDto postDto);
	
	//update
	
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all post
	
	List<Post> getAllPost();
	
	//get single post
	
	Post getPostById(Integer postId);
	
	//get all post by category
	
	List<Post> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	
	List<Post> getPostsByUser(Integer userId);
	
	//search posts
	
	List<Post> searchPosts(String keyword);
	
	
	
}
