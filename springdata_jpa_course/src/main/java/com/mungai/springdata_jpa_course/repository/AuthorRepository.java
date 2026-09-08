package com.mungai.springdata_jpa_course.repository;

import com.mungai.springdata_jpa_course.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {


    // NamedQueries
    List<Author> findByNamedQuery(@Param("age") int age);




    // update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);


    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    List<Author> findAllByFirstName(String firstName);
    // This will find the list of authors by firstname



    List<Author> findAllByFirstNameIgnoreCase(String firstName);
    /* This will find the list of authors by firstname, and it will ignore the cases i.e., whether authors' firstnames are saved
    in either uppercase or lowercase, it will still find them. It doesn't care the case. */



    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);
    /* Here, containing means if you type letter 'a' it will give you a list of authors that their firstnames have letter 'a'
    it's like when you search for things in a browser, you get a list of words containing the letter you've typed even if you haven't completed typing
    NOTE: --> Here, the position of the typed letter does not matter as long as the name contains that letter*/



    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);
    /*Here, we are searching for the list of the authors that their firstName starts with the letter typed.
    NOTE: --> Here, the position of the typed letter matters*/



    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);
    /*Here, we are searching for the list of the authors that their firstName ends with the letter typed.
    NOTE: --> Here, the position of the typed letter matters*/
}
