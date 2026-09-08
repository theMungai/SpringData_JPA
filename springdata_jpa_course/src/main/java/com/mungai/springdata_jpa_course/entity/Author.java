package com.mungai.springdata_jpa_course.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @Column( updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true, insertable = false)
    private LocalDateTime lastModified;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
