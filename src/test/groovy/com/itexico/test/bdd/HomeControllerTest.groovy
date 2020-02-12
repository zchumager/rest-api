package com.itexico.test.bdd

import com.itexico.restapi.controllers.HomeController
import spock.lang.Shared
import spock.lang.Specification

class HomeControllerTest extends Specification{

    @Shared HomeController controller
    @Shared def data

    def setup() {
        controller = new HomeController()
    }

    def "Verify Welcome Message"() {
        given: "expected data is mocked"
            def data = "Welcome to Rest API Kotlin Demo"

        when: "actual result is retrieved from controller"
            def result = controller.home()

        then: "actual result is compared with expected data"
            assert result == data
    }
}
