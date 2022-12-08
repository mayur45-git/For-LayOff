package com.yash.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.Repository.fileRepository;
import com.yash.model.User;

@Service
public class fileServices {

	@Autowired
	private fileRepository repository;

	public void uploadfile(User user) {
		repository.save(user);

	}

	public List<User> findallUser() {

		return repository.findAll();

	}

}
