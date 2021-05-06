package com.sinkashot.api.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinkashot.api.dto.Member;
import com.sinkashot.api.service.MemberService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberController {
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(path = "/members")
	public List<Member> selectMembers() {
		return memberService.selectMembers();
	}
	
	@GetMapping(path = "/members/{number}")
	public Member findByMemberWithNumber(@PathVariable int number) {
		Member member = memberService.findByMemberWithNumber(number);
		System.out.println("findByMemberWithNumber : "+member.getName());
		return member;
	}
	
	@PostMapping(path = "/auth")
	public HashMap<String, Object> findByMemberForAuth(@RequestBody HashMap<String,String> auth) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Member member = memberService.findByMemberForAuth(auth);
		
		if (member != null) {
			log.info(member.toString());
			result.put("result", true);
			result.put("data", member);
		} else {
			result.put("result", false);
			result.put("data", null);
		}
		
		return result;
	}
}
