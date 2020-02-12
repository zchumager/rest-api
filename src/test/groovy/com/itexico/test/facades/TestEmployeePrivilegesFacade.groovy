package com.itexico.test.facades

import com.itexico.restapi.models.EmployeePrivileges
import com.itexico.test.bdd.EmployeePrivilegesTest

class TestEmployeePrivilegesFacade {
    static EmployeePrivileges buildEmployeePrivileges(privilege_id = 1111) {
        return new EmployeePrivileges(
                TestEmployeeFacade.buildEmployee(),
                TestPrivilegeFacade.buildPrivilege(privilege_id)
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
        def employeePrivileges = new ArrayList<EmployeePrivilegesTest>() {{
            add(buildEmployeePrivileges())
            add(buildEmployeePrivileges())
        }}
        return employeePrivileges
    }
}
