package com.ezen.toys;

import com.ezen.battery.Battery;
import com.ezen.battery.NormalBattery;

public class ElectronicCar {
	private Battery bat; // 인터페이스 레퍼런스 변수.
	
	public ElectronicCar(  ){
		bat = new NormalBattery();
		// 인터페이스 멤버 변수에 battery 를 임플리먼트 한 클래스를 대입합니다.
		
	}
}
// 이 장난감은 배터리가 출시당시 탑재(내장)되서 교체가 불가능한 상태로 판매되는 형태입니다.
