package halo.com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import halo.com.example.demo.Employee

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long> {}
