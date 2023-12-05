package com.ict01.mybatisproject.configuration.http;

/**
 * HTTP 응답 코드를 나타내는 enum입니다.
 * API 응답에 사용될 다양한 상태 코드를 정의합니다.
 *
 * @author : S.H.CHA
 */
public enum BaseResponseCode {

    SUCCESS, // API 요청이 성공적으로 처리되었음을 나타내는 코드

    ERROR, // API 요청 처리 중 오류가 발생했음을 나타내는 코드

    DATA_IS_NULL, // 요청 처리 중 NULL 값을 감지했음을 나타내는 코드

    VALIDATE_REQUIRED, // 요청 데이터의 유효성 검증이 필요함을 나타내는 코드
    ;
}
