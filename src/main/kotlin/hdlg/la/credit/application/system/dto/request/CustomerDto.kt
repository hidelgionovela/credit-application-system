package hdlg.la.credit.application.system.dto.request

import hdlg.la.credit.application.system.entity.Address
import hdlg.la.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerDto (
    val firstName: String,
    val lastName: String,
    val nuit: String,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
    val income: BigDecimal,
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        nuit = this.nuit,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
