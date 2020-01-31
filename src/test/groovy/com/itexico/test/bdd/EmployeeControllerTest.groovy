package com.itexico.test.bdd

import com.itexico.restapi.controllers.EmployeeController
import com.itexico.restapi.repositories.EmployeeRepository
import com.itexico.test.factories.TestEmployeeFacade
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification

class EmployeeControllerTest extends Specification {

    def data
    def result
    @Shared EmployeeRepository repository
    @Shared EmployeeController controller

    def setup() {
        repository = Mock(EmployeeRepository)
        controller = new EmployeeController(repository)
    }

    def "verify findAll"() {
        given: "expected data is set"
             data = TestEmployeeFacade.buildEmployeeList()
            repository.findAll() >> data

        when: "actual result is set"
            result = controller.findAll()

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }

    def "verify findById"() {
        given: "expected data is set"
            data = TestEmployeeFacade.buildEmployee()
            repository.findById(data.id) >> Optional.of(data)

        when: "actual result is set"
            result = controller.findById(data.id)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == Optional.of(data)
    }

    def "verify findByEmailAddress"() {
        given: "expected data is set"
            data = TestEmployeeFacade.buildEmployee()
            repository.findByEmailAddress(data.emailAddress) >> Optional.of(data)

        when: "actual result is set"
            result = controller.findByEmailAddress(data.emailAddress)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == Optional.of(data)
    }

    def "verify findByCompanyAndJobTitle"() {
        given: "expected data is set"
            data = TestEmployeeFacade.buildEmployeeList()
            repository.findByCompanyAndJobTitle(data[0].company, data[0].jobTitle) >> data

        when: "actual result is set"
            result = controller.findByCompanyAndJobTitle(data[0].company, data[0].jobTitle)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }

    def "verify null for missing entry"() {
        given: "expected data is set"
            data == null

        when: "actual result is set"
            result = controller.findById(0)

        then: "actual result is compared to expected data"
            assert result.body == data
    }

    def "create a new employee"() {
        given: "expected data is set"
            data = TestEmployeeFacade.buildEmployee()
            repository.save(data) >> data
        when: "actual result is set"
            result = controller.createEntry(data)
        then: "actual result is compare to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data

    }
}