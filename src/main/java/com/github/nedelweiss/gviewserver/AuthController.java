package com.github.nedelweiss.gviewserver;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: what about https://www.baeldung.com/spring-server-sent-events
@RestController
@RequestMapping("/amethyst")
public class AuthController {

    private static final String SECRET = System.getenv("SECRET");
    private static final String INVALID_SECRET_MESSAGE = "Invalid secret";
    private static final String SUCCESS_MESSAGE = "Success";

    private Code code;

    @GetMapping("/auth/redirect")
    public ResponseEntity<String> redirect(
        @NonNull @RequestParam String code,
        @NonNull @RequestParam() String state
    ) {
        if (!state.equals(SECRET)) {
            return ResponseEntity.badRequest().body(INVALID_SECRET_MESSAGE);
        } else {
            this.code = new Code(code, state);
            return ResponseEntity.ok(SUCCESS_MESSAGE);
        }
    }

    @GetMapping("/auth/code")
    public ResponseEntity<?> code(@RequestParam String secret) {
        return secret.equals(code.getSecret())
            ? ResponseEntity.ok(new CodeDto(code.getCode()))
            : ResponseEntity.badRequest().body(INVALID_SECRET_MESSAGE);
    }
}