package com.itexico.restapi.repositories

import com.itexico.restapi.models.EmployeePrivileges
import com.itexico.restapi.models.EmployeePrivilegesPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeePrivilegesRepository : JpaRepository<EmployeePrivileges, EmployeePrivilegesPK> {

    /*Encuentra un registro por medio del atributo id del atributo employeeId*/
    fun findByEmployeeId_Id(employeeId: Int): List<EmployeePrivileges>

    /*Encuentra un registro por medio del atributo id del atributo privilgeId*/
    fun findByPrivilegeId_Id(privilegeId: Int): List<EmployeePrivileges>
}
