package com.halo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.halo.model.Employee

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long> {}
