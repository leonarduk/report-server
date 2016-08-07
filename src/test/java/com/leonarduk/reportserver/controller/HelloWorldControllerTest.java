/**
 * HelloWorldControllerTest
 *
 * @author ${author}
 * @since 07-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.leonarduk.reportserver.config.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
public class HelloWorldControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Test
	public void getHelloWorld() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/hello"))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.view().name("helloworld"));
	}

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	}

	@Before
	public void setUp() throws Exception {
	}
}
