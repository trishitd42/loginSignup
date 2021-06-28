package com.wipro.mongoController.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.mongoController.dao.UsersDao;
import com.wipro.mongoController.model.Users;
@Service
public class myUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = dao.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User do not exist, create a new one");
		}
		return new usersDetailsPrinciple(user);
	}

}
