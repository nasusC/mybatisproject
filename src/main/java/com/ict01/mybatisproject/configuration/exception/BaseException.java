package com.ict01.mybatisproject.configuration.exception;

import com.ict01.mybatisproject.configuration.http.BaseResponseCode;

/**
 * 이 클래스는 AbstractBaseException을 상속받는 구체적인 예외 처리 클래스입니다.
 * 기본적인 예외 처리 기능을 제공하며, HTTP 응답 코드와 추가 파라미터들을 사용하여
 * 더 상세한 예외 정보를 제공할 수 있습니다.
 *
 * @author : S.H.CHA
 */
public class BaseException extends AbstractBaseException{

    private static final long serialVersionUID = -8367707264653731470L;

    public BaseException() {
        // 기본 생성자
    }

    public BaseException(BaseResponseCode responseCode) {
        // responseCode를 파라미터로 받는 생성자
        this.responseCode = responseCode;
    }

    public BaseException(BaseResponseCode responseCode, String[] args){
        // responseCode와 args를 파라미터로 받는 생성자
        this.responseCode = responseCode;
        this.args = args;
    }

}
