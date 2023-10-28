package hdlg.la.credit.application.system.service

import hdlg.la.credit.application.system.entity.Credit
import hdlg.la.credit.application.system.entity.Customer
import java.util.*

interface ICustomerService {

    fun save(credit: Customer): Customer // retorna customer

    fun findByID(id: Long): Customer // retorna customer

    fun delete(id: Long) // void
}