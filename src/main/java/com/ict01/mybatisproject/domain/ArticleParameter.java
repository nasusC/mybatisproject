package com.ict01.mybatisproject.domain;

import lombok.Data;

/**
 * 게시판의 게시글 등록 및 수정에 사용되는 파라미터 클래스입니다.
 * 게시글의 아이디, 제목, 내용 등의 필드를 포함합니다.
 *
 * @author : S.H.CHA
 */

@Data // Lombok 라이브러리를 사용하여 getter, setter, toString 등을 자동 생성
// 등록/수정 용으로 사용
public class ArticleParameter {

    private int articleId; // 게시글의 고유 아이디
    private String title; // 게시글의 제목
    private String contents; // 게시글의 내용
}
