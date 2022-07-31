package com.uploadexcelfile.payloads;

import com.uploadexcelfile.entities.Book;
import com.uploadexcelfile.entities.UserFiles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
public class UserFilesDto extends UserFiles {

    private List<Book> books;

    private String uploadByName;

}
