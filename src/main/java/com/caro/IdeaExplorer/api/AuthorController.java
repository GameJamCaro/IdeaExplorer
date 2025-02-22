package com.caro.IdeaExplorer.api;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorController {

    private AuthorService authorService;

    //the api should be able to upsert and display authors  - done


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(@RequestParam(required = false) Long id) {
        return authorService.findAuthorById(id);
    }

    @PatchMapping(consumes = "application/json", produces = "application/json")
    public Author upsertAuthor(@RequestBody Author author) {
        return authorService.upsertMember(author);
    }



}
