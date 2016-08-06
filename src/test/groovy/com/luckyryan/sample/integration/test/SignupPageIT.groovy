package com.luckyryan.sample.integration.test

import com.luckyryan.sample.integration.page.SignupPage
import com.luckyryan.sample.integration.page.SignupResultPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class SignupPageIT extends GebReportingSpec {

    def "Signup Test Happy Path"() {

        given: "I'm at the sign up form"
        to SignupPage

        when: "I signup as a valid user"
        emailField = "geb@test.com"
        firstNameField = "firstname"
        lastNameField = "lastname"
        submitButton.click()

        then: "I'm at the result page "
        at SignupResultPage

    }

    def "Signup Test for Invalid User"() {

        given: "I'm at the sign up form"
        to SignupPage

        when: "I signup as an invalid user"
        emailField = "geb@test.com"
        firstNameField = "dave"
        lastNameField = "lastname"
        submitButton.click(SignupPage)

        then: "I'm at the sign up page again "
        at SignupPage
        errorHeading == "Error!"


    }


}
