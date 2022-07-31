package com.uploadexcelfile.services;

import com.uploadexcelfile.entities.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    public void save(MultipartFile file);

    public List<Book> getAllBooks();
    public Book save(final Book book);
    public void saveAll(final List<Book> book);

    public List<Book> listAllByFile(final long id);
}
