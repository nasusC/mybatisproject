package com.ict01.mybatisproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger를 사용하여 API 문서화를 설정하는 클래스입니다.
 * Swagger를 활성화하고, API 문서의 기본 정보를 구성합니다.
 *
 * @author : S.H.CHA
 */

@Configuration // 이 클래스를 Spring 구성 클래스로 지정
@EnableSwagger2 // Swagger 2를 활성화
public class SwaggerConfiguration {

    @Bean // Spring 컨테이너에 의해 관리되는 빈(Bean)을 정의
    public Docket docket(){
        ApiInfoBuilder apiInfo = new ApiInfoBuilder();
        apiInfo.title("API Server 문서"); // API 문서의 제목 설정
        apiInfo.description("API Server 문서입니다."); // API 문서의 설명 설정

        Docket docket = new Docket(DocumentationType.SWAGGER_2); // Swagger 문서 타입 설정
        docket.apiInfo(apiInfo.build()); // 위에서 설정한 API 정보를 Docket에 추가

        ApiSelectorBuilder apis = docket.select().apis(RequestHandlerSelectors.basePackage(
                "com.ict01.jpaproject04.controller")); // 특정 패키지 내의 컨트롤러를 대상으로 API 문서화 설정

        apis.paths(PathSelectors.ant("/**")); // 모든 경로에 대해 API 문서화 설정

        return apis.build(); // 구성된 Docket 인스턴스 반환
    }
}
