package com.ezen.student.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ezen.student.configuration.StudentConfiguration;
import com.ezen.student.dto.Student;
import com.ezen.student.service.SelectOneService;

public class MainClassWithConfiguration {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx
		= new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		SelectOneService sos = ctx.getBean("selectOneService",SelectOneService.class); // 따옴표는 함수이름 ! 메서드이름? 인가보다
		Student std = sos.selectOneStudent("H39lesvj7544vf89");
		
		System.out.print("sNum:" + std.getsNum() + "\n");
		System.out.print("|sId:" + std.getsId() + "\n");
		System.out.print("|sPw : " + std.getsPw() + "\n");
		System.out.print("|sName : " + std.getsName() + "\n");
		System.out.print("|sAge : " + std.getsAge() + "\n");
		System.out.print("|sGender : " + std.getsGender() + "\n");
		System.out.print("|sMajor : " + std.getsMajor() + "\n");
		
		ctx.close();

	}

}
