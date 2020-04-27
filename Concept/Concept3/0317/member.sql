CREATE SEQUENCE member_seq
  Start with 1
  increment by 1
  maxvalue 99;
  
CREATE TABLE Member
(
  idx    NUMBER(2),
  name   VARCHAR2(20)  NOT NULL,
  gender  CHAR(6)    NOT NULL,
  age    NUMBER(2),
  city    VARCHAR2(10),
  regdate  DATE,
  CONSTRAINT member_idx_pk PRIMARY KEY(idx),
  CONSTRAINT member_gender_ck CHECK(gender IN('male', 'female')),
  CONSTRAINT member_age_ck CHECK(age BETWEEN 20 AND 65),
  CONSTRAINT member_city_ck CHECK(city IN('서울','부산','대전','인천','제주'))
);