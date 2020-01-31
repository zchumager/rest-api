package com.itexico.restapi.controllers;

import com.itexico.restapi.models.EmployeePrivileges
import com.itexico.restapi.repositories.EmployeePrivilegesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid

@RestController
@RequestMapping("/northwind/employee_privileges")
public class EmployeePrivilegesController(
    val employeePrivilegesRepository: EmployeePrivilegesRepository) {

    @GetMapping("employee_id/{employee_id}")
    fun findByEmployeeId(@Valid @PathVariable("employee_id") employeeId: Int)
            : ResponseEntity<List<EmployeePrivileges>>
            = ResponseEntity.ok().body(employeePrivilegesRepository.findByEmployeeId_Id(employeeId))

    @GetMapping("privilege_id/{privilege_id}")
    fun findByPrivilegeId(@Valid @PathVariable("privilege_id") privilegeId: Int)
            : ResponseEntity<List<EmployeePrivileges>>
            = ResponseEntity.ok().body(employeePrivilegesRepository.findByPrivilegeId_Id(privilegeId))
}
