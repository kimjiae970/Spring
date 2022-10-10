package com.example.dependencyinjection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Repository1 {
    public Repository1(String id, String pw){
        //DB연결
        Connection connection = DriverManager.getConnection("url",id, pw);
    }

}

//객체 생성
String id = "sa";
String pw = "";
Repository1 repository1 = new Repository1(id,pw);