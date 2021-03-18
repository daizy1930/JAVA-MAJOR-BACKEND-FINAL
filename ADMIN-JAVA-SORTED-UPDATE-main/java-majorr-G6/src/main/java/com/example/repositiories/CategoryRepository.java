package com.example.repositiories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.entity.Course;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Category findByCategoryName(String name);

	public Object save(Optional<Category> cati);

	

	

}
