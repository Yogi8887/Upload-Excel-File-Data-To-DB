package com.uploadexcelfile.repository;

import com.uploadexcelfile.entities.UserFiles;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends PagingAndSortingRepository<UserFiles, Long> {

}
