package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entitys.IssuedBooks;
import com.example.library.repository.IssuedRepository;

@Service
public class IssuedBookService
{
	 private final IssuedRepository issuedBookRepository;

	    @Autowired
	    public IssuedBookService(IssuedRepository issuedBookRepository) {
	        this.issuedBookRepository = issuedBookRepository;
	    }

	    public List<IssuedBooks> getAllIssuedBooks() {
	        return issuedBookRepository.findAll();
	    }

	    public IssuedBooks getIssuedBookById(int id) {
	        return issuedBookRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("IssuedBook not found with id: " + id));
	    }

	    public IssuedBooks saveIssuedBook(IssuedBooks issuedBook) {
	        return issuedBookRepository.save(issuedBook);
	    }

	    public void deleteIssuedBook(int id) {
	        issuedBookRepository.deleteById(id);
	    }

	    // Additional methods as per your requirements

	    // ...
	}


