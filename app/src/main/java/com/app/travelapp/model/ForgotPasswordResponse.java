package com.app.travelapp.model;

public class ForgotPasswordResponse{
	private String msg;
	private String password;
	private String mobile;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	@Override
 	public String toString(){
		return 
			"ForgotPasswordResponse{" + 
			"msg = '" + msg + '\'' + 
			",password = '" + password + '\'' + 
			",mobile = '" + mobile + '\'' + 
			"}";
		}
}
