package com.itexico.restapi.repositories

import com.itexico.restapi.models.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository : JpaRepository<Employee, Int> {

    /*Encuentra un registro por medio del atributo emailAddress*/
    fun findByEmailAddress(emailAddress: String): Optional<Employee>

    /*Encuentra un registro por medio del atributo company y del atributo JobTitle*/
    fun findByCompanyAndJobTitle(company: String, jobTitle:String): List<Employee>
}
