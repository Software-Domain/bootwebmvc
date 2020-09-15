package com.ray.bootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ray.bootweb.bean.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByUseridAndPassword(String userid, String password);
}
