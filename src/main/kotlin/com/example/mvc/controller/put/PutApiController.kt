package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Tag(name = "PUT API", description = "PUT 요청을 처리하는 API")
class PutApiController {

    @Operation(summary = "put-mapping 요청", description = "PUT 방식으로 /put-mapping 요청 시 \"put-mapping\" 문자열을 반환합니다.")
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @Operation(summary = "request-mapping 요청", description = "PUT 방식으로 /request-mapping 요청 시 \"request-mapping - put method\" 문자열을 반환합니다.")
    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @Operation(summary = "RequestBody를 객체로 처리", description = "JSON 형식의 RequestBody를 객체로 변환하여 처리합니다.")
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest
                         , bindingResult: BindingResult): ResponseEntity<String> {

        if(bindingResult.hasErrors()){
            //500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("")

        // 0. Response
//        return UserResponse().apply {
//            // 1. 결과 객체 생성
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            // 2. 설명 추가
//            this.description = "~~~~~~~~~~~~~"
//        }.apply {
//            // 3. 사용자 정보 리스트 생성
//            val userList = mutableListOf<UserRequest>()
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "a"
//                this.age = 10
//                this.email = "a@gmail.com"
//                this.address = "a address"
//                this.phoneNumber = "010-1111-aaaaa"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "b"
//                this.age = 20
//                this.email = "b@gmail.com"
//                this.address = "b address"
//                this.phoneNumber = "010-1111-bbbbb"
//            })
//
//            this.userRequest = userList
//        }
    }

}
