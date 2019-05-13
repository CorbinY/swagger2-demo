package com.example.swagger2demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configurable
//此处为@Configuration注解，代替xml配置的，不是上面的那个
@Configuration
@EnableSwagger2
public class Swagger2Config/* implements WebMvcConfigurer*/ {
//展示页面参见项目的静态文件中的图片

    //此处不必配置

//    /**
//     * 显示swagger-ui.html文档展示页，还必须注入swagger资源：
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 解决静态资源无法访问
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        // 解决swagger无法访问
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        // 解决swagger的js文件无法访问
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger2demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文档的title
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                //api title的描述
                .description("这是一个swagger2小型demo")
                //许可条例名字，在界面上允许点击，连接为下面的url
                .license("基于apache协议")
                .licenseUrl("http://www.sina.com")
                //开发者联系方式，开发者名字、开发者主页、联系方式
                .contact(new Contact("yin", "https://www.caidu.com", "corbin_yin@163.com"))
                .termsOfServiceUrl("http://www.baidu.com")
                //版本
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket v1Api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("v1")
//                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(true)
//                .pathMapping("/")    // base，最终调用接口后会和paths拼接在一起
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.swagger2demo.controller"))
//                // .paths(or(regex("/api/.*")))//过滤的接口
//                .build()
//                .apiInfo(v1ApiInfo());
//    }
//
//    private ApiInfo v1ApiInfo() {
//        return new ApiInfoBuilder().title("ap-manage-server")
//                .description("ap-manage-server接口")
//                .version("1.0")
//                .build();
//    }

}
