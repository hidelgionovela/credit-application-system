package hdlg.la.credit.application.system.repository

import hdlg.la.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

//    Dependendo do JPA para pegar credit by creditcode
    fun findByCreditCode(creditCode: UUID): Credit?

//     usando o nativequery (?1 = referencia o parametro)
    @Query(value = "SELECT * FROM Credit WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerID(customerId: Long): List<Credit>
}