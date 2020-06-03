package com.github.dreamhead.zero.identity.resource;

import com.github.dreamhead.zero.identity.domain.User;
import com.github.dreamhead.zero.identity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public final class UserResource {
    private UserService service;

    @Autowired
    public UserResource(final UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<String> register(@RequestBody final UserRegistration registration) throws URISyntaxException {
        try {
            User user = this.service.register(registration.getUsername(), registration.getPassword());
            return ResponseEntity
                    .created(new URI("/users/" + user.getId()))
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/users")
    public List<UserInfo> list() {
        return this.service.list().stream()
                .map(user -> new UserInfo(user.getName(), user.getPassword()))
                .collect(toList());
    }
}
