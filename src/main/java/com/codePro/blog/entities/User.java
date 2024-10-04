package com.codePro.blog.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//import org.hibernate.annotations.Table;

//import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column(name="user_name",nullable = false, length = 1)
	private String name;
	
	private String email;
	
	private String about;
	
	private String password;
	
	
	

}
