package com.github.nedelweiss.gviewserver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public record Code(String code, String secret) {

}
