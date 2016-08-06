package com.luckyryan.sample.webapp.controller;

import com.luckyryan.sample.model.SignupForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:applicationContext-dao.xml"})
public class IndexControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetSignupForm() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attribute("signupForm", any(SignupForm.class)));


    }

    @Test
    public void testCreateSignupFormErrors() throws Exception {

        this.mockMvc.perform(post("/create")
                .param("email", "<error>")
                .param("firstName", "<error>")
                .param("lastName", "<error>"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attributeHasFieldErrors("signupForm", "email"));

    }

    @Test
    public void testCreateSignupFormInvalidUser() throws Exception {

        this.mockMvc.perform(post("/create")
                .param("email", "mvcemail@test.com")
                .param("firstName", "dave")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attributeExists("page_error"));

    }

    @Test
    public void testCreateSignupForm() throws Exception {
        this.mockMvc.perform(post("/create")
                .param("email", "mvcemail@test.com")
                .param("firstName", "mvcfirstname")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_SHOW))
                .andExpect(model().attribute("signupForm", any(SignupForm.class)));

    }

    @Test
    public void testSecurityError() throws Exception {
        this.mockMvc.perform(get("/security-error"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"))
                .andExpect(flash().attributeExists("page_error"));
    }
}
