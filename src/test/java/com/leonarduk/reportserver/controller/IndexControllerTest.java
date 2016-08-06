/**
 * IndexControllerTest
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.luckyryan.sample.service.SampleService;

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
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.indexController).build();

	}

	// @Test
	// public void testCreateSignupFormInvalidUser() throws Exception {
	//
	// when(this.sampleService.saveFrom(any(SignupForm.class)))
	// .thenThrow(new InvalidUserException("For Testing"));
	//
	// this.mockMvc
	// .perform(post("/create").param("email", "mvcemail@test.com")
	// .param("firstName", "mvcfirst").param("lastName", "mvclastname"))
	// .andExpect(status().isOk()).andExpect(forwardedUrl(IndexController.PAGE_INDEX))
	// .andExpect(model().attributeExists("page_error"));
	//
	// }
}
