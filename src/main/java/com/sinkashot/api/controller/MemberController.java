package com.sinkashot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinkashot.api.dto.Member;
import com.sinkashot.api.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping(path = "/members")
	public List<Member> selectMembers() {
		return memberService.selectMembers();
	}
	
	@GetMapping(path = "/members/{number}")
	public Member findByMemberWithNumber(@PathVariable int number) {
		return memberService.findByMemberWithNumber(number);
	}
}
