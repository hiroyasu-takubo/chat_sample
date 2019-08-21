package halo.com.example.demo

import lombok.Data
import lombok.RequiredArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

//@Data
@Entity
@Table(name="m_emp")
//@RequiredArgsConstructor
public class Employee (

) {
    @Id
    @Column(name="empno")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Long? = null;
    var empname: String? = null;

//    fun getId(): Long? {
//        return id
//    }
//
//    fun setId(id: Long?) {
//        this.id = id
//    }
//
//    fun getEmpname(): String? {
//        return empname
//    }
//
//    fun setEmpname(empname: String?) {
//        this.empname = empname
//    }

}