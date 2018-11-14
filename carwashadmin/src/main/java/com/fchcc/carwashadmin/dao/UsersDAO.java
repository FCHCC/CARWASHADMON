package com.fchcc.carwashadmin.dao;

import java.util.List;

import com.fchcc.carwashadmin.model.Users;

public interface UsersDAO {

	 public Users findUserInfoByUserName(String userName);
	 
	 public List<String> getUserRolesByUserName(String userName);
}

