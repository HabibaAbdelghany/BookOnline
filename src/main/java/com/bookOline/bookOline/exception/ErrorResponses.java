package com.bookOline.bookOline.exception;

import lombok.*;

@Builder
@Data

@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponses {
    private int status;
    private String message;
    private long timeStamp;


}