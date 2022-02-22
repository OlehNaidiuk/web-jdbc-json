package com.naidiuk.webJdbcJson.service;

import com.naidiuk.webJdbcJson.dao.UserDao;
import com.naidiuk.webJdbcJson.dao.UserDaoJDBC;
import com.naidiuk.webJdbcJson.dto.UserDto;
import com.naidiuk.webJdbcJson.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    UserDao userDao = Mockito.mock(UserDaoJDBC.class);
    @InjectMocks
    ClientService clientService = new ClientServiceImpl(userDao);


    @Test
    void testGetUserByIdWithYearsUntilRetirement() {
        //prepare
        assertNotNull(userDao);
        User user = new User();
        user.setName("Gendalf");
        user.setSurname("Seriy");
        user.setSalary(1000);
        user.setWorkExperienceYears(21);
        Mockito.when(userDao.getUserById(1)).thenReturn(user);

        //when
        UserDto userDto = clientService.getUserByIdWithYearsUntilRetirement(1);

        //then

        assertNotNull(userDto);
        assertEquals(9, userDto.getYearsUntilRetirement());
    }
}