package com.barber.api.domain.dtos.response

data class BarberResponseDto(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    //var birthdate:String,
    val email: String?,
    val password: String,
    val cpf: String,
)
