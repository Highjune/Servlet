package com.example.service;

import java.util.List;

import com.example.vo.MemberVO;
  
public interface MemberService {
	int create(MemberVO member); //int는 create된 갯수. update, delete의 리턴도 int로 마찬가지
	MemberVO select(int idx); //idx(번호)로 찾아서 들고옴
	List<MemberVO> selectAll(); // 다 들고옴
	int update(MemberVO member); // 특정인 업데이트
	int delete(int idx); //idx(번호)로 찾아서 삭제
}
  