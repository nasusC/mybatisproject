package com.ict01.mybatisproject.configuration.exception;

import com.ict01.mybatisproject.configuration.http.BaseResponseCode;

/**
 * 이 클래스는 RuntimeException을 상속받는 사용자 정의 예외 클래스의 기본 형태를 제공합니다.
 * 이 클래스는 BaseResponseCode 타입의 responseCode를 멤버 변수로 가지며,
 * 이 코드는 예외가 발생했을 때 HTTP 응답에 사용될 수 있습니다.
 *
 * @author : S.H.CHA
 */
public class AbstractBaseException extends RuntimeException {
    private static final long serialVersionUID = -5681021438179867146L;
    protected BaseResponseCode responseCode; // HTTP 응답 코드를 나타내는 멤버 변수
    protected Object[] args; // 예외 메시지 포맷팅에 사용될 추가 인자들

    public AbstractBaseException() {
        // 기본 생성자
    }

    public AbstractBaseException(BaseResponseCode responseCode) {
        // responseCode를 인자로 받는 생성자
        this.responseCode = responseCode;
    }

    public BaseResponseCode getResponseCode() {
        // responseCode를 반환하는 getter 메소드
        return responseCode;
    }

    public Object[] getArgs() {
        // args를 반환하는 getter 메소드
        return args;
    }
}
