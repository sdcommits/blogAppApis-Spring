package com.codePro.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

//@Data
//@Getter
//@Setter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 2, message = " username should have atleast 2 characters")
	private String name;
	
	@Email(message = "user email should have be valid")
	private String email;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	@Size(min = 3 , max = 10, message = "User should fill password in between 3-10 characters")
	private String password;
 	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(int id, String name, String email, String about, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.about = about;
		this.password = password;
	}
	public UserDto() {
		super();
	}
	
	

}
