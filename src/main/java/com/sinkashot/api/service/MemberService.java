package com.sinkashot.api.service;

import java.util.List;

import com.sinkashot.api.dto.Member;

public interface MemberService {
	List<Member> selectMembers();
}
