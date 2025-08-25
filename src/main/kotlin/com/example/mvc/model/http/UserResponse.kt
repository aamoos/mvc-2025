package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

// 사용자 응답을 나타내는 데이터 클래스
data class UserResponse(
    var result: Result?=null,                    // 결과
    var description: String?=null,              // 설명

    @JsonProperty("user")                       // JSON 필드명을 "user"로 지정
    var userRequest: MutableList<UserRequest>?=null // 사용자 정보 리스트
)

// 결과를 나타내는 데이터 클래스
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class) // JSON 필드명을 스네이크 케이스로 변환
data class Result(
    var resultCode: String = "OK",             // 결과 코드 (result_code)
    var resultMessage:String?=null      // 결과 메시지 (result_message)
)