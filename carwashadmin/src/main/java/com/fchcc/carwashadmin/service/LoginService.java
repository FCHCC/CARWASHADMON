package com.fchcc.carwashadmin.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fchcc.carwashadmin.dao.UsersDAO;
import com.fchcc.carwashadmin.model.Users;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	UsersDAO usersDAO;
	
	public void serUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	  
	  Users users = usersDAO.findUserInfoByUserName(userName);
	  
	  if(users==null){
	   throw new UsernameNotFoundException("Nombre de Usuario No Existe");
	  }
	  
	  List<String> roles = usersDAO.getUserRolesByUserName(userName);
	  
	  List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>(); 
	  
	  if(roles!=null){
	   for(String role : roles){
	    GrantedAuthority authority = new SimpleGrantedAuthority(role);
	    grantedAuthorityList.add(authority);
	   }
	  }
	  
	  UserDetails userDetails = new User(users.getUserName(), users.getPassword(), grantedAuthorityList);
	  
	  return userDetails;
	 }

	
}
