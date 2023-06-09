package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;

// 서비스의 클래스형태의 객체들을 하나씩 생성-보유하고 있다가 요청시 리턴해서 사용할 수 있게 합니다
// 프로젝트 내에 클래스별 유일한 객체들 입니다.
public class StudentAssembler {
	
	private StudentDao sdao;
	private StudentInsertService is;
	private StudentSelectService ss;
	private StudentUpdateService us;
	private StudentSelectOneService sss;
	
	public StudentAssembler() {
		sdao = new StudentDao(); // 객체 생성 
		is = new StudentInsertService(sdao); // 조립
		ss = new StudentSelectService(sdao);
		us = new StudentUpdateService(sdao);
		sss = new StudentSelectOneService(sdao);
		
	}
	
	public StudentSelectOneService getSss() {
		return sss;
	}
	
	public StudentUpdateService getUs() {
		return us;
	}
	
	public StudentSelectService getSs() {
		return ss;
	}
	
	public StudentInsertService getIs() {
		return is;
	}
}
