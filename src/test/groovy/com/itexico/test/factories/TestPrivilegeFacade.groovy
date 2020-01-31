package com.itexico.test.factories

import com.itexico.restapi.models.Privilege


class TestPrivilegeFacade {

    static Privilege buildPrivilege(id = 1111) {
        return new Privilege(id, "Test Privilege")
    }

    static List<Privilege> buildPrivilegeList(ids = [2222, 3333]) {
        def privileges = []
        ids.each {
            privileges.add(buildPrivilege(it))
        }
        return privileges
    }
}
