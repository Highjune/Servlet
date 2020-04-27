package com.example.dao;  

import java.sql.SQLException;
import java.util.List;

import com.example.vo.MemberVO;

public interface MemberDao {
	int insertMember(MemberVO member) throws SQLException;
	MemberVO selectMember(int idx) throws SQLException;
	List<MemberVO> selectAllMember() throws SQLException;
	int updateMember(MemberVO member) throws SQLException;
	int deleteMember(int idx) throws SQLException;
}
