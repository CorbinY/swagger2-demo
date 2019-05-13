package com.example.swagger2demo.controller;

//详细学习，参见https://blog.csdn.net/sanyaoxu_2/article/details/80555328


/**
 * Swagger使用的注解及其说明：
 *
 * @Api：用在类上，说明该类的作用。
 *
 * @ApiOperation：注解来给API增加方法说明。
 *
 * @ApiImplicitParams : 用在方法上包含一组参数说明。
 *
 * @ApiImplicitParam：用来注解来给方法入参增加说明。
 *
 * @ApiResponses：用于表示一组响应
 *
 * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
 *
 *     l   code：数字，例如400
 *
 *     l   message：信息，例如"请求参数没填好"
 *
 *     l   response：抛出异常的类
 *
 * @ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 *
 *     l   @ApiModelProperty：描述一个model的属性
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api("这是一个此时swagger的类")//用在类上，说明该类的作用。
public class TestController {


    @ApiOperation(value = "测试接口1",notes = "测试这个个口注解的作用")//注解来给API增加方法说明。
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })//用在方法上包含一组参数说明
    @PostMapping("/test1")
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        return "dfg";
    }

}
