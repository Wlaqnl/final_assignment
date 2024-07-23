package com.example.kbfinal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KbFinalErrorCode {
    USER_NOT_FOUND("해당하는 정보의 사용자를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("서버에 오류가 발생하였습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    INVALID_AUTH_TOKEN("권한 정보가 없는 토큰입니다."),
    DUPLICATE_RESOURCE("데이터가 이미 존재합니다.");

    private final String message;
}
