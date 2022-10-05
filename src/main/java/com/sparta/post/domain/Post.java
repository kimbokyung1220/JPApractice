package com.sparta.post.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.post.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor //기본생성자 생성
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줌
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    public Post(String password, String title, String content, String author) {
        this.password = password;
        this.title = title;
        this.content = content;
        this.author = author;
        //this.createdAt = createdAt;
    }

    public Post(PostRequestDto postRequestDto) {
        this.password = postRequestDto.getPassword();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
    }

    // 수정
    public void update(PostRequestDto postRequestDto) {
        this.password = postRequestDto.getPassword();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
    }
}
