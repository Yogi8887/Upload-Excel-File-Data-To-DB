package com.uploadexcelfile.controller;

import com.uploadexcelfile.entities.UserFiles;
import com.uploadexcelfile.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class FileResource {

    @Autowired
    private FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<UserFiles> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(fileService.getById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserFiles>> listFiles() {
        return ResponseEntity.ok(fileService.listAll());
    }

    @PreAuthorize("hasRole('ADMIN_USER')")
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        fileService.delete(id);
    }

}
