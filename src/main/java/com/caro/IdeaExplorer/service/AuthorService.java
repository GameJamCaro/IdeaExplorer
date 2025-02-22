package com.caro.IdeaExplorer.service;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class AuthorService {



    private List<Author> authorList;


    private AuthorRepo authorRepo;

    public AuthorService(){
        authorList = new ArrayList<>();

        Author author1 = new Author(1L, "Djuna");
        Author author2 = new Author(2L, "Leopold");

        authorList.addAll(Arrays.asList(author1, author2));
    }





    @Autowired // Constructor injection
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }
    public List<Author> findAuthorById(Long idFilter) {
        //List<Author> authorList = new ArrayList<>();
        for (Author author : authorList)
        {
        if (idFilter == null) {
            authorRepo.findAll().forEach(authorList::add);
        } else {
            authorRepo.findById(idFilter).ifPresent(authorList::add);
        }
        }
        return authorList;
    }

    public Author upsertMember(Author author) {
        Author savedAuthor = authorRepo.save(author);
        if (savedAuthor == null) {
            throw new RuntimeException("Member could not be saved");
        }
        return savedAuthor;
    }




}
