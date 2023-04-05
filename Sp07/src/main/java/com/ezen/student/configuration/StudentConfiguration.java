package com.ezen.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.DataBaseConnectionInfo;
import com.ezen.student.service.InsertService;
import com.ezen.student.service.SelectAllService;
import com.ezen.student.service.SelectOneService;
import com.ezen.student.service.UpdateService;

@Configuration
public class StudentConfiguration {
	
	// Configuration 이라는 어너테이션이 붙은 클래스를 이용해서, 활용가능한 클래스의 
	// 객체를 직접 생성 리턴해주는 메서드를 제작 운영합니다.  // configuration
	
	@Bean 
	public DataBaseConnectionInfo dbConnectionInfo() {
		// DataBaseConnectionInfo 형태의 new 인스턴스를 만들 리턴해주는 메서드
		DataBaseConnectionInfo temp = new DataBaseConnectionInfo();
		temp.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		temp.setUserId("scott");
		temp.setUserPw("tiger");
		temp.setDriver("oracle.jdbc.driver.OracleDriver");
		return temp;
	}	// Bean 어너테이션이 붙은 메서드는 해당객체가 리턴되는 객체들이며, 함수를 직접 이름으로
	// 호출하지 않고, getBean() 메서드를 ㅣ용하여 객체를 리턴 받게 환경을 구성해줍니다.
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao(dbConnectionInfo());
	}
	
	@Bean
	public InsertService insertService() {
		return new InsertService(studentDao());
	}
	
	@Bean
	public SelectAllService selectAllService() {
		return new SelectAllService(studentDao());
	}
	
	@Bean
	public UpdateService updateService() {
		return new UpdateService(studentDao());
	}
	
	@Bean
	public SelectOneService selectOneService() {
		return new SelectOneService(studentDao());
	}
}
