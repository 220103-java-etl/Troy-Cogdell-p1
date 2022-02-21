/*package com.revature.test;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repository.UserDAO;
import com.revature.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private static UserService userService;
    private static UserDAO userDAO;

    private User GENERIC_EMPLOYEE_1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        userService = new UserService();
        userDAO = mock(UserDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
    }
}
    @Test
    public void testGetByUsernamePassesWhenUsernameExists() {
        when(userDAO.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), userService.getByUsername(GENERIC_EMPLOYEE_1.getUsername()));

        verify(userDAO).getByUsername(GENERIC_EMPLOYEE_1.getUsername());
    }
}*/
