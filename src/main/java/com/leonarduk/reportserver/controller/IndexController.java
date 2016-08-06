/**
 * IndexController
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luckyryan.sample.exception.InvalidUserException;
import com.luckyryan.sample.model.SignupForm;
import com.luckyryan.sample.service.SampleService;

@Controller
public class IndexController {

	public static final String	PAGE_INDEX	= "index";
	public static final String	PAGE_SHOW	= "show";

	@Autowired
	SampleService sampleService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(final Model model, @Valid final SignupForm signupForm,
	        final BindingResult result) {

		String returnPage = IndexController.PAGE_INDEX;

		if (!result.hasErrors()) {
			try {
				model.addAttribute("signupForm", this.sampleService.saveFrom(signupForm));
				returnPage = IndexController.PAGE_SHOW;
			}
			catch (final InvalidUserException e) {
				model.addAttribute("page_error", e.getMessage());
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView(IndexController.PAGE_INDEX, "signupForm", new SignupForm());
	}

	@RequestMapping(value = "/security-error", method = RequestMethod.GET)
	public String securityError(final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("page_error",
		        "You do have have permission to do that!");
		return "redirect:/";
	}
}
