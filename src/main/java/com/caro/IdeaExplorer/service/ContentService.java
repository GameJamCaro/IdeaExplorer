package com.caro.IdeaExplorer.service;
import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.entity.ContentType;
import com.caro.IdeaExplorer.repo.ContentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepo contentRepo;

    private List<Content> contentList;


    public ContentService(ContentRepo contentRepo) {
        this.contentRepo = contentRepo;
        addContents();
    }




    public Content createContent(Content content) {
        return contentRepo.save(content);
    }



    public void deleteContent(Integer id) {
        contentRepo.deleteById(id);
    }

    public List<Content> getAllContents() {
        for (Content content : contentList) {
            contentRepo.findAll();
        }
        return contentList;
    }

    public void addContents(){
        contentList = new ArrayList<>();

        Content message = new Content(1, "This is the first idea", new Author(1L, "Author 1"), ContentType.MESSAGE);
        Content prompt = new Content(2, "This is the second idea", new Author(2L, "Author 2"), ContentType.PROMPT);
        Content message1 = new Content(3, "This is the third idea", new Author(3L, "Author 3"), ContentType.MESSAGE);

        contentList.addAll(Arrays.asList(message, prompt, message1));
    }
}
