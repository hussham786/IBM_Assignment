package com.ibm.training.bean;

public class User {
	int userId, phoneNumber, branchId;
	String userName, userAddress;
	
	public User(int userId, int phoneNumber, int branchId, String userName, String userAddress) {
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.branchId = branchId;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	public User() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
