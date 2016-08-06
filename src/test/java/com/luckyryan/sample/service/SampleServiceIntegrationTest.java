package com.luckyryan.sample.service;


import com.luckyryan.sample.dao.UserDao;
import com.luckyryan.sample.dao.model.User;
import com.luckyryan.sample.model.SignupForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:SampleServiceIntegrationTest-context.xml"})
public class SampleServiceIntegrationTest {

    @Autowired
    @Qualifier("userDaoMock")
    UserDao userDao;

    @Autowired
    SampleService sampleService;

    @Test
    public void testSaveForm() {
        SignupForm signupForm = new SignupForm();
        signupForm.setLastName("formLast");
        signupForm.setFirstName("formFirst");
        signupForm.setEmail("form@test.com");

        when(userDao.save(any(User.class)))
                .thenAnswer(new Answer<User>() {
                    @Override
                    public User answer(InvocationOnMock invocation) throws Throwable {
                        User user = (User) invocation.getArguments()[0];
                        user.setId(9999L);
                        return user;
                    }
                });

        assertNull(signupForm.getId());

        signupForm = sampleService.saveFrom(signupForm);
        System.out.println(signupForm.getId());
        assertNotNull(signupForm.getId());
        assertTrue(signupForm.getId() > 0);

    }


}
