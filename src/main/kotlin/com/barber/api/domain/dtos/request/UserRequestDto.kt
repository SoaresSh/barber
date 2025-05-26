package com.barber.api.domain.dtos.request

data class UserRequestDto(
    var firstName: String?,
    var lastName:String,
    var email:String,
    var password:String,
    var cpf:String,
    var telefone: String?,
    var endereco: String?,
    var barber:Boolean,
    var profileImage:ByteArray?,
    var horario: String?
)

