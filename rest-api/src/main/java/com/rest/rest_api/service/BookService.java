package com.rest.rest_api.service;

import com.rest.rest_api.model.Books;
import com.rest.rest_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Books createBook(Books book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else {
            throw new RuntimeException("Book now found with id: " + id);
        }
    }
}
