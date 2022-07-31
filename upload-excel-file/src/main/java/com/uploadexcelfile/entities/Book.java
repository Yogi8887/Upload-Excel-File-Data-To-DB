package com.uploadexcelfile.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean deleted = Boolean.FALSE;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updatedDate = LocalDateTime.now();

    private String name;
    private String authorName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "file_id")
    @NotNull
    private UserFiles file;

}
