package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Tag(name = "POST API", description = "POST 요청을 처리하는 API")
class PostApiController {

    @Operation(summary = "post-mapping 요청", description = "POST 방식으로 /post-mapping 요청 시 \"post-mapping\" 문자열을 반환합니다.")
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    @Operation(summary = "request-mapping 요청", description = "POST 방식으로 /request-mapping 요청 시 \"request-mapping\" 문자열을 반환합니다.")
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @Operation(summary = "RequestBody를 객체로 처리", description = "JSON 형식의 RequestBody를 객체로 변환하여 처리합니다.")
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        // json -> object
        println(userRequest)
        return userRequest      // object -> json
    }

}