package com.itexico.restapi.repositories

import com.itexico.restapi.models.Privilege
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PrivilegeRepository : JpaRepository<Privilege, Int>
