package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library.entitys.Books;
import com.example.library.entitys.Student;
import com.example.library.exceptions.BookIssueNotFound;
import com.example.library.repository.BookRepository;

@Service
public class BookService 
{

	@Autowired
	private BookRepository bookrepo;
	
	public ResponseEntity<List<Books>> getAllbooks()
	{
		try
		{
		List<Books> list=(List<Books>)this.bookrepo.findAll();
		return ResponseEntity.ok(list) ;
		}
		catch (Exception e)
		{
			throw new BookIssueNotFound();
		}
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<BookRepository> getById(int bid)
	{
		Books book=null;
		try {
			book=this.bookrepo.findById(bid).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + bid));
;
			return ResponseEntity.ok(bookrepo);
		}
		catch(Exception e)
		{
			throw new BookIssueNotFound();
		}
	}
	public Books addBook(Books b)
	{
		try {
		Books result=this.bookrepo.save(b);
		return result;
		}
		finally
		{}
	}
	
	public void deleteBook(int id)
	{
		this.bookrepo.deleteById(id);
	}
	public void updateBook(Books stud, int bid)
	{
		Books existingBook = bookrepo.findById(bid).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + bid));
		existingBook.setBname(stud.getBname());
		existingBook.setAuthor(stud.getAuthor());
		bookrepo.save(existingBook);
	}
}

