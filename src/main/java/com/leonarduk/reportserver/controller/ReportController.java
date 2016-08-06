/**
 * ReportController
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
@RequestMapping("/report")
public class ReportController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getReport(@PathVariable final String id, final ModelMap model) {
		model.addAttribute("id", id);
		return "list";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getReports(final ModelMap model) {
		return "list";
	}

}
