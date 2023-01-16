package com.ntg.socialnetworkspringcloudin28minuts.controller.controllerAdvice;

import java.util.List;

public record ValidationExceptionResponse(List<Violation> violations) {
}
