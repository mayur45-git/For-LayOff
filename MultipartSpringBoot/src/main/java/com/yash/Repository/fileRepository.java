package com.yash.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.yash.model.User;

@EnableJpaRepositories
public interface fileRepository extends JpaRepository<User, Integer> {

}
