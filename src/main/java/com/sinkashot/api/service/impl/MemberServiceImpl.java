package com.sinkashot.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinkashot.api.dao.MemberDAO;
import com.sinkashot.api.dto.Member;
import com.sinkashot.api.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<Member> selectMembers() {
//		Member member = new Member();
//		
//		member.setId("test");
//		member.setName("테스트");
//		member.setPwd("4321");
//		
//		return member;
		
		return memberDao.selectMembers();
	}
}
