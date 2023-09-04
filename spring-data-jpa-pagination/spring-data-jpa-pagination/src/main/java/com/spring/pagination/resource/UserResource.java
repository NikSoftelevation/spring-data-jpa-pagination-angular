package com.spring.pagination.resource;

import com.spring.pagination.response.HttpResponse;
import com.spring.pagination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size) {

        return ResponseEntity
                .ok()
                .body(HttpResponse
                        .builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("page", userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Users Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.NO_CONTENT.value())
                        .build());
    }
}
