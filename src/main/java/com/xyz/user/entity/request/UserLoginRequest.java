package com.xyz.user.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

/*
 * This class is used to store the user login request
 */
@NoArgsConstructor
@ApiModel("Holds the user login request")
public class UserLoginRequest {

	@ApiModelProperty(value = "Username of a user", required = true)
	private String username;

	@ApiModelProperty(value = "Password of a user", required = true)
	private String password;

	@ApiModelProperty(value = "To track the login, whether it's a user or agent", required = true)
	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
