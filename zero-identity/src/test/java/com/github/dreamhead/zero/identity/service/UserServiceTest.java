package com.github.dreamhead.zero.identity.service;

import com.github.dreamhead.zero.identity.domain.User;
import com.github.dreamhead.zero.identity.repository.UserRepository;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserRepository repository;
    private UserService service;

    @BeforeEach
    void setUp() {
        this.repository = mock(UserRepository.class);
        this.service = new UserService(repository);
    }

    @Test
    public void should_register_user() {
        when(this.repository.findByName("name")).thenReturn(Optional.empty());
        User user = service.register("name", "password");
        assertThat(user.getName()).isEqualTo("name");
        assertThat(user.getPassword()).isEqualTo("password");
    }

    @Test
    public void should_not_register_same_user() {
        when(this.repository.findByName("name")).thenReturn(Optional.of(new User("name", "password")));
        assertThrows(IllegalArgumentException.class, () -> {
            service.register("name", "password");
        });
    }

    @Test
    public void should_list_all_users() {
        when(this.repository.findAll()).thenReturn(ImmutableList.of(new User("name", "password")));

        ImmutableList<User> users = service.list();
        User user = users.get(0);
        assertThat(user.getName()).isEqualTo("name");
        assertThat(user.getPassword()).isEqualTo("password");
    }
}