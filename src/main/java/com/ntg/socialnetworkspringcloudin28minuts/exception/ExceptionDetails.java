package com.ntg.socialnetworkspringcloudin28minuts.exception;

import java.time.LocalDateTime;

public record ExceptionDetails (
        LocalDateTime timeStamp,
        String massage,
        String description
) {}
