package com.greatlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;
import com.greatlearning.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
   
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.getUserByUsername(username);
		
		
		
		
		if(user==null)
		{
			 throw new UsernameNotFoundException("User Record Not Found");
			 
					
		}
		
		return new MyUserDetails(user);
	}

	
}