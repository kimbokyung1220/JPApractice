package com.sparta.post.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404,"COMMON-ERR-404","해당 페이지는 존재하지 않습니다."),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","해당 ID는 존재하지 않습니다."),
    BAD_REQUEST(400,"COMMON-ERR-400","null값이 존재합니다.")
    ;

    private int status;
    private String errorCode;
    private String message;
}
