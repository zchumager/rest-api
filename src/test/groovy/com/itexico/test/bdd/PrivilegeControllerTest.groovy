package com.itexico.test.bdd

import com.itexico.restapi.controllers.PrivilegeController
import com.itexico.restapi.repositories.PrivilegeRepository
import com.itexico.test.factories.TestPrivilegeFacade
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification

class PrivilegeControllerTest extends Specification{
    def data
    def result
    @Shared PrivilegeRepository repository
    @Shared PrivilegeController controller

    def setup() {
        repository = Mock(PrivilegeRepository)
        controller = new PrivilegeController(repository)
    }

    def "Verify findAll"() {
        given: "expected data is set"
            data = TestPrivilegeFacade.buildPrivilegeList()
            repository.findAll() >> data

        when: "actual result is set"
            result = controller.findAll()

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }

    def "verify findById"() {
        given: "expected data is set"
            data = TestPrivilegeFacade.buildPrivilege()
            repository.findById(data.id) >> Optional.of(data)

        when: "actual result is set"
            result = controller.findById(data.id)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == Optional.of(data)
    }

    def "Verify createEntry"() {
        given: "expected data is set"
            data = TestPrivilegeFacade.buildPrivilege()
            repository.save(data) >> data

        when: "actual result is set"
            def result = controller.createEntry(data)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }

    def "Verify null for missing entry"() {
        given: "expected data is set"
            data = null

        when: "actual result is set"
            result = controller.findById(0)

        then: "actual result is compared to expected data"
            assert result.body == data
    }
}
