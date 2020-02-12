package com.itexico.test.bdd

import com.itexico.restapi.controllers.EmployeeController
import com.itexico.restapi.repositories.EmployeeRepository
import com.itexico.test.facades.TestEmployeeFacade
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification

class EmployeeControllerTest extends Specification {

    def expected_result
    def actual_result
    @Shared EmployeeRepository repository
    @Shared EmployeeController controller

    def setup() {
        repository = Mock(EmployeeRepository)
        controller = new EmployeeController(repository)
    }

    def "verify findAll"() {
        given: "expected data is mocked"
             expected_result = TestEmployeeFacade.buildEmployeeList()
            repository.findAll() >> expected_result

        when: "actual result is retrieved from controller"
            actual_result = controller.findAll()

        then: "actual result is compared to expected data"
            assert actual_result.statusCode == HttpStatus.OK
            assert actual_result.body == expected_result
    }

    def "verify findById"() {
        given: "expected data is mocked"
            expected_result = TestEmployeeFacade.buildEmployee()
            repository.findById(expected_result.id) >> Optional.of(expected_result)

        when: "actual result is retrieved from controller"
            actual_result = controller.findById(expected_result.id)

        then: "actual result is compared to expected data"
            assert actual_result.statusCode == HttpStatus.OK
            assert actual_result.body == Optional.of(expected_result)
    }

    def "verify findByEmailAddress"() {
        given: "expected data is mocked"
            expected_result = TestEmployeeFacade.buildEmployee()
            repository.findByEmailAddress(expected_result.emailAddress) >> Optional.of(expected_result)

        when: "actual result is retrieved from controller"
            actual_result = controller.findByEmailAddress(expected_result.emailAddress)

        then: "actual result is compared to expected data"
            assert actual_result.statusCode == HttpStatus.OK
            assert actual_result.body == Optional.of(expected_result)
    }

    def "verify findByCompanyAndJobTitle"() {
        given: "expected data is mocked"
            expected_result = TestEmployeeFacade.buildEmployeeList()
            repository.findByCompanyAndJobTitle(expected_result[0].company, expected_result[0].jobTitle) >> expected_result

        when: "actual result is retrieved from controller"
            actual_result = controller.findByCompanyAndJobTitle(expected_result[0].company, expected_result[0].jobTitle)

        then: "actual result is compared to expected data"
            assert actual_result.statusCode == HttpStatus.OK
            assert actual_result.body == expected_result
    }

    def "verify null for missing entry"() {
        given: "expected data is mocked"
            expected_result == null

        when: "actual result is retrieved from controller"
            actual_result = controller.findById(0)

        then: "actual result is compared to expected data"
            assert actual_result.body == expected_result
    }

    def "create a new employee"() {
        given: "expected data is mocked"
            expected_result = TestEmployeeFacade.buildEmployee()
            repository.save(expected_result) >> expected_result
        when: "actual result is retrieved from controller"
            actual_result = controller.createEntry(expected_result)
        then: "actual result is compare to expected data"
            assert actual_result.statusCode == HttpStatus.OK
            assert actual_result.body == expected_result

    }
}