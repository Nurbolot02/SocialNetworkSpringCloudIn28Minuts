package com.ntg.socialnetworkspringcloudin28minuts.controller.controllerAdvice;

import java.time.LocalDateTime;

public record Violation(
        LocalDateTime localDateTime,
        String fieldName,
        String massage) {
}