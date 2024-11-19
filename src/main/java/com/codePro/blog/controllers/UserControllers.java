package com.codePro.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codePro.blog.payloads.ApiResponse;
import com.codePro.blog.payloads.UserDto;
import com.codePro.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserControllers {
	
	//we have created methods to handle the user apis
	@Autowired
	private UserService userServices;
	
	//POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userServices.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	} 
	//PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
		UserDto updatedUser = this.userServices.updateUser(userDto, uid);		return ResponseEntity.ok(updatedUser);
}
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userServices.deletUser(uid);
		return new ResponseEntity(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
}
	//-----------------------Both correct-------------------------
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
//		this.userServices.deletUser(uid);
//		return new ResponseEntity(new ApiResponse("User Deleted Successfully",false), HttpStatus.OK);
//}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userServices.getAllUsers());
	}
//---------------------------------Both Correct-------------------
//	@GetMapping("/getAllUser")
//	public ResponseEntity<List<UserDto>> getAllUsers(){
//		List<UserDto> updatedUser = this.userServices.getAllUsers();
//		return ResponseEntity.ok(updatedUser);
//	}
	
	@GetMapping("/getById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer uid){
		UserDto updatedUser = this.userServices.getUserById(uid);
		return ResponseEntity.ok(updatedUser);
	}
}
