package com.example.dependencyinjection;

public class Controller1 {
    private final Service1 service1;

// '강한 결합'
// Contoller1이 Service1 객체를 생성하여 사용

//    public Controller1(){
//        this.service1 = new Service1();  }

// 만약 이 controller가 여러개일경우 -> 각각의 service를 생성하여 사용 중
// Repository1 생성자 변경시 모든 controller, Service의 코드 변경이 필요


// '강한 결합 해결방법'
// service1 객체 사용
    public Controller1(Service1 service1) {
        this.service1 = service1;
    }
}



