package com.uploadexcelfile.repository;

import com.uploadexcelfile.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> findByFileId(long id);

}
