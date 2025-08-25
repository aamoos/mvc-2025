package com.example.mvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication // 스프링 부트 애플리케이션을 나타내는 어노테이션
class MvcApplication

fun main(args: Array<String>) {
	runApplication<MvcApplication>(*args) // 애플리케이션 실행
}