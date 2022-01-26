package com.sinkashot.api.service.impl;

import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinkashot.api.dao.MemberDAO;
import com.sinkashot.api.dto.Member;
import com.sinkashot.api.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberDAO memberDao;

	public MemberServiceImpl(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<Member> selectMembers() {
		return memberDao.selectMembers();
	}
	
	@Override
	public Member findByMemberWithNumber(int number) {
		return memberDao.findByMemberWithNumber(number);
	}
	
	@Override
	public Member findByMemberForAuth(HashMap<String,String> auth) {
		return memberDao.findByMemberForAuth(auth);
	}
}
