package com.example.dependencyinjection;

public class Service1 {

    private final Repository1 repository1;

// '강한 결합'
// Service1이 Repository1 객체를 생성하여 사용

//    public Service1() {
//        this.repository1 = new Repository1();


// '강한 결합 해결방법'
//  repository 객체 사용
    public Service1(Repository1 repository1) {
        this.repository1 = repository1;
    }
}

// '강한 결합 해결방법'
//객체 생성
Service1 service1 = new Service1(repository1);
