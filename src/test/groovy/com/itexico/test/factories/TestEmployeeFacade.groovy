package com.itexico.test.factories

import com.itexico.restapi.models.Employee

class TestEmployeeFacade {

    static Employee buildEmployee(id = 1111) {
        return new Employee(
                id,
                "Test Company",
                "Smith",
                "Jhon",
                "jhon.smith@testmail.com",
                "Test Title",
                "1111111111",
                "2222222222",
                "3333333333",
                "4444444444",
                "Test Address",
                "Test City",
                "Test Province",
                "12345",
                "Test Region",
                "testpage.com",
                "Lorem Ipsum",
                "Test Attachment"
        )
    }

    static List<Employee> buildEmployeeList(ids =[2222, 3333]) {
        def employees = []
        ids.each {
            employees.add(buildEmployee(it))
        }
        return employees
    }
}
