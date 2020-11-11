package com.example.karina.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultUserDetailsServiceTest {

    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @Test
    public void loadUserByUserNameHypsilonReturnsUser(){
        assertNotNull(userDetailsService.loadUserByUsername("hypsilon"));
    }

    @Test
    public void loadUserByUserNameASDFGThrowsException(){
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("asdfg"));
    }
}
