package com.write.services;

import com.write.models.Role;
import com.write.models.RoleRepository;
import com.write.models.User;
import com.write.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
//	private UserRepository userRepository;

//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Qualifier("userRepository")
	@Autowired
	private UserRepository userRepository;

	@Qualifier("roleRepository")
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Override
//	public User getUserById(Integer id) {
//		return userRepository.findOne(id);
//	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

//	@Override
//	public void deleteUser(Integer id) {
//		userRepository.delete(id);
//	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
