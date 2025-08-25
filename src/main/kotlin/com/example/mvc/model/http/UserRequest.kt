package com.example.mvc.model.http

import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// 사용자 요청을 나타내는 데이터 클래스
data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String?=null,          // 이름

    var age:Int?=null,               // 나이

    @field:Email
    var email:String?=null,          // 이메일

    @field:NotBlank
    var address:String?=null,        // 주소

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") //정규식 검증
    var phoneNumber:String?=null,     // 전화번호 (phone_number)

    var createdAt:String?=null      // yyyy-MM-dd HH:mm:ss      ex) 2020-10-02 13:00:00
){

    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 어야 합니다")
    private fun isValidCreatedAt(): Boolean {    //정상 true, 비정상 false

        try{
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"))
            return true
        }catch (e: Exception) {
            return false
        }

    }

}