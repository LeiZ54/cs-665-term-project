package edu.bu.met.cs665;

import edu.bu.met.cs665.dao.UserDAO;
import edu.bu.met.cs665.entity.User;
import edu.bu.met.cs665.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestJDBC {
    private UserService userService;
    private UserDAO userDAOMock;

    @Before
    public void setUp() {
        userDAOMock = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAOMock);
    }

    @Test
    public void testAddUser() {
        User user = new User("John", "john@example.com");
        doNothing().when(userDAOMock).addUser(user);

        userService.addUser("John", "john@example.com");

        verify(userDAOMock, times(1)).addUser(user);
    }

    @Test
    public void testGetAllUsers() {
        List<User> mockUsers = Arrays.asList(
                new User(1, "Alice", "alice@example.com"),
                new User(2, "Bob", "bob@example.com")
        );
        when(userDAOMock.getAllUsers()).thenReturn(mockUsers);

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userDAOMock, times(1)).getAllUsers();
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userDAOMock).deleteUser(1);

        userService.deleteUser(1);

        verify(userDAOMock, times(1)).deleteUser(1);
    }

    @Test
    public void testDeleteAllUsers() {
        doNothing().when(userDAOMock).deleteAllUsers();

        userService.deleteAllUsers();

        verify(userDAOMock, times(1)).deleteAllUsers();
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1, "Alice Updated", "alice.updated@example.com");
        doNothing().when(userDAOMock).updateUser(user);

        userService.updateUser(1, "Alice Updated", "alice.updated@example.com");

        verify(userDAOMock, times(1)).updateUser(user);
    }
}
