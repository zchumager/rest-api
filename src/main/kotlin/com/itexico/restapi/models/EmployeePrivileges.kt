package com.itexico.restapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.*

/**
CREATE TABLE `employee_privileges` (
`employee_id` int(11) NOT NULL,
`privilege_id` int(11) NOT NULL,
PRIMARY KEY (`employee_id`,`privilege_id`),
KEY `employee_id` (`employee_id`),
KEY `privilege_id` (`privilege_id`),
KEY `privilege_id_2` (`privilege_id`),
CONSTRAINT `fk_employee_privileges_employees1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
CONSTRAINT `fk_employee_privileges_privileges1` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
*/

@Entity
@Table(schema = "northwind", name = "employee_privileges")
@IdClass(EmployeePrivilegesPK::class)
data class EmployeePrivileges (
    @Id @JoinColumn(name = "employee_id", referencedColumnName = "id") @ManyToOne
    @JsonProperty("employee_id")
    var employeeId: Employee = Employee(),

    @Id @JoinColumn(name = "privilege_id", referencedColumnName = "id") @ManyToOne
    @JsonProperty("privilege_id")
    var privilegeId: Privilege = Privilege()
)

data class EmployeePrivilegesPK (
    var employeeId: Int = 0,
    var privilegeId: Int = 0
): Serializable
