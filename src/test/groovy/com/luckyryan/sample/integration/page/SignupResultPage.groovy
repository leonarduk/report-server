package com.luckyryan.sample.integration.page

import geb.Page

class SignupResultPage extends Page {

    static url = "/create"
    static at = { title == "Sample App Sign-up Result Page" }
    static content = {
        heading { $("h1").text() }
    }

}
