package com.luckyryan.sample.webapp.controller;

import com.luckyryan.sample.exception.InvalidUserException;
import com.luckyryan.sample.model.SignupForm;
import com.luckyryan.sample.service.SampleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexControllerTest {

    @Mock
    private SampleService sampleService;

    @InjectMocks
    private IndexController indexController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    }

    @Test
    public void testCreateSignupFormInvalidUser() throws Exception {

        when(sampleService.saveFrom(any(SignupForm.class)))
                .thenThrow(new InvalidUserException("For Testing"));

        this.mockMvc.perform(post("/create")
                .param("email", "mvcemail@test.com")
                .param("firstName", "mvcfirst")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attributeExists("page_error"));

    }

    @Test(expected = NestedServletException.class)
    public void testCreateSignupFormRuntimeException() throws Exception {

        when(sampleService.saveFrom(any(SignupForm.class)))
                .thenThrow(new RuntimeException("For Testing"));

        this.mockMvc.perform(post("/create")
                .param("email", "mvcemail@test.com")
                .param("firstName", "mvcfirst")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
                .andExpect(model().attributeExists("page_error"));

    }

}
