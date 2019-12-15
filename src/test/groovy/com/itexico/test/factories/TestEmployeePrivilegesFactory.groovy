package com.itexico.test.factories

import com.itexico.restapi.models.EmployeePrivileges

class TestEmployeePrivilegesFactory {
    static EmployeePrivileges buildEmployeePrivileges(privilege_id = 1111) {
        return new EmployeePrivileges(
                TestEmployeeFactory.buildEmployee(),
                TestPrivilegeDataFactory.buildPrivilege(privilege_id)
        )
    }

    static List<EmployeePrivileges> buildEmployeePrivilegesList(privilege_ids = [2222, 3333]) {
        def employeePrivileges = []
        privilege_ids.each {
            employeePrivileges.add(buildEmployeePrivileges(it))
        }
        return employeePrivileges
    }

    static List<EmployeePrivileges> buildDuplicatedPrivilegesList() {
        def employeePrivileges = new ArrayList<com.itexico.test.bdd.EmployeePrivileges>() {{
            add(buildEmployeePrivileges())
            add(buildEmployeePrivileges())
        }}
        return employeePrivileges
    }
}
