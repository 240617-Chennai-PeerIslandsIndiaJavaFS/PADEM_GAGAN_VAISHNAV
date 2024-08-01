package org.quizapplication.quiz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quizapplication.quiz.dao.UserRepository;
import org.quizapplication.quiz.models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User user = new User(1, "testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        User result = userService.findByUsername("testuser");
        assertEquals(user, result);
    }

    @Test
    public void testSave() {
        User user = new User(1, "testuser");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);
        assertEquals(user, result);
    }
}
