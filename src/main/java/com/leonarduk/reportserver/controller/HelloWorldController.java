/**
 * HelloWorldController
 * 
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable final String msg, final ModelMap model) {
		model.addAttribute("msg", msg);
		return "helloWorld";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(final ModelMap model) {
		model.addAttribute("msg", "JCG Hello World!");
		return "helloWorld";
	}

}
