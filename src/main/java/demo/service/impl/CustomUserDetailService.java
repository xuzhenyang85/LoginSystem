package demo.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.exception.BusinessException;
import demo.model.User;
import demo.repository.UserRepository;
import demo.model.User;
import demo.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userServiceimpl;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

			User user = userServiceimpl.getUserByUsername(userName);
			if(user == null)new UsernameNotFoundException("USer not found");
			return user;
		}





	@Transactional
	public User loadUserById(Long Id){
		User user = userServiceimpl.getOne(Id);

		if(user==null)new UsernameNotFoundException("User not found");
		return user;
	}



}
