package com.uploadexcelfile.controller;

import com.uploadexcelfile.entities.UserFiles;
import com.uploadexcelfile.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class FileResource {

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserFiles> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(fileService.getById(id));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<List<UserFiles>> listFiles() {
        return ResponseEntity.ok(fileService.listAll());
    }

    @PreAuthorize("hasRole('ADMIN_USER')")
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        fileService.delete(id);
    }

}
