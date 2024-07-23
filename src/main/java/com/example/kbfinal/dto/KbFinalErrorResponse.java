package com.example.kbfinal.dto;

import com.example.kbfinal.exception.KbFinalErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KbFinalErrorResponse {
    private KbFinalErrorCode errorCode;
    private String errorMessage;
}
