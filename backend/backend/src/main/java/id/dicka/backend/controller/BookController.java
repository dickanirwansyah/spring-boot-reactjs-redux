package id.dicka.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.dicka.backend.entity.Book;
import id.dicka.backend.repo.BookRepository;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(value = "/books")
	public List<Book> getAllBooks(){
		List<Book> list = new ArrayList<>();
		Iterable<Book> books = bookRepository.findAll();
		books.forEach(list::add);
		return list;
	}
	
	@PostMapping(value = "/books/create")
	public Book createBook(@RequestBody @Valid Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping(value = "/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")long id){
		Optional<Book> bookId = bookRepository.findById(id);
		if(bookId.isPresent()) {
			return new ResponseEntity<Book>(bookId.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id")long id,
			@RequestBody Book requestBody){
		Optional<Book> bookData = bookRepository.findById(id);
		if (!bookData.isPresent()) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}else {
			Book savedBook = bookData.get();
			savedBook.setTitle(requestBody.getTitle());
			savedBook.setAuthor(requestBody.getAuthor());
			savedBook.setDescription(requestBody.getDescription());
			savedBook.setPublished(requestBody.getPublished());
			Book updateBook = bookRepository.save(savedBook);
			return new ResponseEntity<Book>(updateBook, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id")long id){
		try {
			bookRepository.deleteById(id);
		}catch (Exception e) {
			return new ResponseEntity<>("fail to delete !", HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<String>("Book has been delete !", HttpStatus.OK);
	}
}
