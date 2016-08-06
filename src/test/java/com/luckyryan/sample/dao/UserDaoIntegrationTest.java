package com.luckyryan.sample.dao;


import com.luckyryan.sample.config.appConfig;
import com.luckyryan.sample.config.dbConfig;
import com.luckyryan.sample.dao.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes={dbConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserDaoIntegrationTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("unitTest@test.com");
        user.setFirstName("unitTestFirstName");
        user.setLastName("unitTestLastName");

        assertNull(user.getId());

        user =  userDao.save(user);

        assertNotNull(user.getId());
        assertTrue(user.getId() > 0);

    }

}
