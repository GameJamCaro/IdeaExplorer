package com.caro.IdeaExplorer.api;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.service.AuthorService;
import com.caro.IdeaExplorer.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ThreadController {

    private AuthorService authorService;
    private ContentService contentService;

    //the api should be able to upsert and display authors  - done


    @Autowired
    public ThreadController(AuthorService authorService, ContentService contentService) {
        this.authorService = authorService;
        this.contentService = contentService;
    }

    @GetMapping("/contents")
    public List<Content> getContents(@RequestParam(required = false) Integer id) {

        //contentService.addContents();
        return contentService.getAllContents();
    }

   /* //add function to add author to thread
    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
       return authorService.addAuthor(author);
    }*/


    @GetMapping("/authors")
    public List<Author> getAuthors(@RequestParam(required = false) Integer id) {
        authorService.addAuthors();
        return authorService.findAuthorById(id);
    }
/*
    @PatchMapping(consumes = "application/json", produces = "application/json")
    public Author upsertAuthor(@RequestBody Author author) {
        return authorService.upsertAuthor(author);
    }
*/


}
