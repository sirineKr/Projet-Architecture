package com.architecture.logicielle.service;

import com.architecture.logicielle.mvc.data.UserView;
import com.architecture.logicielle.repository.entities.UserEntity;

public class UserServiceImpl implements UserService {

	@Override
	public UserEntity parseUser(UserView userview) {
		UserEntity userEnt = new UserEntity();
		userEnt.setFirstName(userview.getFirstName());
		userEnt.setLastName(userview.getLastName());
		userEnt.setId(userview.getId());
		userEnt.setMail(userview.getMail());
		userEnt.setPassword(userview.getPassword());
		userEnt.setPhoto(userview.getPhoto());
		userEnt.setStatut(userview.getStatut());

		return userEnt;
	}


}
