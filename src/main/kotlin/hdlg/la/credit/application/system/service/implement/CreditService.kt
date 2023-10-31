package hdlg.la.credit.application.system.service.implement

import hdlg.la.credit.application.system.entity.Credit
import hdlg.la.credit.application.system.repository.CreditRepository
import hdlg.la.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository, private val customerService: CustomerService): ICreditService {


    override fun save(credit: Credit): Credit {

//        verificando a existencia
        credit.apply {
            customer = customerService.findByID(credit.customer?.id!!)
        }

//        retornando
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit>  = this.creditRepository.findAllByCustomerID(customerId)

    override fun findByCreditCode(creditCode: UUID, customerId: Long): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode Not Found")

//        if inline
//        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact Admin")

//        If comum
        if (credit.customer?.id == customerId){
            return credit
        }else{
            throw RuntimeException("Contact admin")
        }

    }

}