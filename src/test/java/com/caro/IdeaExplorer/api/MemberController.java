package com.caro.IdeaExplorer.api;

import com.caro.IdeaExplorer.entity.Member;
import com.caro.IdeaExplorer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MemberController {

    private MemberService memberService;

    @RequestMapping(path = "/paf")
    public String getHello() {
        return "Hello PaF controller\n";
    }


    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<Member> getMember(@RequestParam Long id)
    {
        return memberService.findMemberById(id);
    }

    @PatchMapping(path = "/upsert/json", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Member saveMember(@RequestBody Member member)
    {
        return memberService.upsertMember(member);
    }


}
