package com.member.model;

import java.util.*;

public interface MemberDAO_interface {
	      public void insert(MemberVO memberVO);
          public void update(MemberVO memberVO);
          public MemberVO findByPrimaryKey(String mem_no);
	      public List<MemberVO> getAll();
}
