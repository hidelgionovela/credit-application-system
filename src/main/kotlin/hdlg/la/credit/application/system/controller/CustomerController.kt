package hdlg.la.credit.application.system.controller

import hdlg.la.credit.application.system.dto.request.CustomerDto
import hdlg.la.credit.application.system.dto.request.CustomerUpdateDto
import hdlg.la.credit.application.system.dto.response.CustomerView
import hdlg.la.credit.application.system.entity.Customer
import hdlg.la.credit.application.system.service.implement.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String{
        val customerSaved = this.customerService.save(customerDto.toEntity())
        return "Customer ${customerSaved.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView{
        val customer: Customer = this.customerService.findByID(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id:Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long, @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{
        val customer: Customer = this.customerService.findByID(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer =  this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }


}