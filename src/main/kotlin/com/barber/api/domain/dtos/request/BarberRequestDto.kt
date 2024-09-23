package com.barber.api.domain.dtos.request

data class BarberRequestDto(
    var firstName:String,
    var lastName:String,
    //var birthdate:String,
    var email:String,
    var password:String,
    var cpf:String
)
