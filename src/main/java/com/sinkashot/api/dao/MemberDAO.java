package com.sinkashot.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinkashot.api.dto.Member;

@Repository
public interface MemberDAO {
	List<Member> selectMembers();
	Member findByMemberWithNumber(int number);
}
