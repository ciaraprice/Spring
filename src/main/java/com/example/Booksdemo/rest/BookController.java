package com.example.Booksdemo.rest;

import com.example.Booksdemo.domain.Book;
import com.example.Booksdemo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book b) {
        return new ResponseEntity<>(this.service.createBook(b), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        System.out.println("ID: " + id);

        Book found = this.service.getBook(id);
        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/getAll")
    public List<Book> getBooks() {
        return this.service.getAll();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updateBooks(
            @PathVariable int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "ISBN", required = false) Integer ISBN,
            @RequestParam(name = "author", required = false) String author
    ) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("ISBN: " + ISBN);
        System.out.println("AUTHOR: " + author);

        Book updated = this.service.updateBook(id, name, ISBN, author);
        if (updated == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeBook(@PathVariable Integer id) {
        String result = this.service.removeBook(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }

}
