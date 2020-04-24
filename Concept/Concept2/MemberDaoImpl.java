package com.example.dao;  

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int insertMember(MemberVO member) throws SQLException {
		Connection conn = DBConnection.getConnection(); //1,2,3
		String sql = "INSERT INTO Member(idx, name, gender, age, city, regdate) " +
						  "VALUES(Member_seq.NEXTVAL,?,?,?,?, SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);  //4.
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getGender());
		pstmt.setInt(3, member.getAge());
		pstmt.setString(4, member.getCity());
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //6
		return row;
	}

	@Override
	public MemberVO selectMember(int idx) throws SQLException {
		Connection conn = DBConnection.getConnection();   //1,2,3
		String sql = "SELECT idx, name, gender, age, city, regdate FROM Member " +
		                   "WHERE idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);  //4
		pstmt.setInt(1, idx);
		ResultSet rs = pstmt.executeQuery();   //5
		rs.next();  //6
		MemberVO member = new MemberVO(rs.getInt("idx"), rs.getString("name"),
				                                                    rs.getString("gender"), rs.getInt("age"),
				                                                    rs.getString("city"), rs.getDate("regdate"));
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //7
		return member;
	}

	@Override
	public List<MemberVO> selectAllMember() throws SQLException{
		Connection conn = DBConnection.getConnection();   //1,2,3
		Statement stmt = conn.createStatement(); //4
		String sql = "SELECT idx, name, gender, age, city, regdate FROM Member " +
		                   "ORDER BY idx DESC";
		ResultSet rs = stmt.executeQuery(sql);   //5
		List<MemberVO> list = new ArrayList<MemberVO>();
		while(rs.next()) {  //6
			int idx = rs.getInt(1);
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			int age = rs.getInt("age");
			String city = rs.getString("city");
			Date regdate = rs.getDate("regdate");
			MemberVO member = new MemberVO(idx, name, gender, age, city, regdate);
			list.add(member);
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		DBClose.close(conn);  //7
		return list;
	}

	@Override
	public int updateMember(MemberVO member)  throws SQLException {
		Connection conn = DBConnection.getConnection();   //1,2,3
		String sql = "UPDATE Member SET gender = ?, age = ?, city = ? " +
		                  "WHERE idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);  //4
		pstmt.setString(1, member.getGender());
		pstmt.setInt(2, member.getAge());
		pstmt.setString(3, member.getCity());
		pstmt.setInt(4, member.getIdx());
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //6
		return row;
	}

	@Override
	public int deleteMember(int idx) throws SQLException{
		Connection conn = DBConnection.getConnection();   //1,2,3
		String sql = "DELETE FROM Member WHERE idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);  //4
		pstmt.setInt(1, idx);
		int row = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		DBClose.close(conn);  //6
		return row;
	}

}
