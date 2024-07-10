package Service;

import org.example.DAO.UserDAO;
import org.example.Models.User;
import org.example.Service.UserSer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserSerTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserSer userSer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginUserSuccess() throws SQLException {
        User user = new User();
        user.setEmail("test@example.com");
        user.setUser_password("password");

        when(userDAO.getByEmail("test@example.com")).thenReturn(user);

        User result = userSer.loginUser("test@example.com", "password");

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(userDAO, times(1)).getByEmail("test@example.com");
    }

    @Test
    void testLoginUserFailure() throws SQLException {
        when(userDAO.getByEmail("test@example.com")).thenReturn(null);

        User result = userSer.loginUser("test@example.com", "password");

        assertNull(result);
        verify(userDAO, times(1)).getByEmail("test@example.com");
    }

    @Test
    void testGetUserRoleById() throws SQLException {
        User user = new User();
        user.setUser_role("Admin");

        when(userDAO.getUserById(1)).thenReturn(user);

        String role = userSer.getUserRoleById(1);

        assertEquals("Admin", role);
        verify(userDAO, times(1)).getUserById(1);
    }
}