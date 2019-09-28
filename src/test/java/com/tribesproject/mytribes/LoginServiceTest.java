package com.tribesproject.mytribes;

import com.tribesproject.mytribes.appuser.TribeUser;
import com.tribesproject.mytribes.appuser.UserRepository;
import com.tribesproject.mytribes.appuser.LoginServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceTest {

  @InjectMocks
  private LoginServiceImpl loginServiceImpl;

  @Mock
  private UserRepository userRepository;
//
//  @Before
//  public void initSetup() {
//    this.loginServiceImpl = new LoginServiceImpl(userRepository);
//  }

  @Test
  public void findUserTest() {
    Mockito.when(userRepository.findUserByUsername(any())).thenReturn(new TribeUser("dani", "123"));
    TribeUser dani = loginServiceImpl.findUserByUsername("dani");
    Assert.assertEquals(new TribeUser("dani", "123").getUsername(),dani.getUsername());
  }
}
