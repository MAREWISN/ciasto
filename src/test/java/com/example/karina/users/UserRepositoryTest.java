package com.example.karina.users;

import com.example.karina.model.users.Role;
import com.example.karina.model.users.RoleRepository;
import com.example.karina.model.users.User;
import com.example.karina.model.users.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveTest(){
        User user = new User();
        Role role = roleRepository.getOne(1L);
        user.setId(1L);
        user.setPassword("123412534");
        user.setUsername("hypsilon");
        user.setRole(role);
        userRepository.save(user);
        assertNotNull(userRepository.findByUsername("hypsilon"));
    }
}