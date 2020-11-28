package com.bassem.boot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bassem.boot1.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	
}
