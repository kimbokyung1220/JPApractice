package com.sparta.post.controller;

import com.sparta.post.domain.Post;
import com.sparta.post.dto.AllListRequestDto;
import com.sparta.post.dto.PasswordDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.repository.PostRepository;
import com.sparta.post.response.ResponseHandler;
import com.sparta.post.service.PostService;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Status;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    // 게시물 전체조회
    @GetMapping("/api/posts")
    public ResponseEntity<Object> getPost() {
        try {
            List<AllListRequestDto> allList = postService.findAllList();
            return ResponseHandler.generateResponse("true", HttpStatus.OK, allList, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.METHOD_NOT_ALLOWED, false, "사용되지 않는 메소드를 요청했습니다.");
        }
    }
    // 게시글 상세조회
    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Object> detailPost(@PathVariable Long id){
        try {
            Post post = postService.detailPost(id);
            return ResponseHandler.generateResponse("true", HttpStatus.OK, post, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.INTERNAL_SERVER_ERROR, false, "해당 아이디가 없습니다.");
        }
    }

    //게시글 생성
    @PostMapping("/api/posts")
    public ResponseEntity<Object> creatPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        try {
            return ResponseHandler.generateResponse("true", HttpStatus.OK, postRepository.save(post), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.BAD_REQUEST, false, "입력값을 확인해 주세요");
        }
    }

    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public ResponseEntity<Object>  updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        Post post = postService.update(id, postRequestDto);
        try {
            return ResponseHandler.generateResponse("true", HttpStatus.OK, post, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.BAD_REQUEST, false, "입력값을 확인해 주세요");
        }
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        try {
            return ResponseHandler.generateResponse("true", HttpStatus.OK, id, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.INTERNAL_SERVER_ERROR, false, "아이디를 확인해 주세요");
        }
    }

    //비밀번호 확인
    @PostMapping("/api/posts/{id}")
    public ResponseEntity<Object> checkPassword(@PathVariable Long id, @RequestBody PasswordDto passwordDto) {
        try {
            return ResponseHandler.generateResponse("true", HttpStatus.OK, postService.checkPassword(id, passwordDto), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("false", HttpStatus.INTERNAL_SERVER_ERROR, false, "아이디를 확인해 주세요");
        }
    }

}
