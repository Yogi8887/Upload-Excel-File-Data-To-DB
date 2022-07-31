package com.uploadexcelfile.services;

import com.uploadexcelfile.entities.Book;
import com.uploadexcelfile.helper.FileHelper;
import com.uploadexcelfile.repository.BookRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Override
    public void save(@NotNull MultipartFile file) {
        try {
            List<Book> books = FileHelper.excelToBooks(file.getInputStream());
            this.bookRepo.saveAll(books);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() {

        return this.bookRepo.findAll();
    }

    @Override
    public Book save(final Book book) {

        return bookRepo.save(book);
    }

    @Override
    public void saveAll(final List<Book> book) {

        bookRepo.saveAll(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> listAllByFile(final long id) {
        return bookRepo.findByFileId(id);
    }

}
