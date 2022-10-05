package com.sparta.post.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String password;
    private String title;
    private String content;
    private String author;

}
