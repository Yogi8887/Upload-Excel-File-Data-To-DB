package com.uploadexcelfile.controller;

import com.uploadexcelfile.entities.UserFiles;
import com.uploadexcelfile.exceptions.FileUploadException;
import com.uploadexcelfile.payloads.UserFilesDto;
import com.uploadexcelfile.services.FileUploadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class FileUploadResource {
    @Autowired
    private FileUploadService fileUploadService;

   @PreAuthorize("hasRole('ADMIN_USER')")
    @RequestMapping(method = RequestMethod.POST, path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserFiles> uploadFiles(@RequestPart("file") MultipartFile file) throws IOException {
        if (file != null) {
            return ResponseEntity.ok(fileUploadService.readFile(file.getInputStream(), file.getOriginalFilename()));
        }
        throw new FileUploadException(HttpStatus.NOT_FOUND.value(), "File not found.");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/record/{id}")
    public ResponseEntity<UserFilesDto> uploadFiles(@PathVariable("id") long id) {
        return ResponseEntity.ok(fileUploadService.listRecords(id));
    }

}
