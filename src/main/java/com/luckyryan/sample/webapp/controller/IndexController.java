package com.luckyryan.sample.webapp.controller;

import com.luckyryan.sample.exception.InvalidUserException;
import com.luckyryan.sample.model.SignupForm;
import com.luckyryan.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * User: ryan
 * Date: 2/7/13
 */
@Controller
public class IndexController {

    public static final String PAGE_INDEX = "index";
    public static final String PAGE_SHOW = "show";

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView(PAGE_INDEX, "signupForm", new SignupForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @Valid SignupForm signupForm, BindingResult result) {

        String returnPage = PAGE_INDEX;

        if (!result.hasErrors()) {
            try {
                model.addAttribute("signupForm", sampleService.saveFrom(signupForm));
                returnPage = PAGE_SHOW;
            } catch (InvalidUserException e) {
                model.addAttribute("page_error", e.getMessage());
            }
        }
        return returnPage;
    }

    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}


