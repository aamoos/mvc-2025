package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController         // REST API 컨트롤러로 동작함을 나타냄
@RequestMapping("/api") // http://localhost:8080/api 주소로 들어오는 요청을 처리
@Tag(name = "GET API", description = "GET 요청을 처리하는 API")
class GetApiController {

    @Operation(summary = "hello, abcd 요청", description = "hello 또는 abcd로 요청 시 \"hello kotlin\" 문자열을 반환합니다.")
    @GetMapping(path = ["/hello", "/abcd"])   // GET http://localhost:8080/api/hello 또는 http://localhost:8080/api/abcd 요청을 처리
    fun hello(): String {
        return "hello kotlin"
    }

    @Operation(summary = "request-mapping 요청", description = "GET 방식으로 /request-mapping 요청 시 \"request-mapping\" 문자열을 반환합니다.")
    @RequestMapping(method = [RequestMethod.GET], path = ["request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @Operation(summary = "경로 변수 사용", description = "경로에 포함된 변수를 사용하여 요청을 처리합니다.")
    @GetMapping("/get-mapping/path-variable/{name}/{age}")      // GET http://localhost:8080/api/get-mapping/path-variable/steve/20 요청을 처리
    fun pathVariable(
        @Parameter(description = "이름") @PathVariable name: String,
        @Parameter(description = "나이") @PathVariable age: Int
    ): String {
        println("${name}, ${age}")
        return name+" "+age
    }

    @Operation(summary = "경로 변수명 명시적 지정", description = "경로 변수의 이름을 명시적으로 지정하여 요청을 처리합니다.")
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")      // GET http://localhost:8080/api/get-mapping/path-variable/steve/20 요청을 처리
    fun pathVariable2(
        @Parameter(description = "이름") @PathVariable(value = "name") _name: String,
        @Parameter(description = "나이") @PathVariable(name = "age") age: Int
    ): String {
        val name = "kotlin"

        println("${_name}, ${age}")
        return _name+" "+age
    }

    @Operation(summary = "쿼리 파라미터 사용", description = "쿼리 파라미터를 사용하여 요청을 처리합니다.")
    @GetMapping("/get-mapping/query-param") // ?name=steve&age=20
    fun queryParam(
        @Parameter(description = "이름") @RequestParam(name = "name") name: String,
        @Parameter(description = "나이") @RequestParam(value = "age") age: Int
    ): String{
        println("${name}, ${age}")
        return name + " "+age
    }

    @Operation(summary = "쿼리 파라미터를 객체로 처리", description = "쿼리 파라미터를 객체로 변환하여 처리합니다.")
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @Operation(summary = "쿼리 파라미터를 Map으로 처리", description = "쿼리 파라미터를 Map으로 변환하여 처리합니다.")
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        return map
    }
}
