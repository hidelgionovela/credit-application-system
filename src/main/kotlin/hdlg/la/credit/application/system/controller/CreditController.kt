package hdlg.la.credit.application.system.controller

import hdlg.la.credit.application.system.dto.request.CreditDto
import hdlg.la.credit.application.system.dto.response.CreditView
import hdlg.la.credit.application.system.dto.response.CreditViewList
import hdlg.la.credit.application.system.entity.Credit
import hdlg.la.credit.application.system.service.implement.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.email} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long):
            ResponseEntity<List<CreditViewList>> {
        // Chama o serviço para encontrar todos os créditos associados ao customerId
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId)
            // Converte a lista de entidades Credit para uma lista de DTOs CreditViewList
            .stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())

        // Retorna uma ResponseEntity com a lista de CreditViewList e o status HTTP OK
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(creditCode, customerId)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}