package com.katao.userservice.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}