package com.barber.api.domain.dtos.request

data class LoginRequestDto (
    var cpfCnpj:String,
    var password:String,
)