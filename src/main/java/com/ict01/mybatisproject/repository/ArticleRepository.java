package com.ict01.mybatisproject.repository;

import com.ict01.mybatisproject.domain.Article;
import com.ict01.mybatisproject.domain.ArticleParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시글 관련 데이터 접근을 위한 리포지토리 인터페이스입니다.
 * 게시글의 조회, 저장, 수정, 삭제 기능을 정의합니다.
 *
 * @author : S.H.CHA
 */
@Repository // 이 인터페이스가 데이터 접근 계층의 구성 요소임을 나타냄
public interface ArticleRepository {

    // [1] 전체 게시글 조회
    List<Article> getList(); // 모든 게시글을 조회하는 메소드

    // [2] 특정 게시글 조회
    Article get(int articleId); // 특정 아이디를 가진 게시글을 조회하는 메소드

    // [3] 게시글 등록
    void save(ArticleParameter article); // 새 게시글을 저장하는 메소드

    // [4] 게시글 수정
    void update(ArticleParameter article); // 기존 게시글을 수정하는 메소드

    // [5] 게시글 삭제
    void delete(int articleId); // 특정 아이디를 가진 게시글을 삭제하는 메소드
}
