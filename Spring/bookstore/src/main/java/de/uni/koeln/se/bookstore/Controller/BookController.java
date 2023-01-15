package de.uni.koeln.se.bookstore.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import de.uni.koeln.se.bookstore.repository.BookRepo;
import de.uni.koeln.se.bookstore.datamodel.*;

import de.uni.koeln.se.bookstore.service.BookService;

@RequestMapping("/bookStore")
@RestController
public class BookController {
    

    @Autowired
    BookService bookSer;

    @GetMapping
    public ResponseEntity<List<Book>> getAllbooks() {

        List<Book> books = new ArrayList<Book>();
        books = bookSer.findBooks();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("byid/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        return new ResponseEntity<>(bookSer.fetchBook(id).get(), HttpStatus.OK);
    }

    @GetMapping("year/oldest")
    public ResponseEntity<Book> getOldestBook(){
		return new ResponseEntity<>(bookSer.getOldest(), HttpStatus.OK);


    }

    @GetMapping("year/latest")
    public ResponseEntity<Book> getLatestBook(){
		return new ResponseEntity<>(bookSer.getLatest(), HttpStatus.OK);


    }
     @PostMapping
     public ResponseEntity<Book> addBookt(@RequestBody Book book) {

        bookSer.addBook(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
     }

     @DeleteMapping("byid/{id}")
     public ResponseEntity<Book> removeBookById(@PathVariable int id){

        Book book = bookSer.fetchBook(id).get();

        if(bookSer.deleteBook(id)){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
        }
     }
}
