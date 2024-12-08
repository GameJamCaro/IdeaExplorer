package com.caro.IdeaExplorer.service;

import com.caro.IdeaExplorer.entity.Member;
import com.caro.IdeaExplorer.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class MemberService {

    private final MemberRepo memberRepo;

    @Autowired // Constructor injection
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> findMemberById(Long idFilter){
        List<Member> memberList = new ArrayList<>();
        if (idFilter == null) {
            memberRepo.findAll().forEach(memberList::add);
        } else {
            memberRepo.findById(idFilter).ifPresent(memberList::add);
        }
        return memberList;
    }

    public Member upsertMember(final Member member) {
        Member savedMember = memberRepo.save(member);
        if (savedMember == null) {
            throw new RuntimeException("Member could not be saved");
        }
        return savedMember;
    }




}
