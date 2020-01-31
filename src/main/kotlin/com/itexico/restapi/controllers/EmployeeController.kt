package com.itexico.restapi.controllers

import com.itexico.restapi.models.Employee
import com.itexico.restapi.repositories.EmployeeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("northwind/employees")
class EmployeeController (val employeeRepository: EmployeeRepository) {

    @GetMapping("/")
    fun findAll()
            : ResponseEntity<List<Employee>>
            = ResponseEntity.ok().body(employeeRepository.findAll())

    @GetMapping("/id/{employee_id}")
    fun findById(@Valid @PathVariable("employee_id") employeeId: Int)
            : ResponseEntity<Optional<Employee>>
            = ResponseEntity.ok().body(employeeRepository.findById(employeeId))

    @GetMapping("/email/{email_address}")
    fun findByEmailAddress(@Valid @PathVariable("email_address") emailAddress: String)
            : ResponseEntity<Optional<Employee>>
            = ResponseEntity.ok().body(employeeRepository.findByEmailAddress(emailAddress))

    @GetMapping("/company/{company}/title/{job_title}")
    fun findByCompanyAndJobTitle(@Valid @PathVariable(name = "company") company:String
                                 , @Valid @PathVariable(name = "job_title") jobTitle: String)
            : ResponseEntity<List<Employee>>
            = ResponseEntity.ok().body(employeeRepository.findByCompanyAndJobTitle(company, jobTitle))

    @PostMapping("/")
    fun createEntry(@Valid @RequestBody employee: Employee)
            : ResponseEntity<Employee>
            = ResponseEntity.ok().body(employeeRepository.save(employee))
}
