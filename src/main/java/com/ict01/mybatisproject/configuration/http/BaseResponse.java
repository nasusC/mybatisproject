package com.ict01.mybatisproject.configuration.http;

import lombok.Data;

/**
 * 이 클래스는 API 응답을 위한 기본 Response 클래스입니다.
 * 모든 API 응답에 공통적으로 사용될 수 있는 구조를 제공합니다.
 * 제네릭 타입 T를 사용하여 다양한 타입의 데이터를 응답 본문에 포함할 수 있습니다.
 *
 * @author : S.H.CHA
 */

@Data // Lombok 라이브러리를 사용하여 기본적인 getter/setter, toString 등을 자동으로 생성
public class BaseResponse<T> {

    private BaseResponseCode code; // 응답 코드를 나타내는 멤버 변수
    private String message; // 응답 메시지를 나타내는 멤버 변수
    private T data; // 실제 응답 데이터를 담을 제네릭 타입의 멤버 변수

    public BaseResponse(T data) {
        // 데이터만을 인자로 받는 생성자. 성공 응답을 나타내는 기본 코드와 함께 사용됩니다.
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    // BaseControllerAdvice 작성 시 사용되는 생성자
    public BaseResponse(BaseResponseCode code, String message) {
        // 응답 코드와 메시지를 인자로 받는 생성자
        this.code = code;
        this.message = message;
    }
}
