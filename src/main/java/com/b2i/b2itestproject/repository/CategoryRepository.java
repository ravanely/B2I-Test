package com.b2i.b2itestproject.repository;


import com.b2i.b2itestproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
