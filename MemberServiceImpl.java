package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.MemberDao;
import com.example.dao.MemberDaoImpl;
import com.example.vo.MemberVO;
  
public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao;
	
	public MemberServiceImpl() { //기본생성자
		dao = new MemberDaoImpl(); //자식은 부모형으로 형변환
	}
	
	@Override
	public int create(MemberVO member) {
		int row = -1;
		try {
			row = dao.insertMember(member);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}

	@Override
	public MemberVO select(int idx) {
		MemberVO member = null;
		try {
			member = this.dao.selectMember(idx);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return member;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		try {
			list = this.dao.selectAllMember();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return list;
	}

	@Override
	public int update(MemberVO member) {
		int row = -1;
		try {
			row = this.dao.updateMember(member);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}

	@Override
	public int delete(int idx) {
		int row = -1;
		try {
			row = this.dao.deleteMember(idx);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}

}
