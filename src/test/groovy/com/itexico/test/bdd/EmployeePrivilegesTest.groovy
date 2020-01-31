package com.itexico.test.bdd

import com.itexico.restapi.controllers.EmployeePrivilegesController
import com.itexico.restapi.repositories.EmployeePrivilegesRepository
import com.itexico.test.factories.TestEmployeePrivilegesFacade
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification

class EmployeePrivilegesTest extends Specification{
    def data
    def result
    @Shared EmployeePrivilegesRepository repository
    @Shared EmployeePrivilegesController controller

    def setup() {
        repository = Mock(EmployeePrivilegesRepository)
        controller = new EmployeePrivilegesController(repository)
    }

    def "verify findByEmployeeId"() {
        given: "expected data is set"
            data = TestEmployeePrivilegesFacade.buildEmployeePrivilegesList()
            repository.findByEmployeeId_Id(data[0].employeeId.id) >> data

        when: "actual result is set"
            result = controller.findByEmployeeId(data[0].employeeId.id)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }

    def "verify findByPrivilegeId"() {
        given: "expected data is set"
            data = TestEmployeePrivilegesFacade.buildDuplicatedPrivilegesList()
            repository.findByPrivilegeId_Id(data[0].privilegeId.id) >> data

        when: "actual result is set"
            result = controller.findByPrivilegeId(data[0].privilegeId.id)

        then: "actual result is compared to expected data"
            assert result.statusCode == HttpStatus.OK
            assert result.body == data
    }
}
