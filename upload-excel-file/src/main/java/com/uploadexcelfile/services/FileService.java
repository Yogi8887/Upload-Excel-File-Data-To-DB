package com.uploadexcelfile.services;

import com.uploadexcelfile.entities.UserFiles;
import com.uploadexcelfile.exceptions.FileUploadException;
import com.uploadexcelfile.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService{

    private FileRepository fileRepository;

    @Transactional
    public UserFiles save(final UserFiles files) {
        return fileRepository.save(files);
    }

    @Transactional(readOnly = true)
    public List<UserFiles> listAll() {
        return (List<UserFiles>) fileRepository.findAll();
    }

    @Transactional
    public void delete(long id) {
        UserFiles userFiles = getById(id);
        userFiles.setDeleted(Boolean.TRUE);
        userFiles.setUpdatedDate(LocalDateTime.now());
        save(userFiles);
    }

    @Transactional(readOnly = true)
    public UserFiles getById(Long id) {
        return fileRepository
                .findById(id)
                .orElseThrow(() -> new FileUploadException(HttpStatus.NOT_FOUND.value(), "File details not found."));
    }

}
