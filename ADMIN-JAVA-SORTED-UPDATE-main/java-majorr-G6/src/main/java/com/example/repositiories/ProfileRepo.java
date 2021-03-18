package com.example.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Profile;
import com.example.entity.User;

public interface ProfileRepo extends JpaRepository<Profile, Integer>{

	public Profile findByUser(User u);
}
