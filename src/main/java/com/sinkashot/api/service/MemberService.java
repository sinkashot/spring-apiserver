package com.sinkashot.api.service;

import java.util.HashMap;
import java.util.List;

import com.sinkashot.api.dto.Member;

public interface MemberService {
	List<Member> selectMembers();
	Member findByMemberWithNumber(int number);
	Member findByMemberForAuth(HashMap<String,String> auth);
}
