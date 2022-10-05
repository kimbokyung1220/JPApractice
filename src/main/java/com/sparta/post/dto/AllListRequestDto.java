package com.sparta.post.dto;

import com.sparta.post.domain.Timestamped;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AllListRequestDto {
    private String title;
    private String author;
    private LocalDateTime createdAt;

}
