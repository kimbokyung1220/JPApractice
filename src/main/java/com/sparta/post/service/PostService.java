package com.sparta.post.service;

import com.sparta.post.domain.Post;
import com.sparta.post.dto.AllListRequestDto;
import com.sparta.post.dto.PasswordDto;
import com.sparta.post.dto.PostRequestDto;
import com.sparta.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 전체 조회
    @Transactional
    public List<AllListRequestDto> findAllList() {
        List<Post> allList = postRepository.findAll();

        List<AllListRequestDto> resultList = new ArrayList<>();
        for (Post post : allList) {
            AllListRequestDto allListRequestDto = AllListRequestDto.builder()
                    .title(post.getTitle())
                    .author(post.getAuthor())
                    .createdAt(post.getCreatedAt())
                    .build();
            resultList.add(allListRequestDto);
        }
        return resultList;
    }

    // 상세 조회
    @Transactional
    public Post detailPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return post;
    }
    
    // 수정
    @Transactional
    public Post update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(postRequestDto);
        return post;
    }

    // 비밀번호 확인
    public Boolean checkPassword(Long id, PasswordDto passwordDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        );
        return post.getPassword().equals(passwordDto.getPassword());
    }
}
