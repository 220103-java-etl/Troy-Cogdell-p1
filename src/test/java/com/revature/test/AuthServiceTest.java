/*package com.revature.test;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repository.UserDAO;
import com.revature.service.AuthService;
import com.revature.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AuthServiceTest {

    private static AuthService authService;
    private static UserService userService;
    private static UserDAO userDAO;

    private User EMPLOYEE_TO_REGISTER;
    private User GENERIC_EMPLOYEE_1;
    private User GENERIC_FINANCE_MANAGER_1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        authService = new AuthService();
        userService = Mockito.mock(UserService.class);
        userDAO = Mockito.mock(UserDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        EMPLOYEE_TO_REGISTER = new User(0, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
        GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
        GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
    }
}

    @Test
    public void testRegisterFailsWhenUsernameIsTaken() {
        Mockito.when(userService.getByUsername(Matchers.anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        Assert.assertThrows(UsernameNotUniqueException.class,
                () -> authService.register(EMPLOYEE_TO_REGISTER)
        );

        Mockito.verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
        Mockito.verify(userDAO, Mockito.never()).create(EMPLOYEE_TO_REGISTER);
    }

    @Test
    public void testRegisterPassesWhenUsernameIsNotTaken() {
        Mockito.when(userService.getByUsername(Matchers.anyString())).thenReturn(Optional.empty());
        Mockito.when(userDAO.create(Matchers.anyObject())).thenReturn(GENERIC_EMPLOYEE_1);

        assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));

        Mockito.verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
        Mockito.verify(userDAO).create(EMPLOYEE_TO_REGISTER);
    }

    @Test
    public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
        Mockito.when(userDAO.create(Matchers.anyObject())).thenThrow(new RegistrationUnsuccessfulException());

        Assert.assertThrows(RegistrationUnsuccessfulException.class,
                () -> authService.register(EMPLOYEE_TO_REGISTER)
        );
    }

    @Test
    public void testRegisterFailsWhenIdIsNonZero() {
        EMPLOYEE_TO_REGISTER.setId(1000);

        Assert.assertThrows(NewUserHasNonZeroIdException.class,
                () -> authService.register(EMPLOYEE_TO_REGISTER)
        );
    }

    @Test
    public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() {
        Mockito.when(userService.getByUsername(Matchers.anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        assertEquals(GENERIC_EMPLOYEE_1, authService.login(GENERIC_EMPLOYEE_1.getUsername(), GENERIC_EMPLOYEE_1.getPassword()));

        Mockito.verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
    }
}*/
