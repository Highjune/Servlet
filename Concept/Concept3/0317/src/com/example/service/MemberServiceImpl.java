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
			row = dao.insertMember(member); //dao로 보냄
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row; //이것을 RegisterServlet이 받아서 그린다.
	}

	@Override
	public MemberVO select(int idx) {
		MemberVO member = null;
		try {
			member = this.dao.selectMember(idx); //dao에 idx에 던져서 해당하는 학생을 member를 받아옴.
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return member; //이것을 selectServlet이 받아서 그린다.
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		try {
			list = this.dao.selectAllMember();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return list; //이것을 ListServlet이 받아서 그린다.
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
	} // 이것을 

	@Override
	public int delete(int idx) {
		int row = -1;
		try {
			row = this.dao.deleteMember(idx);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row; //삭제한 row의 갯수
	}

}
