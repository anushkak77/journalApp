package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.*;
import java.util.ArrayList;

import static org.mockito.Mockito.when;


@ActiveProfiles("dev")
public class UserDetailsServiceImplTest {

    @InjectMocks // it will inject the mock into service.
    private UserDetailsServiceImpl userDetailsService;

//    @MockBean  //mockbin replaces real objects to a fake one.
    @Mock  // it will not create but replace the fake object.
    private UserRepository userRepository;


    // @Mock works outside Spring and needs Mockito initialization.
    // When you use annotations like @Mock or @InjectMocks, those fields don’t magically get values — by default, they remain null unless you tell Mockito to set them up.

    @BeforeEach  // we wre initializing mock here
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("anushka").password("gvdgavs").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("anushka");
        Assertions.assertNotNull(user);
    }
}
