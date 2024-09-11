package com.github.nedelweiss.gviewserver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Code {

    private final String code;
    private final String secret;

    public String getCode() {
        return code;
    }

    public String getSecret() {
        return secret;
    }
}
