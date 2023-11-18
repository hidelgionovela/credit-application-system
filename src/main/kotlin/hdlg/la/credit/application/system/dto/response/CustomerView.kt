package hdlg.la.credit.application.system.dto.response

import hdlg.la.credit.application.system.entity.Customer

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val nuit: String,
    val email: String,
    val zipCode: String,
    val street: String,
    val id: Long?,
    val income: String
) {
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        nuit = customer.nuit,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
        id = customer.id,
        income = customer.income
    )
}