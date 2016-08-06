package com.luckyryan.sample.service;

import com.luckyryan.sample.exception.InvalidUserException;
import com.luckyryan.sample.model.SignupForm;

/**
 * User: ryan
 * Date: 2/8/13
 */
public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
