package hdlg.la.credit.application.system.dto.request

import hdlg.la.credit.application.system.entity.Credit
import hdlg.la.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    // Valor de credito
    @field:NotNull(message = "Invalid input") val creditValue: BigDecimal,
//    data da primeira parcela
    @field:Future val dayFirstOfInstallment: LocalDate,
//    Numero de parcelas
    @field:Min(value = 1) @field:Max(value = 48) val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid input") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}