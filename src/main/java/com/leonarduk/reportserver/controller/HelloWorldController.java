/**
 * HelloWorldController
 *
 * @author ${author}
 * @since 07-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello(
	        @RequestParam(value = "name", required = false, defaultValue = "World!!") final String name,
	        final Model model) {

		model.addAttribute("name", name);
		// returns the view name - so expects file called /WEB-INF/views/helloworld.jsp
		// /WEB-INF/views is from dispatcher-servlet.xml
		return "helloworld";

	}

}
