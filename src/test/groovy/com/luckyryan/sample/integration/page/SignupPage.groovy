package com.luckyryan.sample.integration.page

import geb.Page

class SignupPage extends Page
{

    static url = "/"
    static at = { title == "Sample App Sign-up Page" }
    static content = {
        heading { $("h1").text() }
        errorHeading { $(".alert-error h4").text() }
        signupForm { $("form[id=signupForm]") }
        emailField { $("input[name=email]") }
        lastNameField { $("input[name=lastName]") }
        firstNameField { $("input[name=firstName]") }
        submitButton(to: SignupResultPage) { $("button[type=submit]") }
    }


}
