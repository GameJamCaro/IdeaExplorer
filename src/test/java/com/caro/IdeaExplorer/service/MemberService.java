package com.caro.IdeaExplorer.service;

import com.caro.IdeaExplorer.entity.Member;
import com.caro.IdeaExplorer.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class MemberService {



    private List<Member> memberList;


    private MemberRepo memberRepo;

    public MemberService(){
        memberList = new ArrayList<>();

        Member member1 = new Member(1L, "Djuna");
        Member member2 = new Member(2L, "Leopold");

        memberList.addAll(Arrays.asList(member1, member2));
    }





    @Autowired // Constructor injection
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }
    public List<Member> findMemberById(Long idFilter) {
        //List<Member> memberList = new ArrayList<>();
        for (Member member:  memberList)
        {
        if (idFilter == null) {
            memberRepo.findAll().forEach(memberList::add);
        } else {
            memberRepo.findById(idFilter).ifPresent(memberList::add);
        }
        }
        return memberList;
    }

    public Member upsertMember(Member member) {
        Member savedMember = memberRepo.save(member);
        if (savedMember == null) {
            throw new RuntimeException("Member could not be saved");
        }
        return savedMember;
    }




}
