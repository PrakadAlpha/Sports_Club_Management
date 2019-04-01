package com.sport2.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;
	
	@Size(min = 3, message = "Enter a valid name..!")
	@NotNull(message="Cannot be Null..!")
	private String fullname;

	@Size(min = 10, message = "Enter a valid Mobile Number..!")
	@NotNull(message="Cannot be Null..!")
	private String mobile;
	
	@Email(message="Enter Valid Email..!")
	@NotNull(message="Cannot be Null..!")
	private String email;
	
	@Size(min = 3, message = "Enter a valid Address..!")
	@NotNull(message="Cannot be Null..!")
	private String address;
	
	private Integer role = 2;
	
	@Size(min = 5, message = "Enter a valid Username..!")
	@NotNull(message="Cannot be Null..!")
	private String username;
	
	@Size(min = 5, message = "Enter a valid Password..!")
	@NotNull(message="Cannot be Null..!")
	private String password;
	
	public Users() {
		super();
	}
	
	
	public Users(Integer id, String fullname, String mobile, String email, String address, Integer role, String username,
			String password) {
		super();
		this.userid = id;
		this.fullname = fullname;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	
	public Integer getId() {
		return userid;
	}
	public void setId(Integer userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Users [id=" + userid + ", fullname=" + fullname + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", role=" + role + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
