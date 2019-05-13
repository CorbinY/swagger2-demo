package com.example.swagger2demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @ApiOperation(value = "测试接口",notes = "测试")
    @GetMapping("/test1")
    public String test() {
        return "dfg";
    }

}
