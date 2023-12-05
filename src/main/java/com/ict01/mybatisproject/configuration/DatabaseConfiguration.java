package com.ict01.mybatisproject.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 데이터베이스 구성을 위한 클래스입니다.
 * Spring Framework의 설정 기능을 사용하여 데이터베이스 연결 및 구성을 관리합니다.
 */
@Configuration // 이 클래스를 Spring 구성 클래스로 지정
public class DatabaseConfiguration {

    @Bean // Spring 컨테이너에 의해 관리되는 빈(Bean)을 정의
    @ConfigurationProperties(prefix = "spring.datasource") // application.properties 파일에서 'spring.datasource'로 시작하는 속성들을 바인딩
    public DataSource dataSource() {
        // DataSource 객체를 생성하고 구성하는 메소드
        return DataSourceBuilder.create().build(); // DataSourceBuilder를 사용하여 DataSource 객체를 생성 및 반환
    }

}
