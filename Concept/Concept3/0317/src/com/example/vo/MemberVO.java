package com.example.vo;

import java.util.Date;
  

//자바의 변수명 = html 변수명 = db변수명 통일하는 것이 좋다.
public class MemberVO {
	private int idx, age;
	private String name, gender, city;
	private Date regdate;
	
	public MemberVO() {}

	//생성자 만들 때 순서도 고려하면 좋다(html과 db고려)
	public MemberVO(String name, String gender, int age, String city) { //idx는 sequence로 줘서 자동으로 증가하기에 따로 값을 안 줘도 된다.
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
	}

	//모든 값 다 넣은 생성자
	public MemberVO(int idx, String name, String gender, int age, String city, Date regdate) { 
		this.idx = idx;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
		this.regdate = regdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString(){
		return "MemberVO [idx=" + idx + ", age=" + age + ", name=" + name + ", gender=" + gender + ", city=" + city + ", regdate=" + regdate + "]";
	}
}
