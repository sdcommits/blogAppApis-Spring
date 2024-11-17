package com.codePro.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.codePro.blog.entities.User;
import com.codePro.blog.exceptions.ResourceNotFoundException;
import com.codePro.blog.payloads.UserDto;
import com.codePro.blog.repositories.UserRepo;
import com.codePro.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	} 

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=  this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updateduser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateduser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deletUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	//-----------------------making class object from another class by normal method
	
//	private User dtoToUser(UserDto userDto) { 
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return user;	
//	}
	
	//---------------------making class object from another class by modelmapper 
	
	private User dtoToUser(UserDto userDto) { 
		User user = this.modelMapper.map(userDto, User.class);
		return user;	
	}
	
//	public UserDto userToDto(User user) {
//		UserDto userDto=new UserDto();  
//		userDto.setId(user.getId());
//		userDto.setEmail(user.getName());
//		userDto.setPassword(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
//		return userDto;	
//		
//	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
		
	}

	

}
