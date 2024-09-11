package com.github.nedelweiss.gviewserver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public record Code(String code, String secret) {

}
