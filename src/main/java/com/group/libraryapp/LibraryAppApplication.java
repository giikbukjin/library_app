package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 어노테이션
// Spring 실행 위한 설정을 자동으로 해 줌
public class LibraryAppApplication {
  public static void main(String[] args) {
    // Spring 서버 시작
    SpringApplication.run(LibraryAppApplication.class, args);
  }
}
