package hdlg.la.credit.application.system.entity

data class Customer (
    val id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    val nuit: String = "",
    var address: Address = Address(),
    var credits: List<Credit> = mutableListOf()
)