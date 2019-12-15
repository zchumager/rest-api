package com.itexico.restapi.controllers

import com.itexico.restapi.models.Privilege
import com.itexico.restapi.repositories.PrivilegeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("northwind/privileges")
class PrivilegeController(val privilegeRepository: PrivilegeRepository) {

    @GetMapping("/")
    fun findAll()
            : ResponseEntity<List<Privilege>>
            = ResponseEntity.ok().body(privilegeRepository.findAll())

    @GetMapping("/{privilege_id}")
    fun findById(@Valid @PathVariable("privilege_id") privilegeId: Int)
            : ResponseEntity<Optional<Privilege>>
            = ResponseEntity.ok().body(privilegeRepository.findById(privilegeId))

    @PostMapping("/")
    fun createEntry(@Valid @RequestBody privilege: Privilege)
            : ResponseEntity<Privilege>
            = ResponseEntity.ok().body(privilegeRepository.save(privilege))
}
