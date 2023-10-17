package hdlg.la.credit.application.system.repository

import hdlg.la.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}