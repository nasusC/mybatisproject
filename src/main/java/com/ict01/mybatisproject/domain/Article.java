package com.ict01.mybatisproject.domain;

import lombok.Data;

/**
 * 게시판의 게시글을 나타내는 도메인 클래스입니다.
 * 게시글의 기본 정보(아이디, 제목, 내용, 등록일)를 포함합니다.
 *
 * @author : S.H.CHA
 */

@Data // Lombok 라이브러리를 사용하여 getter, setter, toString 등을 자동 생성
// result 용으로 사용
public class Article {

    private int articleId; // 게시글의 고유 아이디
    private String title; // 게시글의 제목
    private String contents; // 게시글의 내용
    private Data regData; // 게시글의 등록 날짜
}
