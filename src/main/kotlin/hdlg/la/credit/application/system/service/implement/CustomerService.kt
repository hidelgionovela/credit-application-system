package hdlg.la.credit.application.system.service.implement

import hdlg.la.credit.application.system.entity.Customer
import hdlg.la.credit.application.system.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import hdlg.la.credit.application.system.service.ICustomerService as ICustomerService1

@Service
class CustomerService(private  val customerRepository: CustomerRepository): ICustomerService1 {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findByID(id: Long): Customer =
            this.customerRepository.findById(id).orElseThrow{
                throw  RuntimeException("Id $id not found")
            }


//    override fun delete(id: Long) {
//        this.customerRepository.deleteById(id)
//    }   Mesmo Codigo inline

        override fun delete(id: Long) = this.customerRepository.deleteById(id)

}