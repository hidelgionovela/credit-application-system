package hdlg.la.credit.application.system.service

import hdlg.la.credit.application.system.entity.Credit
import java.util.*

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID, customerId: Long): Credit
}