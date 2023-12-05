package com.ict01.mybatisproject.controller;
import com.ict01.mybatisproject.configuration.exception.BaseException;
import com.ict01.mybatisproject.configuration.http.BaseResponse;
import com.ict01.mybatisproject.configuration.http.BaseResponseCode;
import com.ict01.mybatisproject.domain.Article;
import com.ict01.mybatisproject.domain.ArticleParameter;
import com.ict01.mybatisproject.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 관련 API 요청을 처리하는 컨트롤러 클래스입니다.
 * 게시글의 조회, 등록, 수정, 삭제 기능을 제공합니다.
 *
 * @author : S.H.CHA
 */
@RestController // RESTful 웹 서비스의 컨트롤러를 나타냄
@RequiredArgsConstructor // 필요한 의존성 주입을 위한 Lombok 어노테이션
@RequestMapping("/article") // 해당 컨트롤러의 기본 URL 경로 설정
@Api(tags = "게시판 API") // Swagger API 문서에 표시될 태그 설정
public class ArticleController {

    @Autowired // 의존성 자동 주입
    private ArticleService articleService;

    // [1] 전체 게시판 목록 조회
    @GetMapping("/") // GET 요청을 처리하는 메소드
    @ApiOperation(value = "전체 게시판 조회", notes = "게시판 전체 정보를 조회 할 수 있습니다.")
    public List<Article> getList() {
        return articleService.getList();
    }

    // [2] 특정 게시글 조회
    @GetMapping("/{articleId}") // {articleId} 경로 변수를 가진 GET 요청을 처리
    @ApiOperation(value = "게시판 상세 조회", notes = "게시판 상세 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1")
    })
    public BaseResponse<Article> get(@PathVariable int articleId){
        Article article = articleService.get(articleId);
        if(article == null) {
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
        }
        return new BaseResponse<Article>(article);
    }

    // [3] 게시물 등록 / [4] 게시물 수정
    @PutMapping("/save") // PUT 요청을 처리하는 메소드
    @ApiOperation(value = "게시판 등록/수정 처리", notes = "신규 게시물 저장 및 수정할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "Spring Boot"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "Spring Boot Practices..")
    })
    public BaseResponse<Integer> save(ArticleParameter parameter) {
        if(StringUtils.isEmpty(parameter.getTitle())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "제목"});
        }
        if(StringUtils.isEmpty(parameter.getContents())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "내용"});
        }
        articleService.save(parameter);
        return new BaseResponse<Integer>(parameter.getArticleId());
    }

    // [5] 게시글 삭제
    @DeleteMapping("/{articleId}") // DELETE 요청을 처리하는 메소드
    @ApiOperation(value = "게시물 삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1"),
    })
    public BaseResponse<Boolean> delete(@PathVariable int articleId) {
        Article article = articleService.get(articleId);
        if(article == null) {
            return new BaseResponse<Boolean>(false);
        }
        articleService.delete(articleId);
        return new BaseResponse<Boolean>(true);
    }
}
