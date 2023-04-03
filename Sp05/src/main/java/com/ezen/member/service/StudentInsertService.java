package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentInsertService {
	
	// private Student sdao = new ( new를 쓰기 싫어서!)
	
	private StudentDao sdao;
	
	public StudentInsertService(StudentDao sdao){
		this.sdao = sdao;
	}
	
	public void insertStudent(Student std) {
		sdao.insertStudent(std);
	}
	
}
