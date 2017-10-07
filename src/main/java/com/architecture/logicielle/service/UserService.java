package com.architecture.logicielle.service;

import com.architecture.logicielle.mvc.data.UserView;
import com.architecture.logicielle.repository.UserRepository;
import com.architecture.logicielle.repository.entities.UserEntity;

public interface UserService {
	
	public UserEntity parseUser(UserView userview);  
	public void saveUser(UserEntity userEntity, UserRepository userRepository);
}
