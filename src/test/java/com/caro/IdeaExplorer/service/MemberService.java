package com.caro.IdeaExplorer.service;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class MemberService {



    private List<Author> authorList;


    private MemberRepo memberRepo;

    public MemberService(){
        authorList = new ArrayList<>();

        Author author1 = new Author(1L, "Djuna");
        Author author2 = new Author(2L, "Leopold");

        authorList.addAll(Arrays.asList(author1, author2));
    }





    @Autowired // Constructor injection
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }
    public List<Author> findMemberById(Long idFilter) {
        //List<Member> memberList = new ArrayList<>();
        for (Author author : authorList)
        {
        if (idFilter == null) {
            memberRepo.findAll().forEach(authorList::add);
        } else {
            memberRepo.findById(idFilter).ifPresent(authorList::add);
        }
        }
        return authorList;
    }

    public Author upsertMember(Author author) {
        Author savedAuthor = memberRepo.save(author);
        if (savedAuthor == null) {
            throw new RuntimeException("Member could not be saved");
        }
        return savedAuthor;
    }




}
