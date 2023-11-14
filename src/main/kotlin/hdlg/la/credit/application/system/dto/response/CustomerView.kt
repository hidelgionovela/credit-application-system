package hdlg.la.credit.application.system.dto.response

import hdlg.la.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val nuit: String,
    val email: String,
    val zipCode: String,
    val street: String,
    val id: Long?
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        nuit = customer.nuit,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
        id = customer.id
    )
}